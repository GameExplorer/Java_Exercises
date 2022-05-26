package kviz2;

public class kviz10 {
    public static void main(String[] args){

    }
    /*Write a String interlacing method (String string1, String string2) that receives two strings and returns an interlaced string 
    (in which the letters of the first and second strings intertwine). If the strings are not the same length, complete the shorter ones with spaces.*/

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
