package kviz3;

public class kviz2 {
    public static void main (String[] args) {

    }
    public static int [] zmnoziPolinoma (int [] a, int [] b) {
        int [] c = new int [a.length + b.length -1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                c[i + j] += a[i] * b[j];
            }
        }
        return c;
    }
}
