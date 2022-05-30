package kviz2;

public class kviz12 {
    public static void main(String[] args) {
        System.out.println(fibo(5));
    }

    public static int fibo(int n ){

        int[][] tabela = new int[n][n];
        int vsota = 0;
        int rezultat = 0, f1 = 1, f2 = 1;
        int k = 0, v = 0;
    
        for(int i = 1; i <= Math.pow(n, 2); i++) {
            if ( i < 3) {
                rezultat = 1;
            }
            else {
                rezultat += f1;
                f1 = f2;
                f2 = rezultat;
    
            }
            tabela[v][k] = rezultat;
            k++;
    
            if (i % n == 0) {
                v++;
                k = 0;
            }
        }
    
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j || n - j == i + 1) {
                    vsota += (i == j && n - j == i + 1) ? tabela[i][j] * 2 : tabela[i][j];
                }
            }
        }
    
        return vsota;
    }
}

/*
Napiši metodo int fibo(int n), ki ustvari in napolni tabelo z n vrsticami in n stolpci ter jo napolni s Fibonaccijevimi števili 
(najprej napolni prvo vrstico, nato drugo, …, nazadnje napolni zadnjo vrstico tabele). Na koncu naj metoda izračuna vsoto vseh elementov na obeh diagonalah in jo vrne.

Primer: ob klicu fibo(3) metoda ustvari tabelo


1    1   2
3    5   8
13  21  34

In vrne rezultat 60 (=1+5+34+13+5+2).
*/



