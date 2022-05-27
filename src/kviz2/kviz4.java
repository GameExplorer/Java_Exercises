package kviz2;

public class kviz4 {
   public static void main(String[] args) {

   }

   static void rotiraj (int[] tabela, int k) {
       for(int i = 0; i < k; i++){
        int tabela2 = tabela[0];
           for(int j = 0; j < tabela.length - 1; j++){
               tabela[j] = tabela[j+1];
           }
        tabela[tabela.length - 1] = tabela2;
       }
   }
}
