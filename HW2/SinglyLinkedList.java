package elice;
/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> {
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of the SinglyLinkedList
  /** The head node of the list */
  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list

  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    head = new Node<>(e, head);              // create and link a new node
    if (size == 0)
      tail = head;                           // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
    if (isEmpty())
      head = newest;                         // special case: previously empty list
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    size++;
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    E answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    return answer;
  }
  
  //Problem 1
  public E removeLast() {
     //implement here.
     if (isEmpty()) return null;
     E answer = tail.getElement();
	 --size;
	 if (head == tail){
	 	head = null; tail = null;
		return answer;
	 }
     Node<E> prev = null;
     for (Node<E> x = head; x != tail; x = x.next){
        prev = x;
     }
     prev.next = null;
	 tail = prev;
     return answer;
  }
  
  //Problem 2
  //implement the method that reverses the linked list
  //Do not create an additional list. 
  //Do not use the addFirst() method.
  //If you create an additional list or use the addFirst() method, you will get a zero on this problem.
  public void reverse() {
	  //implement here.
      if (head == tail) return;
      Node<E> x = head;
      Node<E> y = x.next;
      while (y != null){
        Node<E> z = y.next;
        y.next = x;
        x = y;
        y = z;
      }
      head.next = null;
      x = tail;
      tail = head;
      head = x;
  }
  
  //Problem 3
  //sequential search in a linked list
  public boolean contains(E element) {
	  //implement here.
      for (Node<E> x = head; x != null; x = x.next){
	  	if (x.element == element) return true;
	  }
	  return false;
  }
  
  //Problem 4
  //recursive search in a linked list
  //Do not modify part of the code given in this problem.
  //If your code does not use recursion, you will get a zero on this problem.
  public boolean contains_rc(E element) {
	  //implement here.
	  return contains_rc(head, element);
  }
  //Recursive helper method with additional parameters
  private boolean contains_rc(Node<E> node, E element) {
	  //implement here
	  if (node == null) return false;
	  if (node.element == element) return true;
	  return contains_rc(node.next, element);
  }
  
  //Problem 5
  //implement the method that counts the number of times a particular value appears in the list
  public int count(E element) {
	 //implement here.
	 int ret = 0;
	 for (Node<E> x = head; x != null; x = x.next){
	 	if (x.element == element) ++ret;
	 }
	 return ret;
  }
  
  
  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
}
