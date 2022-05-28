package kviz3;

public class kviz4 {
    public static void main(String[] args){

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
