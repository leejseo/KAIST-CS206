package elice;

import java.util.*;

public class DistinctQueue {
	private QueueNode<Integer> queue = new QueueNode<>();
    //implement here
	private HashMap m = new HashMap();
	
	/** Constructs an initially empty queue. */
	public DistinctQueue(){}
	
	public void enqueue(Integer n) {
    	//implement here
		if (m.containsKey(n)) return;
		m.put(n, -1);
		queue.enqueue(n);
	}
	
	public Integer dequeue() {
    //implement here
		Integer ret = queue.dequeue();
		m.remove(ret);
		return ret;
	}
	
	public int size() {
		return queue.size();
	}
	
	public void show() {
		queue.traverse();
	}
}
