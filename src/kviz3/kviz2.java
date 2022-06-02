package kviz3;

/*
Polinom s celoštevilskimi koeficienti  a0+a1 x + a2 x^2 + … + a(n-1) x^(n-1) je podan s tabelo koeficientov

 int [] a,

 
pri čemer je a.length == n.  Napiši metodo int[] zmnoziPolinoma(int[] a, int[] b), ki prejme polinoma a in b in vrne njun produkt.
*/

import java.util.Arrays;

public class kviz2 {
    public static void main (String[] args) {
        System.out.println(Arrays.toString(zmnoziPolinoma(new int[] { 1, 2, 3 }, new int[]{ 4, 5, 6 })));

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
