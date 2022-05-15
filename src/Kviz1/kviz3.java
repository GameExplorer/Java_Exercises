package Kviz1;

public class kviz3 {
     /*Write a method

  void nickel (int a, int b, int c),

which calculates and prints both real zeros of the quadratic equation

  ax2 + bx + c = 0

In the event that real zeros do not exist (negative discriminant), the program should display Error: zeros of the equation do not exist
*/
public static void main(String[] args){
    nicli(1,2,1);
}
public static void nicli(int a, int b, int c) {
    double d = Math.pow(b, 2) - 4 * a * c;
    if (d < 0) {
        System.out.println("Napaka: nicli enacbe ne obstajata.");
    } else {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.printf("x1=%.2f, ", x1);
            System.out.printf("x2=%.2f", x2);
        }
    }
}
