// Group work by Chergang Chang and Jinghong Chen

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class StreamEx3 {

  public void randomNumberStream() throws IOException {
    Random random = new Random();
    IntStream intStream = random.ints(0, 1000000);
    int[] list = intStream.limit(10000).toArray();
    try (FileWriter fileWriter = new FileWriter("output.csv")) {
      StringBuilder sb = new StringBuilder();
      IntStream.of(list).forEach(e -> sb.append(e).append("\n"));
      fileWriter.append(sb.toString());
      IntSummaryStatistics stats = IntStream.of(list).summaryStatistics();
      fileWriter.append("\nMin:\n" + + stats.getMin() + "\nMax:\n" + stats.getMax() + "\nAvg:\n" + Math.round(stats.getAverage()));
    }
  }

  public static void main(String[] args) {
    StreamEx3 streamEx = new StreamEx3();
    // Exercise 3
    try {
      streamEx.randomNumberStream();
    } catch (IOException e) {
      System.out.println("Writing csv file failed.");
      e.printStackTrace();
    }

  }
}
