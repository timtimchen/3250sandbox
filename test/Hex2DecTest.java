import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * A Test Class for the class Hex2Dec.
 */
public class Hex2DecTest {

  /** a test case number. */
  private static final int HEX_ABBC = 43964;
  /** a test case number. */
  private static final int HEX_AF71 = 44913;

  /**
   * Test for function hexToDecimal in Hex2Dec class.
   */
  @Test
  public void hexToDecimalTest() {
    int expected = HEX_ABBC;
    Hex2Dec converter = new Hex2Dec();
    assertEquals(expected, converter.hexToDecimal("ABBC"));
    expected = HEX_AF71;
    assertEquals(expected, converter.hexToDecimal("af71"));
  }
}
