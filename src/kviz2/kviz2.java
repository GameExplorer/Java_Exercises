package kviz2;


public class kviz2 {
    public static void main(String[] args) {

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
