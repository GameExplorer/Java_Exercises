package kviz3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class kviz7 {
    public static void main(String[] args) {

    }
}

class Matrika {
    int[][] matrika;

    Matrika(int[][] matrika){
        this.matrika = matrika;
    }

    Matrika zmnozi(Matrika b) {
        int[][] produkt = new int[b.matrika.length][b.matrika.length];
        for(int i = 0; i < this.matrika.length; i++) {
            for(int j = 0; j < b.matrika.length; j++) {
                for(int k = 0; k < this.matrika.length; k++) {
                    produkt[i][j] += this.matrika[i][k] * b.matrika[k][j];
                }
            }
        }
        return new Matrika(produkt);
    }

    public void izpis() {
        for (int i = 0; i < this.matrika.length; i++) {
            for (int j = 0; j < this.matrika.length; j++) {
                System.out.printf("%2d", this.matrika[i][j]);
            }
            System.out.println();
        }
    }

    public static Matrika preberiMatriko(String imeDatoteke) {
        try {
            int i = 0;
            Scanner scanner = new Scanner(new File(imeDatoteke));
            int velikost = Integer.parseInt(scanner.nextLine());
            int[][] surovaMatrika = new int[velikost][velikost];

            while (scanner.hasNextLine()){
                String[] vrstica = scanner.nextLine().split(" ");
                for(int j = 0; j < vrstica.length; j++) {
                    surovaMatrika[i][j] = Integer.parseInt(vrstica[j]);
                }
                i++;
            }

            scanner.close();
            return new Matrika(surovaMatrika);
        }
        catch(Exception e) {
            System.out.print(e);
        }
        return null;
    }
}

/*
Napiši razred Matrika, ki predstavlja kvadratno matriko s celoštevilskimi koeficienti.  V razredu Matrika napiši metode
static Matrika preberi Matriko(String imeDatotake)
(prebere matriko iz datoteke), public Matrika zmnozi(Matrika b)
(zmnoži sebe (this) z matriko b in vrne product) ter public void izpisi()
 */