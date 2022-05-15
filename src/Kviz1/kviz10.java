package Kviz1;

public class kviz10 {
    public static void main(String[] args) {
        vDesetisko(129);
    }

    /*
    Write a method void vDesetisko(int n), which converts a given number from the octal to the decimal system and displays the numbers in both systems. if number is not octal write error

    */
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
