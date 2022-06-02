package Kviz1;

/*
Napiši metodo izrisiZastavo(int n), ki izriše zastavo različnih velikosti, kot prikazujejo spodnji primeri.

Primer za n = 1, 2, 3:
*/
public class kviz9 {
    public static void main(String[] args) {
        izrisiZastavo(4);
    }
    private static void izrisiZastavo(int n) {
        for (int i = 0; i < n * 5; i++) {
            if (i < n * 3) {
                for (int j = 0; j < n * 4 - 1; j++) {
                    if (j % 2 == i % 2) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print(" ");
                for (int j = 0; j < n * 12 - (n - 1); j++) {
                    System.out.print("=");
                }
            } else {
                for (int j = 0; j < n * 16 - (n - 1); j++) {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }
}
