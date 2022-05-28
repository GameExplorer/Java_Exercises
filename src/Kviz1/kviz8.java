package Kviz1;

public class kviz8 {
    public static void main(String[] args) {
        jePrastevilo(2);
    }
    public static boolean jePrastevilo(int n) {
        if (n < 0) {
            return false;
        } else if (n == 0) {
            return false;
        } else if (n == 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
}
