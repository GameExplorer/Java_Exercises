package Naloge_z_vaj;


public class Zanke {

    public static void pravokotnik(int odmik, int sirina, int visina) {
        // narišemo visina vrstic
        for (int vrstica = 0; vrstica < visina; vrstica++) {
            // v vsaki vrstici narišemo odmik presledkov
            for (int stolpec = 0; stolpec < odmik; stolpec++) {
                System.out.print(" ");
            }
            // in nato narišemo še sirina znakov #
            for (int stolpec = 0; stolpec < sirina; stolpec++) {
                System.out.print("#");
            }
            // zaključimo vrstico
            System.out.println();
        }
    }

    public static void trikotnik(int odmik, int visina) {
        for (int vrstica = 0; vrstica < visina; vrstica++) {
            for (int stolpec = 0; stolpec < odmik + (visina - vrstica - 1); stolpec++) {
                System.out.print(" ");
            }
            for (int stolpec = 0; stolpec < 2 * vrstica + 1; stolpec++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void trikotnikV(int odmik, int visina) {
        for (int vrstica = visina - 1; vrstica >= 0; vrstica--) {
            for (int stolpec = 0; stolpec < odmik + (visina - vrstica - 1); stolpec++) {
                System.out.print(" ");
            }
            for (int stolpec = 0; stolpec < 2 * vrstica + 1; stolpec++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void romb(int odmik, int velikost) {
        // nariši zgornjo polovico
        for (int vrstica = 0; vrstica < velikost; vrstica++) {
            for (int stolpec = 0; stolpec < odmik + (velikost - vrstica - 1); stolpec++) {
                System.out.print(" ");
            }
            for (int stolpec = 0; stolpec < 2 * vrstica + 1; stolpec++) {
                System.out.print("#");
            }
            System.out.println();
        }
        // nariši spodnjo polovico, za ena manjše velikosti
        for (int vrstica = velikost - 2; vrstica >= 0; vrstica--) {
            for (int stolpec = 0; stolpec < odmik + (velikost - vrstica - 1); stolpec++) {
                System.out.print(" ");
            }
            for (int stolpec = 0; stolpec < 2 * vrstica + 1; stolpec++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    // ker imamo že napisani metodi trikotnik() in trikotnikV(),
    // lahko romb naredimo enostavneje z uporabo obeh metod
    public static void romb1(int odmik, int velikost) {
        trikotnik(odmik, velikost);
        trikotnikV(odmik + 1, velikost - 1);
    }

    public static void smreka(int velikost) {
        // krošnjo sestavlja velikost trikotnikov
        // prvi je velikosti 2, vsak naslednji je za eno večji
        for (int i = 0; i < velikost; i++) {
            trikotnik(velikost - i - 1, i + 2);
        }
        // širina debla je velikost
        int sirina = velikost;
        // oziroma za ena manjša, če je velikost sodo število
        if (velikost % 2 == 0) {
            sirina -= 1;
        }
        pravokotnik((2 * velikost + 1 - sirina) / 2, sirina, 2 * velikost);
    }

    //
    // REŠITVE DODATNIH IZZIVOV
    //
    public static void rombA(int odmik, int velikost) {
        for (int vrstica = 0; vrstica < velikost; vrstica++) {
            for (int stolpec = 0; stolpec < odmik + velikost - vrstica - 1; stolpec++) {
                System.out.print("  ");
            }
            for (int stolpec = 0; stolpec < 2 * vrstica + 1; stolpec++) {
                System.out.print("# ");
            }
            System.out.println();
        }
        for (int vrstica = velikost - 2; vrstica >= 0; vrstica--) {
            for (int stolpec = 0; stolpec < odmik + velikost - vrstica - 1; stolpec++) {
                System.out.print("  ");
            }
            for (int stolpec = 0; stolpec < 2 * vrstica + 1; stolpec++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void rombPrazen(int odmik, int velikost) {
        for (int vrstica = 0; vrstica < velikost; vrstica++) {
            for (int stolpec = 0; stolpec < odmik; stolpec++) {
                System.out.print("  ");
            }
            for (int stolpec = 0; stolpec < 2 * velikost - 1; stolpec++) {
                if ((stolpec > velikost - vrstica - 1) && (stolpec < velikost + vrstica - 1)) {
                    System.out.print("  ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        for (int vrstica = velikost - 2; vrstica >= 0; vrstica--) {
            for (int stolpec = 0; stolpec < odmik; stolpec++) {
                System.out.print("  ");
            }
            for (int stolpec = 0; stolpec < 2 * velikost - 1; stolpec++) {
                if ((stolpec > velikost - vrstica - 1) && (stolpec < velikost + vrstica - 1)) {
                    System.out.print("  ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }

    public static void dvaPravokotnika(int odmik, int sirina, int visina, int razmik) {
        for (int i = 0; i < visina; i++) {
            for (int k = 0; k < odmik; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < sirina; k++) {
                System.out.print("#");
            }
            for (int k = 0; k < razmik; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < sirina; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void iks(int n) {
        for (int i = 0; i < n - 1; i++) {
            dvaPravokotnika(5 * i, 5, 3, 5 * (2 * ((n - 1) - i) - 1));
        }
        pravokotnik(5 * (n - 1), 5, 3);
        for (int i = n - 2; i >= 0; i--) {
            dvaPravokotnika(5 * i, 5, 3, 5 * (2 * ((n - 1) - i) - 1));

        }
    }

    public static void main(String[] args) {
        pravokotnik(5, 7, 3);
        System.out.println();
        trikotnik(5, 3);
        System.out.println();
        trikotnikV(1, 5);
        System.out.println();
        romb(2, 5);
        System.out.println();
        smreka(3);
        System.out.println();
        smreka(4);
        System.out.println();
        smreka(5);
        System.out.println();

        // dodatni izzivi
        rombA(1, 5);
        System.out.println();
        rombPrazen(3, 5);
        System.out.println();
        iks(3);
        System.out.println();
        iks(4);
        System.out.println();
        iks(5);
        System.out.println();
    }
}