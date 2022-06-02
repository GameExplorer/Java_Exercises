package Kviz1;

/*
Napiši metodo void narisiDrevo(int n), ki nariše drevo velikosti n. Številke ni potrebno izpisati.
Primer dreves za n=0, 1, …, 7
*/

public class kviz14 {
    public static void main(String[] args) {
        narisiDrevo(10);
    }
    public static void narisiDrevo(int n) {
        switch (n) {
            case 0:
                System.out.println(" . ");
                break;
            case 1:
                System.out.println(" | ");
                break;
            case 2:
                System.out.println(" | ");
                System.out.println(" | ");
                break;
            default:
                if (n % 2 == 1) {
                    System.out.println(" * ");
                    n--;
                }
                for (int i = 1; i <= n - 2; i++) {
                    System.out.print("* ");
                    if (i % 2 == 0) {
                        System.out.println();
                    }
                }
                System.out.println(" | ");
                System.out.println(" | ");
        }
    }
}
