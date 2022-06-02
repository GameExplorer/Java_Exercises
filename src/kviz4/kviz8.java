package kviz4;

public class kviz8 {
    public static void main(String[] args) {
        izracunaj("src/kviz4/assets/test1.clc");
    }
    static void izracunaj(String imeDatoteke) {
        try {
            java.io.DataInputStream ds = new java.io.DataInputStream(new java.io.FileInputStream(new java.io.File(imeDatoteke)));
            if (ds.readByte() == 0x43 && ds.readByte() == 0x41 && ds.readByte() == 0x4C && ds.readByte() == 0x43) {
                int steviloRacunov = ds.readInt();
                for (int i = 0; i < steviloRacunov; i++) {
                    int prviOperand = ds.readInt();
                    byte operacija = ds.readByte();
                    int drugiOperand = ds.readInt();
                    switch (operacija) {
                        case 0x2A:
                            System.out.println(prviOperand * drugiOperand);
                            break;
                        case 0x2B:
                            System.out.println(prviOperand + drugiOperand);
                            break;
                        case 0x2D:
                            System.out.println(prviOperand - drugiOperand);
                            break;
                        case 0x2F:
                            System.out.println(prviOperand / drugiOperand);
                            break;
                        default:
                            System.out.println("Napačen operator.");
                            ds.close();
                            return;
                    }
                }
            } else {
                System.out.println("Datoteka test2.clc ni v formatu CLC!");
            }
            ds.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Napišite metodo

  void izracunaj(String imeDatoteke)

prebere in obdela datoteko s končnico .clc (datoteka v formatu CLC vsebuje več računov, zapisanih v binarnem formatu - za podrobnosti o formatu glej spodaj). Metoda naj prebere  celotno datoteko in izračuna vse v njej podane račune in na standardni izhod izpiše rezultate (rezultat vsakega od računov v svojo vrstico).

Primer, ob klicu izracunaj("test1.clc") naj metoda izpiše:

7
12
4
1

Pri testiranju se bodo uporabile še sledeče datoteke: test2.clc, test3.clc, test4.clc in test5.clc. Če podana datoteka ni zapisana v pravem formatu (manjka glava), naj program izpiše "Datoteka .... ni v formatu CLC!". Če med branjem računov metoda naleti na napačen operator, naj izpiše "Napačen operator." in konča.



Opis formata  CLC

Prvi štirje bajti so glava datoteke in imajo šestnajstiške vrednosti 43, 41, 4c in 43 (CALC). Sledijo štirje bajti, v katerih je zapisano število računov. Vsak račun zavzema 9 bajtov: 4 bajte za prvi operand, 1 bajt za operacijo (znak +,-,* ali /) in 4 bajte za drugi operand. Operacije in operandi so celoštevilski.

Nasvet: preden začnete pisati program, si oglejte vsebino datoteke z uporabo programa hexdump.
 */