/*
Napiši metodo int[] unija(int[] tabela1, int[] tabela2), ki prejme dve tabeli in vrne njuno unijo (torej tabelo, ki vsebuje vse elemente prve in druge tabele). Velikost izhodne tabele naj bo enaka vsoti velikosti vhodnih tabel.
*/
package kviz2;

import java.util.Arrays;

public class kviz1 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(unija(new int[] {3, 6, 9, 1, 3, 5}, new int[] {3, 4, 6, 1, 3, 8})));
    }
    public static int [] unija (int [] tabela, int [] tabela2) {
        int [] tabela3 = new int [tabela.length + tabela2.length];
        int j = 0;
        for (int i = 0; i < tabela.length; i++) {
            tabela3[j] = tabela[i];
            j++;
        }
        for (int i = 0; i < tabela2.length; i++) {
            tabela3[j] = tabela2[i];
            j++;
        }
        return tabela3;
    }
}
