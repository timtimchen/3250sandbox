import java.util.Random;

public class MyTimer {

  private static final int N = 100000;
  private int[] randomInt = new int[N];

  public MyTimer() {
    Random rand = new Random();
    for (int i = 0; i < N; i++) {
      randomInt[i] = rand.nextInt();
    }
  }

  public void selectionSort() {
    int i, j, min_index, temp;

    for (i = 0; i < N-1; i++)
    {
      // Find the minimum element in unsorted array
      min_index = i;
      for (j = i+1; j < N; j++)
        if (randomInt[j] < randomInt[min_index])
          min_index = j;

      // Swap the found minimum element with the first element
      temp = randomInt[i];
      randomInt[i] = randomInt[min_index];
      randomInt[min_index] = temp;
    }
  }

  public static void main(String[] args) {
    MyTimer myTimer = new MyTimer();
    WatchDog watchDog = new WatchDog();

    watchDog.start();
    myTimer.selectionSort();
    watchDog.stop();

    double runningTimeInSecond =  (watchDog.getElapsedTime() / 10) / 100.0;
    System.out.printf("The running time of selection sort is: %.2f seconds.\n", runningTimeInSecond);
  }
}
