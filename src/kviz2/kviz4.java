/*
Napiši metodo void rotiraj(int [] tabela, int k), ki podano tabelo  rotira za k. Tako na primer iz tabele [1, 2, 3, 4, 5, 6] pri rotiranju za k = 1 dobimo [2, 3, 4, 5, 6, 1] ali za k = 2 dobimo [3, 4, 5, 6, 1, 2]. Vrednost k je pozitivno celo število.
*/
package kviz2;

public class kviz4 {
   public static void main(String[] args) {
    int[] t = new int[] {1, 2, 3, 4, 5, 6};
    rotiraj(t, 3);
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
