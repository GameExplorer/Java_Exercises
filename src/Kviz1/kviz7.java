package Kviz1;

/*
Števila v zaporedju 1, 1, 2, 3, 5, 8, 13, 21, 34, ... imenujemo Fibonaccijeva števila. Naslednji element zaporedja dobimo s seštevanjem prejšnjih dveh elementov (13=5+8, 21=8+13, 34=13+21, ...).

Napiši metodo boolean jeFibonaccijevo(int n), ki preveri, ali je dano število n Fibonaccijevo število.
*/

public class kviz7 {
    public static void main (String[] args){
        jeFibonacijevo(4);
    }
    public static boolean jeFibonacijevo(int n) {
        if (n < 0) {
            System.out.println("Napaka: negativen n");
            return false;
        } else if (n == 0) {
            return true;
        } else if (n == 1) {
            return true;
        } else {
            int a = 0;
            int b = 1;
            int c = 0;
            for (int i = 0; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            if (c == n) {
                return true;
            } else {
                return false;
            }
        }
    }

    
}
