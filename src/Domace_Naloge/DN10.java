package Domace_Naloge;

interface Lik {

    public double obseg();
}

class Pravokotnik implements Lik {

    int a, b;

    Pravokotnik(int a, int b) {

        this.a = a;
        this.b = b;
    }

    public double obseg() {
        return 2 * (a + b);
    }
}

class Kvadrat extends Pravokotnik {
    Kvadrat(int a) {
        super(a,a);
    }
}

class NKotnik implements Lik {

    int a; // velikost stranice
    int n; // stevilo stranic

    NKotnik(int a, int n) {
        this.a = a;
        this.n = n;
    }

    public double obseg() {
        return n * a;
    }

}


public class DN10 {

    static int skupenObseg(Lik[] liki) {
        int obseg = 0;
        for (int i = 0; i < liki.length; i++) {
            obseg += liki[i].obseg();
        }
        return obseg;
    }

    public static void main(String[] args) {
        args = new String[]{"kvadrat:5", "pravokotnik:10:3", "nkotnik:5:2"};

        // ustvarim tabelo za vse like; število likov je enako številu argumentov ...
        Lik[] liki = new Lik[args.length];
        for (int i=0; i<args.length; i++) {
            String[] podatki = args[i].split(":");
            switch (podatki[0]) {
                case "kvadrat":
                    liki[i]= new Kvadrat(Integer.parseInt(podatki[1]));
                    break;
                case "pravokotnik":
                    liki[i]= new Pravokotnik(Integer.parseInt(podatki[1]), Integer.parseInt(podatki[2]));
                    break;
                case "nkotnik":
                    liki[i]= new NKotnik(Integer.parseInt(podatki[1]), Integer.parseInt(podatki[2]));
            }
        }

        // ... izračunam skupen obseg ...
        int skupenObseg = skupenObseg(liki);
        // ... in izpišem rezultat
        System.out.printf("%d\n", skupenObseg);
    }
}
