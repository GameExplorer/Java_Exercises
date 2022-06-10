package imenik;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Imenik {
    private Oseba[] osebe = new Oseba[0]; // tabela, v kateri hranimo podatke o osebah

    /**
     * Prebere seznam oseb iz datoteke in jih shrani v tabelo.
     * Če datoteka ne obstaja, sproži izjemo.
     *
     * @param vir pot do datoteke
     * @return true, če je branje oseb uspešno; false, če neuspešno prebrane vse osebe
     */
    public boolean preberiOsebe(String vir) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(vir));
        int stevilo = 0;
        if (sc.hasNextLine())
            stevilo = Integer.parseInt(sc.nextLine());
        osebe = new Oseba[stevilo];
        int i = 0;
        while (i < stevilo && sc.hasNextLine()) {
            String[] deli = sc.nextLine().split(", ");
            if (deli.length < 4) // ni vseh podatkov za to osebo
                continue;
            boolean mob = false;
            if (deli.length > 4 && deli[4].equalsIgnoreCase("mobilni"))
                mob = true;
            Oseba o = new Oseba(deli[0], deli[1], deli[2], deli[3], mob);
            osebe[i] = o;
            i++;
        }
        sc.close();
        if (stevilo == 0 || i < stevilo) // nismo shranili toliko oseb, kot naj bi jih bilo v datoteki (prva vrstica)
            return false;
        return true;
    }

    /**
     * Izpiše podatke oseb v imeniku.
     */
    public void izpisiImenik() {
        System.out.printf("Osebe v imeniku (%d):%n", osebe.length);
        for (int i = 0; i < osebe.length; i++) {
            System.out.println(osebe[i].toString());
        }
    }

    /**
     * V imeniku poišče osebo z imenom ime. Pri tem ne upošteva velikih/malih črk.
     *
     * @param ime ime iskane osebe
     * @return Prva najdena oseba z imenom ime. null, če osebe z imenom ime ni v imeniku.
     */
    public Oseba vrniOseboPoImenu(String ime) {
        for (int i = 0; i < osebe.length; i++) {
            if (ime.equalsIgnoreCase(osebe[i].getIme())) {
                return osebe[i];
            }
        }
        return null;
    }

    /**
     * Poišče in izpiše podatke oseb, katerih telefonska se začne z delnaTelefonska
     *
     * @param delnaTelefonska celotna ali začetni del telefonske številke
     */
    public void izpisiOsebePoTelefonski(String delnaTelefonska) {
        int stNajdenih = 0;
        for (int i = 0; i < osebe.length; i++) {
            if (osebe[i].getTelefon().startsWith(delnaTelefonska)) {
                stNajdenih++;
                System.out.println(osebe[i]);
            }
        }
        if (stNajdenih == 0) {
            System.out.println("Iskani telefonski številki ne ustreza nobena oseba.");
        }
    }

    /**
     * Poišče in izpiše podatke oseb, ki ustrezajo iskalnemu nizu, išče po vseh podatkih osebe.
     *
     * @param iskalniNiz iskalni niz, lahko več besed
     */
    public void izpisiIskaneOsebe(String iskalniNiz) {
        String[] besede = iskalniNiz.toLowerCase().split(" ");
        int stNajdenih = 0;
        for (int i = 0; i < osebe.length; i++) {
            String podatki = osebe[i].toString().toLowerCase();

            // Ali podatki osebe vsebujejo vse iskane besede?
            boolean ustreza = true;
            for (int j = 0; j < besede.length; j++) {
                if (!podatki.contains(besede[j])) {
                    ustreza = false;
                    break;
                }
            }

            if (ustreza) {
                stNajdenih++;
                System.out.println(osebe[i]);
            }
        }

        if (stNajdenih == 0) {
            System.out.println("Poizvedbi ne ustreza nobena oseba.");
        }
    }
}
