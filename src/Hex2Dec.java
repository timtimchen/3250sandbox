import java.util.Scanner;

/**
 * A class convert a Hex string to a integer number.
 */
public class Hex2Dec {

  /** a constant character represent A in Hex. */
  private static final char HEX_A_CHAR = 'A';
  /** a constant character represent F in Hex. */
  private static final char HEX_F_CHAR = 'F';
  /** a constant character represent 0 in Hex. */
  private static final char HEX_ZERO_CHAR = '0';
  /** a constant character represent 9 in Hex. */
  private static final char HEX_NINE_CHAR = '9';
  /** a constant integer for the base of Hex. */
  private static final int HEX_BASE = 16;
  /** a constant integer for A in Hex. */
  private static final int HEX_A = 10;

  /**
   * Convert a string of Hex to a integer number.
   * @param hex a string of Hexadecimal
   * @return the integer result of converting
   */
  public int hexToDecimal(final String hex) {
    int decimalValue = 0;
    for (int i = 0; i < hex.length(); i++) {
      char hexChar = hex.toUpperCase().charAt(i);
      decimalValue = decimalValue * HEX_BASE + hexCharToDecimal(hexChar);
    }

    return decimalValue;
  }

/**
 * Convert a single character to a integer number.
 * @param ch a character for convert
 * @return the integer result of the converted character
 */
  private int hexCharToDecimal(final char ch) {
    if (HEX_A_CHAR <= ch && ch <= HEX_F_CHAR) {
      return HEX_A + ch - HEX_A_CHAR;
    } else if (HEX_ZERO_CHAR <= ch && ch <= HEX_NINE_CHAR) {
      // ch is '0', '1', ..., or '9'
      return ch - HEX_ZERO_CHAR;
    } else {
      return 0;
    }
  }

  /**
   * Main method.
   * @param args arguments string from command line
   */
  public static void main(final String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    // Create a object
    Hex2Dec converter = new Hex2Dec();

    // Prompt the user to enter a string
    System.out.print("Enter a hex number: ");
    String hex = input.nextLine();

    System.out.println("The decimal value for hex number "
      + hex + " is " + converter.hexToDecimal(hex.toUpperCase()));
  }
}
