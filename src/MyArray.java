import java.util.ArrayList;

public class MyArray {
  public static void main(String[] args) {
    if (args.length >= 2 && args[0].matches("[1-9][0-9]*") && args[0].matches("[1-9][0-9]*")) {
      int n = Integer.parseInt(args[0]);
      int r = Integer.parseInt(args[1]); // range of random numbers
      double sum = 0.0;
      double sq_sum = 0.0;  // for calculating standard deviation
      ArrayList<Integer> distinctArray = new ArrayList<Integer>();  //store the distinct values

//      int[] myArray = new int[n];
      for (int i = 0; i < n; i++) {
        int x = (int)(Math.random() * r) + 1;  // random numbers' range from 1 to r
        sum += x;
        sq_sum += x * x;
        // just store numbers which are distinct. If needed, all numbers can be stored to this Arraylist or a new array.
        if (!distinctArray.contains(x)) {
          distinctArray.add(x);
        }
      }
      double mean = sum / n;
      double variance = sq_sum / n - mean * mean;

      System.out.println("distinct values: " + distinctArray);
      System.out.printf("average value: %d\n", (int)Math.round(mean));
      System.out.printf("standard deviation: %d\n", (int)Math.round(Math.sqrt(variance)));

    } else {
      System.out.println("Please input two positive numbers in command line for n of array and range for random number.");
    }
  }
}
