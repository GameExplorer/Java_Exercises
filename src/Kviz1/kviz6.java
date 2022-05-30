package Kviz1;

public class kviz6 {
    public static void main(String[] args){
        javaJavaJava(2);
    }

    public static void javaJavaJava(int n) {
        if (n < 0) {
            System.out.println("Napaka: negativen n");
        } 
        else {
            //prva vrstica 
            for (int i = 0; i < n; i++) {
                System.out.print("     J    a   v     v  a   ");
            }
            System.out.println();
            //druga vrstica
            for (int i = 0; i < n; i++) {
                System.out.print("     J   a a   v   v  a a  ");
            }
            System.out.println();
            //tretja vrstica
            for (int i = 0; i < n; i++) {
                System.out.print("  J  J  aaaaa   V V  aaaaa ");
            }
            System.out.println();
            //četrta vrstica
            for (int i = 0; i < n; i++) {
                System.out.print("   JJ  a     a   V  a     a");
            }
            System.out.println();
        }
    }
}

/*
Napiši metodo javaJavaJava(int n), ki n-krat izpiše besedo Java. Če je n negativen, naj metoda izpiše Napaka: negativen n .

Primer: pri n=3 naj program izpiše

 

   J    a   v     v  a         J    a   v     v  a         J    a   v     v  a      
   J   a a   v   v  a a        J   a a   v   v  a a        J   a a   v   v  a a     
J  J  aaaaa   V V  aaaaa    J  J  aaaaa   V V  aaaaa    J  J  aaaaa   V V  aaaaa    
 JJ  a     a   V  a     a    JJ  a     a   V  a     a    JJ  a     a   V  a     a 
*/