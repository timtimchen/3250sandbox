import java.util.Objects;

public class Snippets extends Pets {

  protected double balance;

  //constructor chaining #3
  public Snippets () { this( 10); }
  public Snippets (int a) { this( a, 20.0); }
  public Snippets (int a, double b) {
    credits = a;
    balance = b;
  }

  @Override
  public void pluses(int a) {  //method overriding #5
    balance += a;
    super.pluses(a);  //calling a superclass method #2
  }

  @Override
  public void minuses(int a) {  //method overriding #5
    balance -= a;
    credits -= a;
  }

  public void pluses(int a, double b) {  //method overloading #4
    balance += b;
    credits += a;
  }

  public void minuses(int a, double b) {  //method overloading #4
    balance -= b;
    credits -= a;
  }

  public String SnippetsMethod(){ return "Snippets method";}

  @Override
  public String toString() {  //overriding toString method #6
    return "Snippets{" +
      " credits=" + credits +
      ", balance=" + balance +
      " }";
  }

  @Override
  public boolean equals(Object o) {  //override Object equals method #8
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Snippets snippets = (Snippets) o;
    return Double.compare(snippets.balance, balance) == 0;
  }


  public static void main(String[] args) {
    Snippets c = new Snippets();
    c.clearCredits();  //calling an inherited method #1
    c.pluses(13);
    System.out.println(c);  //implicitly calling an object's toString() method #7
    c.minuses(5,10.3);
    System.out.println(c);  //implicitly calling an object's toString() method #7

  }

};
