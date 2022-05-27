package kviz2;

public class kviz9 {
    public static String main(String[] args){
        return prevod("Dapanepas jepa lepap dapan");
    }
    
    /*Write a static String translation method that first checks in 
    which language the specified string is written and then translates 
    the string to another language
    */
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
