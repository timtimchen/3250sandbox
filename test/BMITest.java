import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BMITest {
  @Test
  public void calculateBMITest() {
    double expected = 21.52253815221916;
    BMI b = new BMI();
    assertEquals(expected, b.calculateBMI(150,5,10));
    expected = 0.0;
    assertEquals(expected, b.calculateBMI(1,0,0));
  }
}
