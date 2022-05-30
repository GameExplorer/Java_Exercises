package kviz2;

/*
Napiši metodo int[] presek(int[] tabela1, int[] tabela2), ki prejme dve tabeli in vrne njun presek (elemente, ki so hkrati v prvi in drugi tabeli). V preseku se vsak elementi pojavijo največ enkrat.
*/

public class kviz2 {
    public static void main(String[] args) {
        System.out.print(presek(new int[] {3,6,9,1,3,5,7,8,9}, new int[] {1,2,3,4,5,6,7,8,9}));
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
