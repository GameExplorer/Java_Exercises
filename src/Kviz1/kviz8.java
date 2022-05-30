package Kviz1;

/*
Število n je praštevilo, če je večje od 1 in je deljivo le z 1 in n.

Napiši metodo

   boolean jePrastevilo(int n),

ki za dano število preveri, ali je praštevilo in vrne true, če je in false, če ni.
*/
public class kviz8 {
    public static void main(String[] args) {
        jePrastevilo(2);
    }
    public static boolean jePrastevilo(int n) {
        if (n < 0) {
            return false;
        } else if (n == 0) {
            return false;
        } else if (n == 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
}
