package Kviz1;

public class kviz3 {
     
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
