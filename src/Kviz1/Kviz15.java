package Kviz1;

public class Kviz15 {
    public static void main(String[] args) {
        izracunajRazliko("08:23:10", "04:01:02");
    }
    public static String izracunajRazliko(String prviCas, String drugiCas) {
        String[] cas1 = prviCas.split(":");
        String[] cas2 = drugiCas.split(":");
        int sekundePrviCas = (Integer.parseInt(cas1[0]) * 60 * 60 + Integer.parseInt(cas1[1]) * 60 + Integer.parseInt(cas1[2]));
        int sekundeDrugiCas = (Integer.parseInt(cas2[0]) * 60 * 60 + Integer.parseInt(cas2[1]) * 60 + Integer.parseInt(cas2[2]));

        int sekundeRazlika = Math.abs(sekundePrviCas - sekundeDrugiCas);
        int h = sekundeRazlika / 60 / 60 % 60;
        int m = sekundeRazlika / 60 % 60;
        int s = sekundeRazlika % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
   
    
    

