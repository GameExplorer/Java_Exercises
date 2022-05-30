package Kviz1;

/*
Napiši metodo kalkulator(int a, int b), ki sešteje, odšteje, zmnoži, 
deli in izračuna ostanek po deljenju dveh števil. Če pride do deljenja z 0, 
naj program izpiše "Napaka: deljenje z 0" .
*/
public class kviz2 {
    public static void main(String[] args) {
        kalkulator(44, 5);
    }
    static void kalkulator(int a, int b) {
        if (b == 0){
            System.out.println("Napaka: deljenje z 0");
        }
        else {
            System.out.printf("%d + %d = %d\n", a,b, a + b);
            System.out.printf("%d - %d = %d\n", a,b, a - b);
            System.out.printf("%d x %d = %d\n", a,b, a * b);
            System.out.printf("%d / %d = %d\n", a,b, a / b);
            System.out.printf("%d %% %d = %d\n", a,b, a % b);
        }
    }


}
