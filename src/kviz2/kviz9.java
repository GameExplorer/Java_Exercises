package kviz2;

/*
Papajščina je jezik, podoben slovenščini, razlika je le v dodanem zlogu “pa” za vsakim samoglasnikom. Primer: stavek Danes je lep dan se v papajščini glasi Dapanepas jepa lepap dapan.

Napiši metodo static String prevod(String niz), ki najprej preveri, v katerem jeziku je zapisan podan niz, nato pa niz prevede v drug jezik.

Primer: ob klicu prevod("Danes je lep dan") naj metoda vrne niz "Dapanepas jepa lepap dapan", ob klicu prevod("Dapanepas jepa lepap dapan") pa "Danes je lep dan".

Primer2: Papaka -> Papapapakapa

Primer3: Kappa -> Kapappapa
*/

public class kviz9 {
    public static String main(String[] args){
        return prevod("Dapanepas jepa lepap dapan");
    }
    
    public static String prevod(String niz) {
        boolean jePapajscina = true;
        for (int i = 0; i < niz.length(); i++) {
            char crka = niz.charAt(i);
            if ("aeiou".contains(Character.toString(crka).toLowerCase())) {
                if (i == niz.length() - 1) {
                    jePapajscina = false;
                    break;
                }
                String nD = niz.substring(i + 1, i + 3);
                if (!nD.toLowerCase().equals("pa")) {
                    jePapajscina = false;
                    break;
                }
                i += 2;
            }

        }
        if (jePapajscina) {
            for (int i = 0; i < niz.length(); i++) {
                char crka = niz.charAt(i);
                if ("aeiou".contains(Character.toString(crka).toLowerCase())) {
                    String nD = niz.substring(i + 1, i + 3);
                    if (nD.toLowerCase().equals("pa")) {
                        niz = niz.substring(0, i + 1) + niz.substring(i + 3);
                    }
                }
            }

        } 
        else {
            for (int i = 0; i < niz.length(); i++) {
                char crka = niz.charAt(i);
                if ("aeiou".contains(Character.toString(crka).toLowerCase())) {
                    niz = niz.substring(0, i + 1) + "pa" + niz.substring(i + 1);
                    i += 2;
                }
            }
        }
        return prevod(niz);
    }
}
