package elice;


public class QueueNode<E> implements Queue<E> {
	private Node<E> first;    // beginning of queue
    private Node<E> last;     // end of queue
    private int n;               // number of elements on queue

    // Nested class
    private static class Node<E> {
        private E item;
        private Node<E> next;
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
     * Return null if this queue is empty
     */
    public E first() {
        if (isEmpty()) return null;
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
     * Return null if this queue is empty
     */
    public E dequeue() {
        if (isEmpty()) return null; //nothing to remove.
        E item = first.item;
        first = first.next; //will become null if the queue had only one item.
        n--;
        if (isEmpty()) last = null;   // special case as the queue is now empty. 
        return item;
    } 

   public void traverse() {
	   Node<E> walk = first;
	   for(Node<E> x = walk; x!= null; x=x.next)
		   System.out.println(x.item);
   }
}

