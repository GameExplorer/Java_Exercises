package kviz4;

public class kviz7 {
    public static void main(String[] args) {
        izpisiBesedilo("src/kviz4/assets/besedilo1.txt", 20, 30);

    }
    static void izpisiBesedilo(String imeDatoteke, int n, int s) {
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File(imeDatoteke));
            StringBuilder stavek = new StringBuilder();
            while (scanner.hasNext()) {
                String beseda = scanner.next();
                if (stavek.length() + beseda.length() <= 20) {
                    stavek.append(beseda).append(" ");
                } else {
                    int d = s - stavek.length();
                    for (int i = 0; i <= (d % 2 == 1 ? d / 2 : d / 2 - 1); i++) {
                        System.out.print(".");
                    }
                    System.out.print(stavek.toString().trim());
                    for (int i = 0; i <= d / 2; i++) {
                        System.out.print(".");
                    }
                    System.out.println();
                    stavek = new StringBuilder(beseda).append(" ");
                }
            }
            int d = s - stavek.length();
            for (int i = 0; i <= (d % 2 == 1 ? d / 2 : d / 2 - 1); i++) {
                System.out.print(".");
            }
            System.out.print(stavek.toString().trim());
            for (int i = 0; i <= d / 2; i++) {
                System.out.print(".");
            }
            System.out.println();
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
Napišite metodo

  void izpisiBesedilo(String imeDatoteke, int n, int s),

ki iz datoteke, podane v prvem parametru, prebere besedilo in ga izpiše v vrsticah z največ n znaki. Posamezno vrstico naj program poravna sredinsko na širino izpisa s tako, da na levo in desno stran besedila porazdeli enako število pik (če število manjkajočih pik ni deljivo z 2, odvečno piko pišite na desni strani).



Primer:  ob klicu izpisiBesedilo("besedilo1.txt", 20, 30), naj metoda izpiše naslednje besedilo:



.....Napišite program, ki.....
.....iz datoteke, podane......
.....v prvem argumentu ob.....
.......klicu programa,........
.....prebere besedilo in......
.....ga izpiše v vrsticah.....
......z največ n (drugi.......
......argument) znakov........
 */