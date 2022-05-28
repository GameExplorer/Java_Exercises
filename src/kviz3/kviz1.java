package kviz3;


public class kviz1 {
    public static void main(String[] args) {
        
    }

    public static int [] sestejPolinoma(int [] a, int [] b) {
        int[] c = new int[Math.max(a.length, b.length)];
        for (int i = 0; i < a.length; i++) {
            c[i] += a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i] += b[i];
        }
        return c;
    }
}
