package Kviz1;

public class kviz11 {

    public static void main(String[] args) {
        pretvoriVDesetisko("Petek je danes", 5);
    }

    public static String pretvoriVDesetisko(String n, int b) {
        int desetisko=0;
        for(int i = 0; i < n.length(); i++) {
            char c = n.charAt(n.length() - i -1);
            int stevka = Character.getNumericValue(c);
            if (stevka >= b) {
                return String.format("Napaka pri pretvorbi sistema - števka %c", c);
            }
            desetisko += stevka * Math.pow(b,i);
        }
        return String.format("%s(%d)=%d(10)",n,b,desetisko);
    }
}
