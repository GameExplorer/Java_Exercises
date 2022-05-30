package Kviz1;

/*
Napiši metodo void nicli(int a, int b, int c), ki izračuna in izpiše obe realni ničli kvadratne enačbe

  ax2 + bx + c = 0

V primeru, da realni ničli ne obstajata (negativna diskriminanta), 
naj program izpiše  Napaka: nicli  enacbe ne obstajata.
*/

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
