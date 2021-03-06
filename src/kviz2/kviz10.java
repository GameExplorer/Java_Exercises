
package kviz2;

public class kviz10 {
    public static void main(String[] args){
        System.out.println(prepleti("pomlad", "JESEN"));
        System.out.println(prepleti("december", "maj"));
        System.out.println(prepleti("POMLAD", "december"));
        odpleti("dmeacje m b e r ");

    }
    /*
    Napiši metodo String prepleti(String niz1, String niz2), ki prejme dva niza in vrne prepleten niz (v katerem se prepletajo črke prvega in drugega niza). Če niza nista enako dolga, naj krajšega dopolni s presledki.

Primer:
prepleti("pomlad", "JESEN") --> "pJoEmSlEaNd "
prepleti("december", "maj") --> "dmeacje m b e r "

Napiši tudi metodo void odpleti(String niz), ki  prejme prepleten niz in na zaslon izpiše  oba niza, iz katerega je prepleten niz sestavljen, vsakega v svojo vrstico.

Primer:
odpleti("dmeacje m b e r ") –-(izpis)-->
december
maj

    */

    public static String prepleti(String niz1, String niz2) {
        StringBuilder prepleten = new StringBuilder();
        int i = 0;
        int j = 0;
        boolean koncaj = true;
        while (i < Math.max(niz1.length(), niz2.length()) || j 
        < Math.max(niz1.length(), niz2.length())) {
            if(koncaj) {
                if(i < niz1.length()){
                    prepleten.append(niz1.charAt(i));
                }
                else {
                    prepleten.append(" ");
                }
                i++;
                koncaj = !koncaj;
            }
            else {
                if (j < niz2.length()) {
                    prepleten.append(niz2.charAt(j));
                }
                else {
                    prepleten.append(" ");
                }
                j++;
                koncaj = !koncaj;
            }
        }

        return prepleten.toString();
    }

    public static void odpleti(String niz) {
        String niz1 = "";
        String niz2 = "";

        for (int i = 0; i < niz.length(); i++) {
            if (i % 2 == 0) {
                niz1 += niz.charAt(i);
            }
            else {
                niz2 += niz.charAt(i);
            }
        }
        System.out.print(niz1);
        System.out.print(niz2);
    }
}
