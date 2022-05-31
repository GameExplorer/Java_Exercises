package Izpiti.Poletni2022;

import java.util.Arrays;

public class Naloga11 {

    public static void premakni(int[] tabela) {
        // poišči najmanjši element v tabeli
        int najmanjsi = tabela[0];
        for (int i = 1; i < tabela.length; i++) {
            if (tabela[i] < najmanjsi)
                najmanjsi = tabela[i];
        }
        // ciklično rotiraj elemente tabele, dokler prvi element ni enak najmanjšemu elementu
        while (tabela[0] != najmanjsi) {
            int tmp = tabela[0];
            for (int i = 1; i < tabela.length; i++) {
                tabela[i - 1] = tabela[i];
            }
            tabela[tabela.length - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] tabela = new int[args.length];
        for (int i = 0; i < tabela.length; i++)
            tabela[i] = Integer.parseInt(args[i]);

        System.out.printf("Vhodna tabela:    %s\n", Arrays.toString(tabela));
        premakni(tabela);
        System.out.printf("Rotirana tabela:  %s\n", Arrays.toString(tabela));
    }

}
/*
V tabeli imamo shranjena cela števila. Spodnji program dopolni z metodo premakni(), ki ciklično premakne elemente tabele
tako, da je na prvem mestu v tabeli najmanjši element, vrstni red elementov pa se pri tem ne spremeni.  Pri implementaciji
metode ne smeš ustvariti in uporabiti nobene nove tabele in ne smeš uporabljati nobenih dodatnih Javanskih razredov
(npr. za delo s tabelami ali nizi).

Primer:  Ob klicu programa  java Naloga11 3 5 -1 404 11 5 -5 9  naj program izpiše
Vhodna tabela:   [3, 5, -1, 404, 11, 5, -5, 9]
Rotirana tabela: [-5, 9, 3, 5, -1, 404, 11, 5]
 */