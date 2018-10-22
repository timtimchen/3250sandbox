// Group work by Chergang Chang and Jinghong Chen

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StreamEx2 {

  private class Position {
    public int row;
    public int col;

    Position(int x, int y) {
      row = x;
      col = y;
    }
  }
  private final int MAXCOL = 10;
  private final int MAXROW = 10;

  Predicate<Position> outOfUp = p -> p.row < 0;
  Predicate<Position> outOfDown = p -> p.row >= MAXROW;
  Predicate<Position> outOfLeft = p -> p.col < 0;
  Predicate<Position> outOfRight = p -> p.col >= MAXCOL;


  private Position currentPos = new Position(0,0);

  Random rand = new Random();

  List<Position> direction = new ArrayList<>();

  StreamEx2() {
    currentPos.col = rand.nextInt() % MAXCOL;
    currentPos.row = rand.nextInt() % MAXROW;

    direction.add(new Position(1,0));  //move right
    direction.add(new Position(-1,0));  //move left
    direction.add(new Position(0,1));  //move up
    direction.add(new Position(0,-1));  //move down
    // show initial position
    System.out.printf("(%d, %d)\n", currentPos.row, currentPos.col);
  }

  public void run(int direct) {
    Position newPos = new Position(currentPos.row + direction.get(direct).row, currentPos.col + direction.get(direct).col);

    String outOfBoundFlag = "";

    if (outOfUp.test(newPos)) {
      newPos.row = -newPos.row;
      outOfBoundFlag = "*";
    }

    if (outOfDown.test(newPos)) {
      newPos.row -= 2;
      outOfBoundFlag = "*";
    }

    if (outOfLeft.test(newPos)) {
      newPos.col = -newPos.col;
      outOfBoundFlag = "*";
    }

    if (outOfRight.test(newPos)) {
      newPos.col -= 2;
      outOfBoundFlag = "*";
    }

    currentPos = newPos;
    System.out.printf("(%d, %d) %s\n", currentPos.col, currentPos.row, outOfBoundFlag);
  }

  public static void main(String[] args) {

    StreamEx2 streamEx2 = new StreamEx2();

    Random random = new Random();
    IntStream intStream = random.ints(0, 4);
      intStream.forEach(i -> {
        streamEx2.run(i);
      });
  }
}
