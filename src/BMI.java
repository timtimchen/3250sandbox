import java.util.Scanner;

public class BMI {

  public double calculateBMI(double weight, double heightInFeet, double heightInInches) {
    final double KILOGRAMS_PER_POUND = 0.45359237; // Constant
    final double METERS_PER_INCH = 0.0254; // Constant

    // Compute BMI
    double weightInKilograms = weight * KILOGRAMS_PER_POUND;
    double heightInMeters = (heightInFeet * 12 + heightInInches) * METERS_PER_INCH;
    if (heightInMeters == 0) {
      return 0;
    } else {
      return weightInKilograms / (heightInMeters * heightInMeters);
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter weight in pounds
    System.out.print("Enter weight in pounds: ");
    double weight = input.nextDouble();

    // Prompt the user to enter the feet of height
    System.out.print("Enter the feet for height: ");
    double heightInFeet = input.nextDouble();

    // Prompt the user to enter the inches of height
    System.out.print("Enter the inches for height: ");
    double heightInInches = input.nextDouble();

    // Compute BMI
    BMI b = new BMI();
    double bmi = b.calculateBMI(weight,heightInFeet,heightInInches);

    // Display result
    System.out.printf("BMI is %.2f\n", bmi);
    if (bmi < 18.5)
      System.out.println("Underweight");
    else if (bmi < 25)
      System.out.println("Normal");
    else if (bmi < 30)
      System.out.println("Overweight");
    else
      System.out.println("Obese");
  }
}
