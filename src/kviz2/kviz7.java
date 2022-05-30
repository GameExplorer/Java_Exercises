package kviz2;

/*
Napiši metodo String binarnoSestej(String s, String b), ki sešteje dve binarni števili, podani kot niz enic in ničel.

Primeri:

"10" + "11" = "101"

"10011010010" + "1000011100001" = "1010110110011"

Metoda lahko uporabi le osnovne operacije in razrede (ne sme, na primer, uporabiti metode Integer.parseInt() in podobnih metod), rezultat naj pridobi s seštevanjem “bit po bitu”
*/
public class kviz7 {
    public static void main (String[] args) {
        System.out.println(binarnoSestej("10", "11"));
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
