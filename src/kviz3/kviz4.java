package kviz3;

public class kviz4 {
    public static void main(String[] args){
        String niz = "abc perica  reže raci rep def";
        System.out.printf("Najdaljši palindrom v nizu '%s' je '%s'\n", niz, najdaljsiPalindrom(niz, false));
        niz = "abc perica  reže raci rep def";
        System.out.printf("Najdaljši palindrom v nizu '%s' je '%s'\n", niz, najdaljsiPalindrom(niz, true));
        niz = "abcdeJavaRuleseluRavaJfghijk";
        System.out.printf("Najdaljši palindrom v nizu '%s' je '%s'\n", niz, najdaljsiPalindrom(niz, true));
    }

    public static String najdaljsiPalindrom(String niz, boolean presledki) {
        String palindrom = "";

        for(int i = 1; i < niz.length(); i++){
            String delNiz = niz.substring(0, i);
            String delNiz2 = niz.substring(i);
            if(delNiz.equals(new StringBuilder(delNiz).reverse().toString())){
                if(delNiz2.equals(new StringBuilder(delNiz2).reverse().toString())){
                    palindrom = delNiz;
                }
            }

        }
        return palindrom;
    }
}
/*abstract
Napiši metodo String najdaljsiPalindrom(String niz, boolean presledki),
ki v podanem nizu poišče najdljši palindrom, to je niz, ki se enako bere od začetka proti koncu in od konca proti začetku. Metoda naj kot parameter sprejme niz, v katerem išče palindrom ter logično spremenljivko presledki, s katero se določi, kako naj se pri preverjanju palindroma obravnavajo presledki (če je ta spremenljivka true, se presledki obravnavajo kot običajni znaki, če pa je false, presledke v nizu ignoriramo – na niz gledamo, kot da presledkov v njem ne bi bilo).
*/