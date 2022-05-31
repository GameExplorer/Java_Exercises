package Izpiti.Poletni2022;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Ocena {
    String id;
    String predmet;
    int    ocena;

    Ocena(String podatki) {
        String[] deli = podatki.split(":");
        id     = deli.length > 0 ? deli[0] : "?";
        predmet= deli.length > 1 ? deli[1] : "?";
        ocena  = deli.length > 2 ? Integer.parseInt(deli[2]) : 0;
    }
}

class Student {
    String id;
    String ime;

    Student(String podatki) {
        String[] deli = podatki.split(":");
        id     = deli.length > 0 ? deli[0] : "?";
        ime    = deli.length > 1 ? deli[1] : "?";
    }

}

public class Naloga12 {

    public static void main(String[] args) {
        args = new String[]{"src/izpiti/Poletni2022/viri/studenti.txt", "src/izpiti/Poletni2022/viri/predmeti.txt",
                "src/izpiti/Poletni2022/viri/ocene.txt"};
        ArrayList<Student> studenti = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(args[0]))) {
            while (sc.hasNextLine())
                studenti.add(new Student(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Napaka: "+e.toString());
        }

        ArrayList<String> predmeti = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(args[1]))) {
            while (sc.hasNextLine())
                predmeti.add(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Napaka: "+e.toString());
        }

        ArrayList<Ocena> ocene = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(args[2]))) {
            while (sc.hasNextLine())
                ocene.add(new Ocena(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Napaka: "+e.toString());
        }

        for (int i = 0; i < studenti.size(); i++) {
            Student s = studenti.get(i);
            System.out.println(s.ime);

            for (int j = 0; j < predmeti.size(); j++) {
                ArrayList<Integer> o = new ArrayList<>();
                for (int k = 0; k < ocene.size(); k++) {
                    if (ocene.get(k).predmet.equals(predmeti.get(j)) &&
                            studenti.get(i).id.equals(ocene.get(k).id))
                        o.add(ocene.get(k).ocena);
                }
                Collections.sort(o);
                String oS = o.toString().replaceAll("[\\[\\]]", "");
                if (oS.isEmpty()) oS = "/";
                System.out.printf("  %5s: %s\n", predmeti.get(j), oS);
            }
        }
    }
}
/*
Podatki o študentih in njihovih ocenah so zapisani v treh datotekah:  1. seznam študentov (podatki: vpisna številka in ime),
2. seznam predmetov (podatki: kratica predmeta), 3. seznam ocen (podatki: vpisna številka, kratica predmeta in ocena).
Naloga: napiši program Naloga12, ki za vse študente iz seznama študentov izpiše vse ocene pri predmetih, ki so navedeni v
seznamu predmetov.  Študenti in predmeti naj bodo izpisani v istem vrstnem redu, kot so navedeni v vhodnih datotekah,
ocene študenta pa naj bodo urejene po velikosti od najmanjše proti največji. Če študent pri posameznem predmetu ni
prejel ocene, naj program izpiše znak “/”.  Primer:  Ob klicu programa  java Naloga12 studenti.txt predmeti.txt ocene.txt
naj program izpiše
  Micka Kovačeva
  P2: 10    APS2: 5, 9
  OS: / Lolek Bolek
  P2: /
  APS2: /
  OS: 5, 7
 */