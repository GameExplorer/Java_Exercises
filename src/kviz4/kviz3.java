package kviz4;

public class kviz3 {
    public static void main(String[] args) {
        statistikaStavkov("src/kviz4/assets/besedilo2.txt");
    }
    static void statistikaStavkov(String imeDatoteke) throws IzjemaManjkajocegaLocila {
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File(imeDatoteke));
            java.util.TreeMap<Integer, Integer> frekvence = new java.util.TreeMap<>();
            int trenutnaFrekvenca = 0;
            while (scanner.hasNext()) {
                String beseda = scanner.next();
                trenutnaFrekvenca++;
                if (beseda.contains(".") || beseda.contains("!") || beseda.contains("?")) {
                    if (frekvence.containsKey(trenutnaFrekvenca)) {
                        frekvence.replace(trenutnaFrekvenca, frekvence.get(trenutnaFrekvenca) + 1);
                    } else {
                        frekvence.put(trenutnaFrekvenca, 1);
                    }
                    trenutnaFrekvenca = 0;
                } else if (!scanner.hasNext()) {
                    throw new IzjemaManjkajocegaLocila();
                }
            }
            for (java.util.Map.Entry<Integer, Integer> podatki : frekvence.entrySet()) {
                System.out.printf("Stavki dolzine %d se pojavijo: %dx.", podatki.getKey(), podatki.getValue());
                System.out.println();
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Napaka pri branju datoteke.");
        }
    }

    /*
    V tekstovni datoteki imamo shranjeno besedilo, ki je sestavljeno iz stavkov. Stavki so lahko poljubno dolgi (vsebujejo poljubno mnogo besed). Napiši metodo

   static void statistikaStavkov(String imeDatoteke) throws IzjemaManjkajocegaLocila


ki bo prebrala vsebino podane datoteke in izpisala dolžine prebranih stavkov in njihovo frekvenco (število stavkov posamezne dolžine). Ime datoteke je podano kot prvi parameter ob klicu metode. Besede v datoteki so med seboj ločene s presledki, stavki pa se končajo s piko, klicajem  ali vprašajem.  V primeru, da se stavek ne konča z enim od omenjenih ločil, sprožite nepreverljivo izjemo IzjemaManjkajocegaLocila. Če datoteka ne obstaja, izpišite besedilo "Napaka pri branju datoteke.". Definirajte tudi ta razred in ustrezno obravnavajte to izjemo.



Primer izhoda ob klicu statistikaStavkov("besedilo1.txt"):



Stavki dolzine 9 se pojavijo: 1x.
Stavki dolzine 16 se pojavijo: 1x.
Stavki dolzine 18 se pojavijo: 1x.
Stavki dolzine 51 se pojavijo: 1x.
     */
}
class IzjemaManjkajocegaLocila extends RuntimeException {
    IzjemaManjkajocegaLocila() {
        super();
    }

    @Override
    public String getMessage() {
        return "Izjema manjkajocega locila.";
    }
}