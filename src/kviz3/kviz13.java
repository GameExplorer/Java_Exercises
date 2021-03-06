package kviz3;

public class kviz13 {
    public static void main(String[] args) {
        preberiInIzpisi("src/kviz3/assets/i1");
    }
    static void preberiInIzpisi(String oznaka) {
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File(oznaka + "-prijave.txt"));
            java.util.TreeMap<String, String[]> podatki = new java.util.TreeMap<>();
            while (scanner.hasNextLine()) {
                String[] vrstica = scanner.nextLine().split(":");
                if (vrstica.length == 2) {
                    podatki.put(vrstica[0], new String[] { vrstica[1], "VP" });
                }
            }
            scanner.close();
            for (int i = 1; i <= 4; i++) {
                scanner = new java.util.Scanner(new java.io.File(oznaka + "-n" + i + ".txt"));
                while (scanner.hasNextLine()) {
                    String[] vrstica = scanner.nextLine().split(":");
                    if (podatki.containsKey(vrstica[0])) {
                        String[] podatek = podatki.get(vrstica[0]);
                        if (podatek[1].equals("VP")) {
                            podatek[1] = "0";
                        }
                        podatek[1] = String.valueOf(Integer.parseInt(podatek[1]) + Integer.parseInt(vrstica[1]));
                        podatki.replace(vrstica[0], podatek);
                    }
                }
            }
            scanner.close();
            java.util.SortedSet<java.util.Map.Entry<String, String[]>> sortiraniPodatki = new java.util.TreeSet<>(
                    (e1, e2) -> {
                        int rezultat = e1.getValue()[0].compareTo(e2.getValue()[0]);
                        return rezultat != 0 ? rezultat : 1;
                    }
            );
            sortiraniPodatki.addAll(podatki.entrySet());
            for (java.util.Map.Entry<String, String[]> entry : sortiraniPodatki) {
                String id = entry.getKey();
                String[] podatek = entry.getValue();
                System.out.println(id + ":" + podatek[0] + ":" + podatek[1]);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Rezultati izpita so shranjeni v petih datotekah in sicer: datoteka <oznaka>-prijave.txt vsebuje podatke ??tudentov, ki so se prijavili na izpit -  ime in priimk ter vpisna ??tevilka (podatka sta lo??ena z dvopi??jem), datoteke <oznaka>-n1.txt, <oznaka>-n2.txt, <oznaka>-n3.txt, <oznaka>-n4.txt pa vsebujejo podatke o dose??enih to??kah pri posamezni nalogi (vsaka vrstica datoteke vsebuje vpisno ??tevilko in dose??eno ??tevilo to??k, podatka sta lo??ena z dvopi??jem). Primer vsebine datotek pri <oznaka>=i1:



i1-prijave.txt

63123456:Miha Novak

63123457:Anton Ho??evar

63123458:Tina Slovenc

63123459:Suzi Mlinar



i1-n1.txt

63123456:25

63123459:13

63123457:0



i1-n2.txt

63123457:0

63123459:7

63123456:21



i1-n3.txt

63123457:0

63123456:25

63123459:5



i1-n4.txt

63123459:12

63123456:15

63123457:0





Napi??i metodo

  void preberiInIzpisi(String oznaka),

ki prebere 5 datotek s podano oznako, jih zdru??i in izpi??e kon??en rezultat izpita. Izpis naj  vsebuje vpisno ??tevilko, ime ??tudenta in skupno ??tevilo dose??enih to??k ter naj bo urejen po imenu (abecedni vrstni red). V primeru, da ??tudent ni oddal  nobene naloge (njegove vpisne ??tevilke ni v nobeni datoteki z ocenami), naj program pri njegovem imenu izpi??e VP (vrnjena prijava).



Primer: pri klicu preberiInIzpisi("i1"), naj program izpi??e:



63123457:Anton Hosevar:0

63123456:Miha Novak:86

63123459:Suzi Mlinar:37

63123458:Tina Slovenc:VP
 */