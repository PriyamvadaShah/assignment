package Speed;

public class RunTime {

    private long startTime;

    public RunTime() {
        startTime = 0;
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        long end = System.nanoTime();
        double ms = (end - startTime) / 1_000_000.0;
        System.out.println("Runtime in millisecond is " + ms);
    }
}
