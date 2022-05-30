package kviz2;

/*
Napiši metodo int vsotaSkupnihCifer(int a, int b), ki izračuna vsoto vseh cifer, ki se hkrati pojavljajo v številu a in b. Če se katera od cifer pojavi večkrat, jo v vsoti upoštevaj le enkrat.

Primeri:
vsotaSkupnihCifer(13, 30) --> 3 (skupna je le cifra 3)
vsotaSkupnihCifer(1232, 302) --> 5 (2+3)
vsotaSkupnihCifer(527523, 905) --> 5 (skupna je le cifra 5)
*/

public class kviz8 {
    public static void main(String[] arga){
        System.out.println(vsotaSkupnihCifer(13, 30));
        System.out.println(vsotaSkupnihCifer(1232, 302));
        System.out.println(vsotaSkupnihCifer(527523, 905));
    }

    public static int vsotaSkupnihCifer(int a, int b) {
        int vsota = 0;
        String stavekA = Integer.toString(a);
        String stavekB = Integer.toString(b);
        java.util.HashSet<Integer> upostevana = new java.util.HashSet<>();

        for (int i = 0; i < stavekA.length(); i++) {
            for (int j = 0; j < stavekB.length(); j++) {
                int trenutenA = Character.getNumericValue(stavekA.charAt(i));;
                int trenutenB = Character.getNumericValue(stavekB.charAt(j));;
                if (trenutenA == trenutenB && !upostevana.contains(trenutenA)) {
                    vsota += trenutenA;
                    upostevana.add(trenutenA);
                }
            }
        }
        return vsota;

    }
}
