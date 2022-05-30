package kviz3;

/*
Polinom s celoštevilskimi koeficienti  a0+a1 x + a2 x^2 + … + a(n-1) x^(n-1) je podan s tabelo koeficientov

 int [] a,

pri čemer je a.length == n.  Napiši metodo int[] sestejPolinoma(int[] a, int[] b), ki prejme polinoma a in b in vrne njuno vsoto.
*/

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
