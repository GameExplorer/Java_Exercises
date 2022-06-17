package Izpiti.Poletni2022;

public class Naloga21 {
    static void izpisi(String niz) {
        String[] besede = niz.split(" ");

        int b = 0;
        for (int i = 0; i < besede.length; i++) {
            String beseda = besede[i];
            String locilo = "";
            if (beseda.endsWith(".") || beseda.endsWith(",") || beseda.endsWith(" ")) {
                locilo = beseda.substring(beseda.length() - 1);
                beseda = beseda.substring(0, beseda.length() - 1);
            }
            System.out.printf("%s(%d)%s ", beseda, beseda.length(), locilo);

            // izpis po največ 4 besede v eni vrsti
            if (++b == 4) {
                System.out.println();
                b = 0;
            }
        }
    }

    public static void main(String[] args) {
        // vse argument zdruzi v en niz (loceno s presledki)
        String niz = String.join(" ", args);
        izpisi(niz);
    }


}
