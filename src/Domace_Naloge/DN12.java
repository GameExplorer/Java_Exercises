package Domace_Naloge;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/*
Napiši program DN12, ki izpiše velikost podane PNG datoteke. Ime datoteke je podano kot prvi argument ob klicu programa.

Primer: ob klicu

java DN12 opica.png
naj program izpiše

219 x 230
Če vhodna datoteke ni formata PNG, naj program izpiše le ?.
 */
public class DN12 {

    public static void main(String[] args) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File(args[0])));
            byte[] buf = new byte[8];

            dis.read(buf); // header

            if (buf[1] != 'P' || buf[2] != 'N' || buf[3] != 'G') {
                System.out.println("?");
                return;
            }

            dis.read(buf); // header IHDR chunka

            int width = dis.readInt();
            int height = dis.readInt();

            System.out.printf("%d x %d\n", width, height);
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
}
