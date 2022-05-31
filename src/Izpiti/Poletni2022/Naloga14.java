package Izpiti.Poletni2022;


interface Mnozica {
    void add(char c);
    void remove(char c);
    void flip(char c);
    boolean contains(char c);
    boolean isEmpty();
}

class MnozicaZnakov implements Mnozica {
    // elemente mnozice hranim v atributu element; element i je v množici,
    // tedaj in le tedaj, ko je v atributu elementi prizgan i-it bit
    private int elementi;

    public MnozicaZnakov() {
        // "spraznim" mnozico elementov
        this.elementi = 0;
    }

    // znak c spremenim v zaporedno številko i (a' -> 1, 'b' -> 2, ...)
    // in vrnem stevilo, v katerem je prižgan le i-ti bit
    private int getIndex(char c) {
        return 1 << (Character.toLowerCase(c) - 'a');
    }

    public void add(char c) {
        this.elementi |= getIndex(c);
    }

    public void remove(char c) {
        this.elementi &= ~getIndex(c);
    }

    public void flip(char c) {
        this.elementi ^= getIndex(c);
    }

    public boolean contains(char c) {
        return (this.elementi & getIndex(c)) != 0;
    }

    public boolean isEmpty() {
        return (this.elementi == 0);
    }

    @Override
    public String toString() {
        String result = "";
        for (char c = 'a'; c <= 'z'; c++) {
            if (contains(c))
                result += (result.isEmpty() ? "" : ",")+c;
        }
        return '['+result+']';
    }

}

public class Naloga14 {
    public static void main(String[] args) {
        // args = new String[]{"+a", "+b", "+c"};  // izpis : [a,b,c]
        //args = new String[]{"+a", "+b", "+c", "-a", "-b"};  // izpis : [c]
        //args = new String[]{"+d", "xe", "xe", "xe"};  // izpis : [c]
        //args = new String[]{"+x", "xy", "xz"};

        MnozicaZnakov mn = new MnozicaZnakov();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.length() != 2) continue;
            switch (arg.charAt(0)) {
                case '+': mn.add   (arg.charAt(1)); break;
                case '-': mn.remove(arg.charAt(1)); break;
                case 'x': mn.flip  (arg.charAt(1)); break;
            }
        }
        System.out.println(mn.toString());
    }
}

/*
Napiši razred, ki ga bomo uporabljali kot množico za shranjevanje znakov (malih črk) angleške abecede. Razred naj se
imenuje MnozicaZnakov in naj implementira vmesnik Mnozica:
Metode vmesnika imajo naslednji pomen:
- add()       ... dodaj znak v množico,
- remove()    ... odstrani znak iz množice,
- flip()       ... če je znak v množici, ga odstrani, sicer ga dodaj,
- contains()  ... vrne true, če je znak  v množici, false sicer,
- isEmpty()  ... vrne true, če je množica prazna, false sicer,
- toString()   ... vrne niz, ki predstavlja elemente množice.
Vse elemente množice shrani v enem celem številu; i-ti bit tega števila naj bo prižgan takrat in le takrat, ko je i-ta
črka vsebovana v množici. Pri tem je 1. črka a, 2. črka b, 3. črka c …  Program bomo poganjali s pomočjo spodnje metode
main(); te metode ni treba spreminjati, lahko pa z njo preverjaš pravilnost delovanja razreda MnozicaZnakov.
Vmesnik Mnozica in razred MnozicaZnakov  dodaj v datoteko Naloga14.java in poskrbi, da bo program Naloga14
prevedljiv in se ga bo dalo izvesti.
 */