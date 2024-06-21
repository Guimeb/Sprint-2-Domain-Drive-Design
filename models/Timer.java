package models;

public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    //Getter e setter
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}