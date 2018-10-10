import java.util.Random;

public class MyUnicode {

  static final char BASIC_LATIN_BEGIN = '\u0020';
  static final char BASIC_LATIN_END = '\u007E';
  static final char SUPPLY_LATIN_BEGIN = '\u00A0';
  static final char SUPPLY_LATIN_END = '\u00FF';
  static final int n = 10;  // size of the array in n * n
  static final Random generator = new Random(1776);

  private char[][] printableUnicode = new char[n][n];

  public MyUnicode() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        printableUnicode[i][j] = getRandomUnidode();
      }
    }
  }

  public char getRandomUnidode() {
    // calculate total characters in first section and second section
    int totalChar1 = (BASIC_LATIN_END - BASIC_LATIN_BEGIN + 1);  //range of basic Latin character
    int totalChar2 = (SUPPLY_LATIN_END - SUPPLY_LATIN_BEGIN + 1);  //range of supplement Latin character
    int offset = (int)(generator.nextDouble() * (totalChar1 + totalChar2));
    if (offset < totalChar1) {
      return (char)(BASIC_LATIN_BEGIN + offset);
    } else {
      return (char)(SUPPLY_LATIN_BEGIN + offset - totalChar1);
    }
  }

  public void printOutTable() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(printableUnicode[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public char getCharacter(int row, int col) {
    return printableUnicode[row - 1][col - 1];
  }

  public static void main(String[] args) {

    MyUnicode myUnicode = new MyUnicode();
    myUnicode.printOutTable();
    System.out.println();
    System.out.println("the character at position (4,5) is: " + myUnicode.getCharacter(4,5));
  }
}
