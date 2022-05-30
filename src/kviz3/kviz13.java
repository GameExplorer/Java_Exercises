package kviz3;

public class kviz13 {
    public static void main(String[] args) {

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
Rezultati izpita so shranjeni v petih datotekah in sicer: datoteka <oznaka>-prijave.txt vsebuje podatke študentov, ki so se prijavili na izpit -  ime in priimk ter vpisna številka (podatka sta ločena z dvopičjem), datoteke <oznaka>-n1.txt, <oznaka>-n2.txt, <oznaka>-n3.txt, <oznaka>-n4.txt pa vsebujejo podatke o doseženih točkah pri posamezni nalogi (vsaka vrstica datoteke vsebuje vpisno številko in doseženo število točk, podatka sta ločena z dvopičjem). Primer vsebine datotek pri <oznaka>=i1:



i1-prijave.txt

63123456:Miha Novak

63123457:Anton Hočevar

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





Napiši metodo

  void preberiInIzpisi(String oznaka),

ki prebere 5 datotek s podano oznako, jih združi in izpiše končen rezultat izpita. Izpis naj  vsebuje vpisno številko, ime študenta in skupno število doseženih točk ter naj bo urejen po imenu (abecedni vrstni red). V primeru, da študent ni oddal  nobene naloge (njegove vpisne številke ni v nobeni datoteki z ocenami), naj program pri njegovem imenu izpiše VP (vrnjena prijava).



Primer: pri klicu preberiInIzpisi("i1"), naj program izpiše:



63123457:Anton Hosevar:0

63123456:Miha Novak:86

63123459:Suzi Mlinar:37

63123458:Tina Slovenc:VP
 */