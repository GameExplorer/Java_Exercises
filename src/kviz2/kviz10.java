
package kviz2;

public class kviz10 {
    public static void main(String[] args){

    }

    public static void prepleti(String niz) {
        String niz1 = "";
        String niz2 = "";

        for (int i = 0; i < niz.length(); i++) {
            if (i % 2 == 0) {
                niz1 += niz.charAt(i);
            } else {
                niz2 += niz.charAt(i);
            }
        }

        System.out.println(niz1);
        System.out.println(niz2);
    }
}
