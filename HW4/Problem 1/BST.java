package elice;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated value
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty map.
     */
    public BST() {
    }

    /**
     * Returns true if this map is empty.
     * @return {@code true} if this map is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this map.
     * @return the number of key-value pairs in this map.
     */
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0; //assign 0 to null links.
        else return x.size;
    }
    
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
      
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            
            //replace with successor
            Node t = x;
            x = min(t.right); //set x to its successor min(t.right)
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1; //update subtree count
        return x;
    } 
    
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        root = deleteMin(root);
      
    }

    private Node deleteMin(Node x) {
        //go left until finding a node with a null left link
        if (x.left == null) return x.right; //return that node's right link
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty map");
        return min(root).key;
    } 

    private Node min(Node x) {
        //go left until finding a node with a null left link
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
  }

   /** Inorder traversal from a subtree */
    private void inorder(Node x) {
        if (x == null) return;
        inorder(x.left);
        System.out.print(x.key + " ");
        inorder(x.right);
  }
  
/***********************************
 * Homework Assignment 4
 **********************************/
    /*
    * Returns how many leaves a tree has.
    * If a tree is empty, it has 0 leaves.
    */
    public int leaves() {
    	return leaves(root);
    }
    //helper method
    private int leaves(Node x) {
    	//implement here.
        if (x == null) return 0;
		int ret = 0;
    	if (x.left == null && x.right == null) ++ret;
		ret += leaves(x.left);
		ret += leaves(x.right);
		return ret;
    }
    //The width of a tree is the maximum number of elements on one level of the tree.
    //If a tree is empty, it has 0 width.
    public int width(){
       //implement here.
	   if (root == null) return 0;
	   int ret = 0;
       for (int i=0; i<=root.size; i++) ret = Math.max(ret, width(root, i));
	   return ret;
    }
    //helper method
    private int width(Node x, int num){
		if (x == null) return 0;
		if (num == 0) return 1;
		return width(x.left, num-1)+width(x.right, num-1);
    }

    //The longest distance between two nodes in a tree.
    //We count the number of nodes between two nodes (including those two nodes). --see the test case examples.
    //If a tree is empty, it returns 0. 
    public int maxDistance()
    {
       return maxDistance(root);
    }
    //helper method
    private int maxDistance(Node x){
		if (x == null) return 0;
		int ret = Math.max(maxDistance(x.left), maxDistance(x.right));
		ret = Math.max(ret, maxPath(x));
		ret = Math.max(ret, maxPath(x.left)+maxPath(x.right)+1);
		return ret;
    }
	
	private int maxPath(Node x){
		if (x == null) return 0;
		return 1+Math.max(maxPath(x.left), maxPath(x.right));
	}
    
    public boolean balanced() {
		return balanced(root);
    }
    private boolean balanced(Node x) {
    	if (x == null) return true;
		if (!(balanced(x.left) && balanced(x.right))) return false;
		return Math.abs(maxPath(x.left) - maxPath(x.right)) <= 1;
    }
}
