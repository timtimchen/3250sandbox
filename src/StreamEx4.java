// Group work by Chergang Chang and Jinghong Chen

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class StreamEx4 {

  public void readWordAndCount() throws IOException {
    Path textFilePath = Paths.get("data.txt");
    try (Stream<String> fileLines = Files.lines(textFilePath, Charset.defaultCharset())) {
      HashMap<String, Integer> countByword =
        fileLines.flatMap(line -> Arrays.stream(line.split("\\s+")))
          .map(String::toLowerCase)
          .reduce(new HashMap<>(), (acc, entry) -> {
            acc.put(entry, acc.compute(entry, (k, v) -> v == null ? 1 : v + 1));
            return acc;
          }, (m1, m2) -> m1);

      System.out.println("First 15 words in alphabetical order:");
      countByword.entrySet()
        .stream()
        .filter(e -> e.getKey().matches("[a-z].*"))
        .sorted(Comparator.comparing(Map.Entry::getKey))
        .limit(15)
        .forEach(entry -> System.out.printf("%s : %d \n", entry.getKey(), entry.getValue()));

      System.out.println("\nTop 15 words in frequency:");
      countByword.entrySet()
        .stream()
        .filter(e -> e.getKey().matches("[a-z].*"))
//        .sorted(Comparator.comparing(Map.Entry::getValue).reversed())
        .sorted((e1, e2) -> {
          if (e1.getValue() == e2.getValue()) return 0;
          if (e1.getValue() < e2.getValue()) return 1;
          else return -1;
        })
        .limit(15)
        .forEach(entry -> System.out.printf("%s : %d \n", entry.getKey(), entry.getValue()));
    }
  }

  public static void main(String[] args) {
    StreamEx4 streamEx = new StreamEx4();
    // Exercise 4
    try {
      streamEx.readWordAndCount();
    } catch (IOException e) {
      System.out.println("Reading data file failed.");
      e.printStackTrace();
    }
  }
}
