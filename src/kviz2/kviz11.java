package kviz2;

/*
Napiši metodo String vMorse(String niz),ki podani niz pretvori v Morsejevo abecedo. Pri pretvorbi male črke spremeni v velike, za ločilo med posameznimi črkami uporabi presledek, za ločilo med besedami pa dva presledka.

Podatke o črkah Morsejeve abecede lahko dobiš tule.
*/

public class kviz11 {
    public static void main(String[] args) {

        System.out.print(vMorse("SOS"));
    }

    public static String vMorse(String niz) {
        java.util.HashMap<Character, String> morse = new java.util.HashMap<Character, String>();
        morse.put('A', ".-");
        morse.put('B', "-...");
        morse.put('C', "-.-.");
        morse.put('D', "-..");
        morse.put('E', ".");
        morse.put('F', "..-.");
        morse.put('G', "--.");
        morse.put('H', "....");
        morse.put('I', "..");
        morse.put('J', ".---");
        morse.put('K', "-.-");
        morse.put('L', ".-..");
        morse.put('M', "--");
        morse.put('N', "-.");
        morse.put('O', "---");
        morse.put('P', ".--.");
        morse.put('Q', "--.-");
        morse.put('R', ".-.");
        morse.put('S', "...");
        morse.put('T', "-");
        morse.put('U', "..-");
        morse.put('V', "...-");
        morse.put('W', ".--");
        morse.put('X', "-..-");
        morse.put('Y', "-.--");
        morse.put('Z', "--..");
        morse.put('1', ".----");
        morse.put('2', "..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put('.', ".-.-.-");
        morse.put('?', "..--..");
        morse.put('"', ".--..--.");
        morse.put(':', "---...");
        morse.put('(', "-.--.-");
        morse.put(' ', "");


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < niz.length(); i++) {
            char znak = Character.toUpperCase(niz.charAt(i));
            sb.append(morse.get(znak));
            sb.append(" ");
        }
        return sb.toString();

    }
}

/*
Napiši metodo String vMorse(String niz),ki podani niz pretvori v 
Morsejevo abecedo. Pri pretvorbi male črke spremeni v velike, za ločilo 
med posameznimi črkami uporabi presledek, za ločilo med besedami pa dva presledka.
*/


