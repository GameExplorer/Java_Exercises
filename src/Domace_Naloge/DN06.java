package Domace_Naloge;

public class DN06 {

    // Kontrolna vsota BSD (povzeto po https://en.wikipedia.org/wiki/BSD_checksum)
    static int bsdChecksum(String niz) {
        int checksum = 0;

        for (int i = 0; i<niz.length(); i++) {
            checksum = (checksum >> 1) + ((checksum & 1) << 15);
            checksum += niz.charAt(i);
            checksum &= 0xffff;       /* Keep it within bounds. */
        }
        return checksum;
    }

    // Motoda prejme niz in vrne prvi po abecedi večji ni
    static String povecaj(String niz) {
        int z = niz.length()-1;

        // poiščem prvo črko od zadaj, ki je različna od z ...
        while (z >= 0) {
            // ... če taka črka obstaja, jo povečam, vse črke za njo pa postavim na 'a';
            if (niz.charAt(z) < 'z')
                return niz.substring(0,z) + ((char)(niz.charAt(z)+1)) + "a".repeat(niz.length()-z-1);
            else
                z=z-1;
        }
        // ... če pa taka črka ne obstaja, večjega niza te dolžine ni, zato vrnem null
        return null;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Program potrebuje en argument!");
            System.exit(0);
        }

        String niz = args[0];
        int csNiz = bsdChecksum(niz);

        // začnem z nizom, ki je enako dolg kot 1. argument in je sestavljen iz samih 'a'-jev
        String trNiz="a".repeat(niz.length());

        while (trNiz != null) {
            // izracunam BSD trenutnega niza ...
            int csTr=bsdChecksum(trNiz);
            // ... in ga primerjam z BSD 1. argumenta; če sta enaka, niz izpišem ...
            if (csTr == csNiz) {
                System.out.println(trNiz);
                System.exit(0);
            }
            // ... sicer niz "povecam" in nadaljujem z iskanjem
            trNiz = povecaj(trNiz);
        }
    }
}
