package Kviz1;

public class vaja5 {
    public static void main(String[] args) {
        pretvoriSekunde(79530);
    }

    /*Write a method String convertSeconds (int seconds),
      which converts seconds to hours, minutes and seconds and returns a string in the format hh: mm: ss.
      if time is negative return Število sekund ne more biti negativno. Return only positive value*/

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
