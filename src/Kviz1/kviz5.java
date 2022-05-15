package Kviz1;

public class kviz5 {
    public static void main(String[] args) {
        pretvoriSekunde(4000);
    }
    public static String pretvoriSekunde(int sekunde) {
        int s = sekunde % 60;
        int m = (sekunde / 60) % 60;
        int h = (sekunde / 3600);

        if (sekunde < 0) {
            System.out.println("Število sekund ne more biti negativno");
            
        } else {
            System.out.printf("%02d:%02d:%02d", h, m, s);
        }    
        return "";   
    }
}
