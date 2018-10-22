// Group work by Chergang Chang and Jinghong Chen

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class StreamEx1 {

  private boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }

  public List<Integer> primeStream(int max) {
    IntStream infiniteStream = IntStream.iterate(2, i -> i + 1);
    return infiniteStream.limit(max).filter(n -> isPrime(n)).boxed().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    StreamEx1 streamEx = new StreamEx1();
    // Exercise 1
    List<Integer> primes = streamEx.primeStream(1000);
    System.out.println("Prime Numbers:");
    primes.forEach(e -> System.out.println(e));
  }
}
