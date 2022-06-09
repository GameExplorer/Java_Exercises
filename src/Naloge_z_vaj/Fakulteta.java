package Naloge_z_vaj;


public class Fakulteta {

    // vrne celoštevilsko vrednost fakultete
    public static long fakultetaL(int n) {
        long rezultat = 1;
        for (int i = 2; i <= n; i++) {
            rezultat = rezultat * i;
        }
        return rezultat;
    }

    // rekurzivna rešitev
    public static long fakultetaR(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fakultetaR(n - 1);
    }

    // vrne celoštevilski približek fakultete po Stirlingu
    public static long stirlingL(int n) {
        return Math.round(Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n));
    }

    // vrne fakulteto kot realno število (tip double ima večji obseg kot tip long)
    public static double fakultetaD(int n) {
        double rezultat = 1;
        for (int i = 2; i <= n; i++) {
            rezultat = rezultat * i;
        }
        return rezultat;
    }

    // vrne realni približek fakultete po Stirlingu
    public static double stirlingD(int n) {
        return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
    }

    // tabeliraj za n od 1 do 20, celoštevilski izračun Stirlingove formule
    public static void izpisTabelaL() {
        System.out.printf("%3s %15s %22s %15s\n", "n", "n!", "Stirling(n)", "napaka (%)");
        for (int i = 0; i < 58; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 1; i <= 20; i++) {
            long f = fakultetaL(i);
            long s = stirlingL(i);
            double napaka = 100.0 * (f - s) / f;
            System.out.printf("%3d %20d %20d %11.7f\n", i, f, s, napaka);
        }
    }

    // tabeliraj za n od 1 do 100, realni izračun Stirlingove formule
    public static void izpisTabelaD() {
        System.out.printf("%3s %10s %22s %14s\n", "n", "n!", "Stirling(n)", "napaka (%)");
        for (int i = 0; i < 52; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 1; i <= 100; i++) {
            double f = fakultetaD(i);
            double s = stirlingD(i);
            double napaka = 100 * (f - s) / f;
            System.out.printf("%3d %17.9E %17.9E %11.7f\n", i, f, s, napaka);
        }
    }

    // DODATNI IZZIV
    // računanje približka Pi
    private static double ulomek(int i, int max) {
        if (i == max) {
            return 0.0;
        }
        return (i * i) / ((2.0 * i + 1.0) + ulomek(i + 1, max));
    }

    public static double izracunajPiRekurzivno(int k) {
        return 4.0 / (1 + ulomek(1, k));
    }

    public static double izracunajPi(int k) {
        double rez = 0.0;
        for (int i = k - 1; i > 0; i--) {
            rez = (i * i) / ((2.0 * i + 1.0) + rez);
        }
        return 4.0 / (1.0 + rez);
    }

    public static void izpisTabelaPi() {
        System.out.printf("  k     Math.PI             PI (rekurzivno)     PI (iterativno)      razlika \n");
        System.out.printf("-------------------------------------------------------------------------------------\n");
        for (int n = 1; n <= 22; n++) {
            double piRek = izracunajPiRekurzivno(n);
            System.out.printf("%3d   %.15f   %.15f   %.15f   %+.15f\n", n, Math.PI, piRek, izracunajPi(n), Math.PI - piRek);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        izpisTabelaL();
        System.out.println();
        izpisTabelaD();
        System.out.println();

        // dodatni izziv
        izpisTabelaPi();
    }
}
