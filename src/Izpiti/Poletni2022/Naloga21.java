package Izpiti.Poletni2022;

/*
V razredu Naloga21 napiši metodo izpisi(), ki besede danega besedila opremi s številkami (v oklepaju zapiše dolžino besede)
in tako opremljeno besedilo izpiše na zaslon.  Primer: ob klicu izpisi("Java je super") naj metoda izpiše  Java(4) je(2)
super(5) Metoda izpisi() naj upošteva, da ločila (presledek, vejica in pika) ne sodijo k besedi in zato ne prispevajo k njeni dolžini.
Ob klicu   izpisi("Bravo, zelo dobro.") je pravilen izpis tak:  Bravo(5), zelo(4) dobro(5). Izhodno besedilo naj bo oblikovano tako,
da bodo v eni izpisani vrstici največ 4 besede. Primer: Ob klicu   izpisi("Prva, druga, tretja, cetrta, peta, sesta.") je pravilen izpis tak:
Prva(4), druga(5), tretja(6), cetrta(6), peta(4), sesta(5). Metodo izpisi() napiši v razred  Naloga21, v katerem naj bo tudi main()
metoda  public static void main(String[] args) {     izpisi(args[0]); }
 */


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

