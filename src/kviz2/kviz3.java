/*
Napiši metodo int[] range(int a, int b, int c), ki prejme števila a, b, c > 0 in vrne tabelo z elementi a, a+c, a+2c, a+3c, ...a+xc, pri čemer je a+xc < b  in a+(x+1)c >= b.
*/
package kviz2;

public class kviz3 {
    public static void main(String[] args) {
        System.out.print(range(0, 10, 2));
    }

    public static int [] range (int a, int b, int c) {
        java.util.ArrayList<Integer> range = new java.util.ArrayList<Integer>();
        int x = 0;
        while(a + x * c < b) {
            range.add(a + x * c);
            x++;
        }

        int[] range2 = new int[range.size()];
        for (int i = 0; i < range.size(); i++) {
            range2[i] = range.get(i);
        }

        return range2;
    }
}
