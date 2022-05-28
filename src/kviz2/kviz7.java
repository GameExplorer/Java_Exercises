package kviz2;


public class kviz7 {
    public static String main (String[] args) {
        return binarnoSestej("12", "2");
        
    }

    public static String binarnoSestej(String s, String b) {
        String rezultat = "";
        int s1 = s.length();
        int b1 = b.length();
        int c = 0;

        int k = Math.max(s1,b1);

        for(int i = 0; i < k; i++) {
            int s1dodaj = 0;
            int b1dodaj = 0;
            if(i < s1) {
                s1dodaj = s.charAt(s1 - i - 1) - '0';
            }
            if(i < b1) {
                b1dodaj = b.charAt(b1 - i - 1) - '0';
            }

            int rezultat1 = s1dodaj + b1dodaj + c;
            c = rezultat1 / 2;
            rezultat = rezultat1 % 2 + rezultat;


        }
        if (c == 0){
            return rezultat;
        }


        return "1" + rezultat;
    }
}
