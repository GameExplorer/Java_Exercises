package kviz4;

public class kviz6 {
    public static void main(String[] args) {
        preveri("05 / 350 951", "src/kviz4/assets/skrito.dat");
    }
    static void preveri(String stevilka, String imeDatoteke) {
        try {
            java.io.FileInputStream fs = new java.io.FileInputStream(new java.io.File(imeDatoteke));
            int i = 1;
            StringBuilder trenutnaStevilka = new StringBuilder();
            while (fs.available() > 0) {
                int znak = fs.read();
                trenutnaStevilka.append(String.format("%8s", Integer.toBinaryString(znak)).replace(" ", "0"));
                if (i % 3 == 0) {
                    String zeljenaStevilka = String.valueOf(Integer.parseInt(trenutnaStevilka.toString(), 2));
                    String formatiranaStevilka = String.format("0%s / %s %s",
                            zeljenaStevilka.charAt(0), zeljenaStevilka.substring(1, 4), zeljenaStevilka.substring(4, 7));
                    if (stevilka.equalsIgnoreCase(formatiranaStevilka)) {
                        System.out.println("Številka " + stevilka + " je v datoteki");
                        fs.close();
                        return;
                    }
                    trenutnaStevilka = new StringBuilder();
                }
                i++;
            }
            System.out.println("Številke " + stevilka + " ni v datoteki");
            fs.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    static int[] getVrstica(int n) {
        java.util.ArrayList<int[]> vrstice = new java.util.ArrayList<>();
        vrstice.add(new int[] { 1 });
        for (int i = 2; i <= n; i++) {
            int zacetnaStevilka = i % 10;
            int[] vrstica = new int[i];
            vrstica[0] = zacetnaStevilka;
            for (int j = 1; j < i; j++) {
                vrstica[j] = (vrstica[j - 1] + vrstice.get(i - 2)[j - 1]) % 10;
            }
            vrstice.add(vrstica);
        }
        return vrstice.get(n - 1);
    }
    /*
S seštevanjem po modulu 10 lahko sestavimo trikotnik, ki ga sestavljajo števke na naslednji način:

Trikotnik se začne z ena in v vsaki vrstici prva številka določa številko vrstice. Poleg tega prva številka v vrstici določa tudi število številk v tej vrstici (po modulu 10).
Vse druge številke v vrsticah izračunamo tako, da po modulu 10 seštejemo številko na levi in številko nad njo.
Primer: na sliki spodaj je prikazanih prvih 12 vrstic trikotnika:

Napiši metodo

  int[] getVrstica(int n),

ki vrne n-to vrstico takega trikotnika v obliki tabele n števil.


Primer: ob klicu getVrstica(11) metoda vrne tabelo {1,1,0,6,4,2,2,0,2,8,4}.
     */
}
