package Izpiti.Poletni2022;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Arrays;

public class Naloga22 {
    // rešitev z branjem datoteke po bajtih
    public static void preberi(String dat) {
        byte[] podpis = {0x50, 0x32};
        try (FileInputStream vhod = new FileInputStream(dat)) {
            byte[] glava = new byte[2];
            if (vhod.read(glava) == 2 && Arrays.equals(glava, podpis)) {
                byte[] stevilka = new byte[4];
                while (vhod.available() > 3) {
                    vhod.read(stevilka);
                    StringBuilder sb = new StringBuilder("0");
                    for (int i = 0; i < stevilka.length; i++) {
                        sb.append(String.format("%02x", stevilka[i]));
                    }
                    sb.insert(3, " ");
                    sb.insert(7, " ");
                    System.out.println(sb.toString());
                }
            } else
                System.out.println("Datoteka ni pravega formata.");
        } catch (Exception e) {
            System.out.println("Napaka: problem z datoteko.");
        }
    }

    // rešitev z uporabo DataInputStream
    public static void preberi1(String dat) {
        byte[] podpis = {0x50, 0x32};
        try (DataInputStream vhod = new DataInputStream(new FileInputStream(dat))) {
            byte[] glava = new byte[2];
            if (vhod.read(glava) == 2 && Arrays.equals(glava, podpis)) {
                while (vhod.available() > 3) {
                    int stevilka = vhod.readInt();
                    StringBuilder sb = new StringBuilder(String.format("0%x", stevilka));
                    sb.insert(3, " ");
                    sb.insert(7, " ");
                    System.out.println(sb.toString());
                }
            } else
                System.out.println("Datoteka ni pravega formata.");
        } catch (Exception e) {
            System.out.println("Napaka: problem z datoteko.");
        }
    }

    public static void main(String[] args) {
        preberi(args[0]);
    }
}



