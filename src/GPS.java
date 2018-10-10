import java.util.Scanner;

public class GPS {
  /**
   * Calculate distance between two points in latitude and longitude.
   * Uses Haversine method as its base.
   *
   * Start point: lat1, lon1
   * End point: lat2, lon2
   * @returns Distance in Miles
   */
  public double haversine(double lat1, double lat2, double lon1, double lon2) {

    final double R = 3959.0; // Radius of the earth in miles

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
      + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
      * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return R * c;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter the latitude of first city
    System.out.print("Enter the latitude of first city: ");
    double latitude1 = input.nextDouble();

    // Prompt the user to enter the longitude of first city
    System.out.print("Enter the longitude of first city: ");
    double longitude1 = input.nextDouble();

    // Prompt the user to enter the latitude of first city
    System.out.print("Enter the latitude of second city: ");
    double latitude2 = input.nextDouble();

    // Prompt the user to enter the longitude of first city
    System.out.print("Enter the longitude of second city: ");
    double longitude2 = input.nextDouble();

    // Prompt the user to enter the latitude of first city
    System.out.print("Enter the latitude of third city: ");
    double latitude3 = input.nextDouble();

    // Prompt the user to enter the longitude of first city
    System.out.print("Enter the longitude of third city: ");
    double longitude3 = input.nextDouble();

    GPS gps = new GPS();

    // calculate distances between citys
    double d1 = gps.haversine(latitude1, latitude2, longitude1, longitude2);
    double d2 = gps.haversine(latitude2, latitude3, longitude2, longitude3);
    double d3 = gps.haversine(latitude3, latitude1, longitude3, longitude1);

    // calculate area by Herons Formula
    double s = (d1 + d2 + d3) / 2;
    System.out.printf("Area of Triangle is: %.1f sq miles", Math.sqrt(s * (s - d1) * (s - d2) * (s - d3)));
  }
}
