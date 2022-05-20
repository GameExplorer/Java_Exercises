package kviz2;

public class kviz2_1 {
    public static void main (String[] args) {
        
        int [] table = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] table2 = duplicates(table);
        for (int i = 0; i < table2.length; i++) {
            System.out.print(table2[i] + " ");
        }

    }
    /*
    Write an int [] cross-section method (int [[table], int [] table2), which receives two tables and returns their cross-section 
    (elements that are in the first and second tables at the same time). In cross section, each element appears at most once.
    */
    public static int [] presek (int [] tabela, int [] tabela2) {
        int [] tabela3 = new int [tabela.length + tabela2.length];
        int j = 0;
        for (int i = 0; i < tabela.length; i++) {
            for (int k = 0; k < tabela2.length; k++) {
                if (tabela[i] == tabela2[k]) {
                    tabela3[j] = tabela[i];
                    j++;
                }
            }
        }
        return tabela3;
    }
}
