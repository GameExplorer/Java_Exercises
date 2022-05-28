package Kviz1;

public class kviz10 {
    public static void main(String[] args) {
        vDesetisko(129);
    }
    public static void vDesetisko(int n) {
        String osmisko = String.valueOf(n);
        int desetisko = 0;
        for (int i = 0; i < osmisko.length(); i++) {
            int stevka = Character.getNumericValue(osmisko.charAt(osmisko.length() - i - 1));

            if (stevka >= 8) {
                System.out.printf("Število %d ni število v osmiškem sistemu (števka %d)", n, stevka);
                return;
            }
            desetisko += stevka * Math.pow(8, i);
        }
        System.out.printf("%d(8) = %d(10)", n, desetisko);
    }
   

    
    
}
