package elice;

import java.util.Scanner;

public class StopWatch { 

    private final long start;

    /**
     * Initializes a new stopWatch.
     */
    public StopWatch() {
        start = System.currentTimeMillis();
    } 


    /**
     * Returns the elapsed CPU time (in seconds) since the stopWatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopWatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
