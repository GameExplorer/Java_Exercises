/*
Napiši metodo int [] duplikati(int [] tabela), ki v podani tabeli izbriše podvojene elemente ter vrne tabelo brez duplikatov.
*/
package kviz2;

public class kviz5 {
    public static void main(String[] args) {
        duplikati(new int[] {3,6,9,1,3,5,7,8,9});
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
