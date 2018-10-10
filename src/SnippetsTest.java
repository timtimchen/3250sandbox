import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Call{  //using instanceof with explicit type casting #9
  String invoke(Pets p){//upcasting
    if(p instanceof Snippets){
      Snippets a=(Snippets)p;//Downcasting
      return a.SnippetsMethod();
    } else {
      return p.PetsMethod();
    }

  }
}//end of Call class

public class SnippetsTest {
  @Test
  public void constructorTest() {
    // testing constructor chaining and Object equals method
    Snippets expected = new Snippets(10, 20.0);
    Snippets actual = new Snippets();
    assertEquals(expected, actual);
    }

  @Test
  public void overridingPlusesTest() {
    // testing overriding pluses method
    Snippets actual = new Snippets();
    Snippets expected = new Snippets(13, 23.0);
    actual.pluses(3);
    assertEquals(expected, actual);
  }

  @Test
  public void overloadingplusesTest() {
    // testing overloading pluses method
    Snippets actual = new Snippets();
    Snippets expected = new Snippets(13, 120.0);
    actual.pluses(3, 100.0);
    assertEquals(expected, actual);

  }

  @Test
  public void toStringTest() {
    // testing overriding toString method
    Snippets actual = new Snippets();
    String expectedString = "Snippets{ credits=10, balance=20.0 }";
    assertEquals(expectedString, actual.toString());
  }

  @Test
  public void CastingTest() {
    // testing using instanceof with explicit type casting
    Pets p=new Snippets();
    Call c = new Call();
    assertEquals("Snippets method", c.invoke(p));
  }

}
