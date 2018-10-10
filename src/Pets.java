import java.util.Objects;

public class Pets {
  protected int credits = 10;

  public void pluses(int a) {
    credits += a;
  }

  public void minuses(int a) {
    credits -= a;
  }

  public void clearCredits () { credits = 0; }

  public String PetsMethod(){ return "Pets method";}

  @Override
  public String toString() {
    return "Pets{" +
      "credits=" + credits +
      '}';
  }
}
