package kviz3;

public class kviz11 {

    public static void main(String[] args) {
        preveriInNarisi(new int[] { 1,3,0,2 });
        System.out.println();
        preveriInNarisi(new int[] { 1,0,3,2 });
        System.out.println(steviloPostavitev(6));
    }
    static void preveriInNarisi(int[] kraljice) {
        boolean seNapadajo = false;
        for (int i = 0; i < kraljice.length; i++) {
            for (int j = 0; j < kraljice.length; j++) {
                if (!seNapadajo && i != j) {
                    // Preverjanje diagonal
                    if (Math.abs(kraljice[i] - kraljice[j]) == Math.abs(i - j)) {
                        seNapadajo = true;
                    }
                }
                if (kraljice[j] == i) {
                    System.out.print("K ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        if (seNapadajo) {
            System.out.println("Kraljice se napadajo");
        } else {
            System.out.println("Kraljice se ne napadajo");
        }
    }

    static int steviloPostavitev(int n) {
        int p = 0;
        java.util.List<Integer> permutacije = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            permutacije.add(i);
        }
        do {
            if (!seNapadajo(permutacije)) {
                p++;
            }
        } while (novaPermutacija(permutacije));
        return p;
    }

    static boolean novaPermutacija(java.util.List<Integer> a) {
        int i = a.size() - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = a.size() - 1;
        while (a.get(i) >= a.get(j)) {
            j--;
        }

        java.util.Collections.swap(a, i, j);
        java.util.Collections.reverse(a.subList(i + 1, a.size()));
        return true;
    }

    static boolean seNapadajo(java.util.List<Integer> kraljice) {
        for (int i = 0; i < kraljice.size(); i++) {
            for (int j = 0; j < kraljice.size(); j++) {
                if (i != j) {
                    // Preverjanje diagonal
                    if (Math.abs(kraljice.get(i) - kraljice.get(j)) == Math.abs(i - j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

/*
Na ??ahovski deski velikosti nxn imamo postavljenih n kraljic. Polo??aj kraljic je predstavljen s tabelo int [] kraljice,
v kateri je za vsak stolpec zapisan polo??aj kraljice v tem stolpcu.

Napi??i metodo preveriInNarisi(int [] kraljice), ki izri??e ??ahovsko desko in na njej kraljice ter pod desko napi??e
???Kraljice se ne napadajo??? (??e se noben par kraljic med samo ne napada) oziroma ???Kraljice se napadajo??? (??e obstaja
vsaj en par kraljic, ki se napadata).

Primer: ob klicu preveriInNarisi(new int[]{1,3,0,2}) naj program izpi??e

 . . K .

K . . .

. . . K

. K . .

Kraljice se ne napadajo



ob klicu preveriInNarisi(new int[]{1,0,3,2}) pa



. K . .

K . . .

. . . K

. . K .

Kraljice se napadajo
 */