package kviz2;

public class kviz14 {
    
}

/*
Napiši metodo izpisKoledarja(int leto, int mesec), ki izpiše koledar za podani mesec.

Primer: ob klicu izpisKoledarja(2019, 3) naj program izpiše koledar za marec leta 2019

 

PO  TO  SR  ČE  PE  SO  NE
                 1   2   3
 4   5   6   7   8   9  10
11  12  13  14  15  16  17
18  19  20  21  22  23  24
25  26  27  28  29  30  31

 

Opomba: število dni v danem mesecu in prvi dan v mesecu lahko pridobite s spodnjimi metodami:

    java.time.YearMonth yearMonth = java.time.YearMonth.of(leto, mesec);
    int steviloDni = yearMonth.lengthOfMonth();   
    int prviDan    = java.time.LocalDate.of(leto, mesec, 01).getDayOfWeek().getValue();
*/