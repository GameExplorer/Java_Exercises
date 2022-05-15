package Kviz1;

public class kviz12 {
    public static void main(String[] args){
        vsotaPrvih(14);
    }
    public static int vsotaPrvih(int n) {
        int sum = 0;
        int i = 0;
        int stevec = 0;
        while(true) {
            if (jePrastevilo(i)) {
                sum += i;
                stevec += 1;

            }
            i++;
            if (stevec == n) {
                break;
            }
        }
        return sum;
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
