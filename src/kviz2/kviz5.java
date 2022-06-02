/*
Napiši metodo int [] duplikati(int [] tabela), ki v podani tabeli izbriše podvojene elemente ter vrne tabelo brez duplikatov.
*/
package kviz2;

import java.util.Arrays;

public class kviz5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(duplikati(new int[] {1, 5, 8, 56, 3, 9, 1, 43, 1, 2, 56, 12, 1, 3})));

    }
    public static int[] duplikati(int[] tabela) {
        java.util.ArrayList<Integer> duplikati = new java.util.ArrayList<>();
        for (int i : tabela) {
            if(!duplikati.contains(i)) {
                duplikati.add(i);
            }
        }
        int[] nova = new int[duplikati.size()];
        int j = 0;
        for (int i : duplikati) {
            nova[j] = i;
            j++;
        }
        return nova;
    }


}
