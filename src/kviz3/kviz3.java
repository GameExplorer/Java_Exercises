package kviz3;

public class kviz3 {
    public static void main(String[] args){

    }

    public static boolean jeAnagram(String prvaBeseda, String drugaBeseda, boolean zanemariVelikost){
        

        if (prvaBeseda.length() != drugaBeseda.length()) {
            return false;
        }
        if (prvaBeseda.length() == 0) {
            return true;
        }
        if (zanemariVelikost) {
            prvaBeseda = prvaBeseda.toLowerCase();
            drugaBeseda = drugaBeseda.toLowerCase();
        }
        String crka = Character.toString(prvaBeseda.charAt(0));
        if (drugaBeseda.contains(crka)) {
            return jeAnagram(prvaBeseda.substring(1), drugaBeseda.replaceFirst(crka, ""), zanemariVelikost);
        }
        return false;
    }
}

/*
Napiši metodo

       boolean jeAngram(String prvaBesede, String drugaBeseda, boolean zanemariVelikost),

ki za podani besedi ugotovi, ali sta anagrama ali ne. Anagram besede  je beseda, ki jo je možno dobiti s prerazporeditvijo (brez dodajanja ali brisanja) črk prve besede. Upoštevajte, da beseda ni sama sebi anagram.

Tretji parameter (zanemariVelikost) uporabljamo za razlikovanje med velikimi in malimi črkami (primer: beseda  “abc” je anagram besede BCA, le v primeru, da je zanemariVelikost == true).
*/