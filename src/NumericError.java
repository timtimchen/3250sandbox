public class NumericError {
  public static void main(String[] args) {
    double sum = 0.0f;
    for (int i = 0; i <= 100; i ++) {
      sum += i;
    }
    System.out.printf("%f\n", sum/100);
  }
}
