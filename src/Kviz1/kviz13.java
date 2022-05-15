package Kviz1;

public class kviz13 {
    public static void main(String[] args) {
        pitagoroviTrojcki(5);
    }

    public static void pitagoroviTrojcki(int x) {
        for (int a = 1; a <= x; a++) {
            for (int b = 1; b <= x; b++) {
                for (int c = 1; c <= x; c++) {
                    if (a <= b && b <= c && c <= x) {
                        if (a * a + b * b == c * c) {
                            System.out.printf("%d %d %d\n", a, b, c);
                        }
                    }
                }
            }
        }
    }
}
