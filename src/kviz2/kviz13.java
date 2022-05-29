package kviz2;

public class kviz13 {
    
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
    int[] pascal = new int[n];
    pascal[0] = 1;
    for (int i = 1; i < n; i++) {
        pascal[i] = pascal[i - 1] * (n - i + 1) / i;
    }
    return pascal;
}