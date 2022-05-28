
package kviz2;
public class kviz1 {
    public static void main(String[] args){
       
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
