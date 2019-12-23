package elice;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueNode<E> implements Queue<E>, Iterable<E> {
	private Node<E> first;    // beginning of queue
    private Node<E> last;     // end of queue
    private int n;               // number of elements on queue

    // static nested class
    private static class Node<E> {
        private E item;
        private Node<E> next;
        
        public void setNext(Node<E> n) { next = n; }
    }

    /**
     * Initializes an empty queue.
     */
    public QueueNode() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public E first() {
        if (isEmpty()) return null;//throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enqueue(E item) {
        Node<E> oldlast = last;
        last = new Node<E>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public E dequeue() {
        if (isEmpty()) return null; //nothing to remove.
        E item = first.item;
        first = first.next; //will become null if the queue had only one item.
        n--;
        if (isEmpty()) last = null;   // special case as the queue is now empty. 
        return item;
    } 
   
   public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 
   
   //HW3 Problem 5
   public void concatenate(QueueNode<E> q1) {
	   //implement here
	 while (!q1.isEmpty()){
	   enqueue(q1.dequeue());
	 }
   }
   
   
   /**
    * Returns an iterator that iterates over the items in this queue in FIFO order.
    *
    * @return an iterator that iterates over the items in this queue in FIFO order
    */
   public Iterator<E> iterator()  {
       return new QueueIterator(first);  //create a new instance of the inner class
   }

   //HW3 Problem 6: implement an iterator
   // We do not implement remove() for the following reasons:
   // 1) it is optional. 2) More importantly, interleaving iteration with operations that modify the data structure is best avoided. 
   private class QueueIterator implements Iterator<E> {
   //implement here.
	   private Node<E> node;
       public QueueIterator(Node<E> first) {
           //implement here
		   node = first;
	   }

       public boolean hasNext()  { return node != null; }
       public void remove()      { throw new UnsupportedOperationException(); }

       public E next() {
           //implement here
		   E ret = node.item;
		   node = node.next;
		   return ret;
       }      
   }
}
