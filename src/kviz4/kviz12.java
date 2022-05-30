package kviz4;

import java.util.ArrayList;
import java.util.Arrays;

public class kviz12 {
    public static void main(String[] args) {
        ArrayListPlus alp1 = new ArrayListPlus();
        alp1.set(3, "3");
        alp1.set(4, "4");
        alp1.set(1, "1");
        System.out.println(alp1);
    }
}

class ArrayListPlus extends ArrayList<String> {

    ArrayListPlus() {
        super();
    }

    ArrayListPlus(String elements) {
        super();
        String[] elementi = elements.split(";");
        this.addAll(Arrays.asList(elementi));
    }

    public String set(int index, String element) {
        if (index >= this.size()) {
            for (int i = 0; i < index; i++) {
                if (i >= this.size()) {
                    this.add("");
                } else if (this.get(i) == null) {
                    this.set(index, "");
                }
            }
            this.add(element);
            return element;
        }
        return super.set(index, element);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String value : this) {
            s.append(String.format("%s;", value));
        }
        return s.toString().substring(0, s.length() - 1);
    }
}
/*
Napišite razred ArrayListPlus, ki predstavlja naslednik razreda ArrayList<String>. Razred ArrayListPlus  naj se od svojega očeta razlikuje v treh podrobnostih:



a) Če v razredu ArrayList kličemo metodo

  public Object set(int index, Object element)

z vrednostjo index, ki je večja ali enaka size(), ta vrže izjemo.  V razredu ArrayListPlus  popravite metodo set() tako, da bo v primeru klica s prevelikim indeksom element pravilno vstavila na konec seznama (na morebitna manjkajoča mesta v tabeli naj metoda vstavi prazne nize).



b) Metoda toString() v ArrayListPlus  naj vrne seznam elementov, ločenih s podpičjem.

c) Konstruktor ArrayListPlus(String elements), ki prejme seznam elementov, ločenih s podpičjem, naj ustvari seznam s temi elementi.



Ob pravilno napisanem razredu ArrayListPlus bo  klic  metode main()



public static void main(String[] args) {

 ArrayListPlus alp1 = new ArrayListPlus();

 alp1.set(3, "3");

 alp1.set(4, "4");

 alp1.set(1, "1");

 System.out.println(alp1);  // ;1;;3;4


 ArrayListPlus alp2 = new ArrayListPlus(";b;c;;;;g");

 System.out.println(alp2); //;b;c;;;;g


 ArrayListPlus alp3 = new ArrayListPlus(";b;c;;;;g");

 alp3.set(0, "a");

 alp3.set(4, "e");

 System.out.println(alp3); // a;b;c;;e;;g

}



izpisal



;1;;3;4

;b;c;;;;g

a;b;c;;e;;g
 */
