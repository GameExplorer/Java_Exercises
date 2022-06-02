package kviz2;

/*
Napiši metodo int[] presek(int[] tabela1, int[] tabela2), ki prejme dve tabeli in vrne njun presek (elemente, ki so hkrati v prvi in drugi tabeli). V preseku se vsak elementi pojavijo največ enkrat.
*/

import java.util.Arrays;

public class kviz2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(presek(new int[] {9,4,6,3}, new int[] {1,6,3,9,0})));
    }
    public static int [] presek (int [] tabela, int [] tabela2) {
        java.util.ArrayList<Integer> presek = new java.util.ArrayList<Integer>();
        for (int i = 0; i < tabela.length; i++) {
            for (int k = 0; k < tabela2.length; k++) {
                if (tabela[i] == tabela2[k] && !presek.contains(tabela[i])) {
                    presek.add(tabela[i]);
                }
            }
        }
        int[] presek2 = new int[presek.size()];
        for (int i = 0; i < presek.size(); i++) {
            presek2[i] = presek.get(i);            
        }

        return presek2;
    }
}
