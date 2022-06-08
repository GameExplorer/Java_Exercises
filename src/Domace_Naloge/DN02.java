package Domace_Naloge;

/*
Napišite program DN02, ki argumente programa izpiše na zaslon. Pri tem naj vsak argument uokviri. Znak za okvir naj se
izmenično spreminja - prvi argument naj bo uokvirjen z znakom *, drugi z znakom +, tretji z *, ...

Primer: ob klicu programa

java DN02 pomlad poletje jesen zima
naj program izpiše

********** +++++++++++ ********* ++++++++
* pomlad * + poletje + * jesen * + zima +
********** +++++++++++ ********* ++++++++
 */
public class DN02 {

    public static void main(String[] args) {
        args = new String[]{"pomlad", "poletje", "jesen", "zima"};

        String obroba[] = {"*", "+"};

        if (args.length == 0) {
            System.out.println("Uporaba: java DN02 besede...");
        } else {
            // izpis obrobe v prvi vrstici
            for (int i = 0; i < args.length; i++) {
                // izpis
                for (int j = 0; j < args[i].length()+4; j++) {
                    System.out.print(obroba[i%2]);
                }
                System.out.print(" ");
            }
            System.out.println();

            // izpis besed
            for (int i = 0; i < args.length; i++) {
                System.out.printf("%s %s %s ", obroba[i % 2], args[i], obroba[i % 2]);
            }
            System.out.println();

            // izpis obrobe v zadnji vrstici
            for (int i = 0; i < args.length; i++) {
                // izpis
                for (int j = 0; j < args[i].length()+4; j++) {
                    System.out.print(obroba[i%2]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
