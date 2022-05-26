package kviz2;

public class kviz5 {
    public static void main(String[] args) {
        
    }
    /*
    Write the int [] duplicates method (int [] table), which deletes 
    duplicate elements in the specified table and returns a table 
    without duplicates.
    */
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
