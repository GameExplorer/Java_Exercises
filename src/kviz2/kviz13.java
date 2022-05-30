package kviz2;
public class kviz13 {
    public static void main(String[] args){
        System.out.println(pascal(10));
    }
    /*
    Napiši metodo int[] pascal(int n), ki ustvari in vrne n-to vrstico Pascalovega trikotnika.

    Primeri:

    pascal(1)  -> {1}

    pascal(3)  -> {1, 3, 3, 1}

    pascal(7)  -> {1, 6, 15, 20, 15, 6, 1}
    */

    /*
    Write an int [] pascal (int n) method that creates and returns the n 
    line of the Pascal triangle.
    */
    public static int[] pascal(int n) {
        int[] pascal = new int[] {1};
        for (int i = 2; i <= n; i++) {
            int[] pascal2 = new int[i];
            pascal2[0] = 1;
            pascal2[i-1] = 1;
            for (int j = 1; j < i-1; j++) {
                pascal2[j] = pascal[j-1] + pascal[j];
            }
            pascal = pascal2;
        }
        return pascal;
    }
}



