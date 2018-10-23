import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class MyThreadDemo {

  public static void main(String[] args) {
    Random rand = new Random(2018);
    Deque<Integer> arr = new ArrayDeque<>();

    Thread t1 = new Thread(() -> {
      for (int k = 0; k < 30; k++) {
        int i = rand.nextInt(212);
        arr.push(i);
        System.out.printf("push <%d>\n", i);
      }
    });

    Thread t2 = new Thread(() -> {
      for (int k = 0; k < 30; k++) {
        System.out.printf("pop <%d>\n", arr.poll());
      }
    });

    t1.start();
    t2.start();
  }


}
