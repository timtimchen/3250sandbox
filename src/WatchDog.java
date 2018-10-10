public class WatchDog {

  private long endTime;
  private long startTime;

  public WatchDog() {
    this.startTime = System.currentTimeMillis();
  }

  public WatchDog(long startTime) {
    this.startTime = startTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public long getStartTime() {
    return startTime;
  }

  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  public void start() {
    this.startTime = System.currentTimeMillis();
  }

  public void stop() {
    this.endTime = System.currentTimeMillis();
  }

  public long getElapsedTime() {
    return endTime - startTime;
  }

}
