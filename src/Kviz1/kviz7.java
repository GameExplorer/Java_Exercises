package Kviz1;

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
