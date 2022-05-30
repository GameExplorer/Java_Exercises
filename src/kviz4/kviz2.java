package kviz4;

public class kviz2 {
    public static void main(String[] args) {
        poisciInIzpisiBarve("kviz4/assets/style.css");
    }
    static void poisciInIzpisiBarve(String imeDatoteke) {
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File(imeDatoteke));
            while (scanner.hasNext()) {
                String beseda = scanner.next();
                if (beseda.equalsIgnoreCase("color:")) {
                    String barva = scanner.next().replace(";", "");
                    if (!barva.matches("^#([A-Fa-f0-9]{6})$")) {
                        continue;
                    }
                    // RGB
                    int r = Integer.parseInt(barva.substring(1, 3), 16);
                    int g = Integer.parseInt(barva.substring(3, 5), 16);
                    int b = Integer.parseInt(barva.substring(5, 7), 16);

                    // HSL
                    float R = r / 255f;
                    float G = g / 255f;
                    float B = b / 255f;
                    float M = Math.max(R, Math.max(G, B));
                    float m = Math.min(R, Math.min(G, B));
                    float C = M - m;
                    // Hue
                    float h = 0;
                    if (C == 0) {
                        h = 0;
                    } else if (M == R) {
                        h = (G - B) / C;
                    } else if (M == G) {
                        h = (B - R) / C + 2f;
                    } else if (M == B) {
                        h = (R - G) / C + 4f;
                    }
                    h = 60f * h;
                    if (h < 0) {
                        h += 360f;
                    }
                    // Luminance
                    float l = (M + m) * 0.5f;
                    // Saturation
                    float s = 0;
                    if (l == 1) {
                        s = 0;
                    } else {
                        s = C / (1f - Math.abs(2f * l - 1f));
                    }
                    System.out.printf("%s -> rgb(%d, %d, %d) -> hsl(%d, %d, %d)",
                            barva, r, g, b, Math.round(h), Math.round(s * 100f), Math.round(l * 100f));
                    System.out.println();
                }
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
    V podani html ali css datoteki poišči vse pojavitve šestnajstiškega zapisa barve in izpiši pripadajoče RGB in HSL vrednosti.  Natančneje: metoda



        poisciInIzpisiBarve(String imeDatoteke),



        naj v datoteki imeDatoteke poišče vse zapise oblike color: #rrggbb; in za vsakega izpiše eno vrstico oblike:



        #rrggbb -> rgb(r, g, b)  -> hsl(h, s, l)



        Pri tem upoštevaj naslednje: v šestnajstiškem zapisu #rrggbb so rr , gg in bb dvomestna šestnajstiška števila, ki predstavljajo količino rdeče, zelene in modre komponente barve. Komponente zapisa rgb(r, g, b) imajo podoben pomen, le da so števila zapisana desetiško. Komponente zapisa hsl(h, s, l) pa so definirane z naslednjimi formulami:





        (opomba: vrednost števila H predstavlja kot in mora biti v intervalu [0,360]; v primeru, da formula vrne negativni kot, ga je treba povečati za 360).





        Primer: ob klicu poisciInIzpisiBarve("style.css") naj program izpiše:





        #242729 -> rgb(36, 39, 41) -> hsl(204, 6, 15)
        #C31818 -> rgb(195, 24, 24) -> hsl(0, 78, 43)
        #961212 -> rgb(150, 18, 18) -> hsl(0, 79, 33)
        #680d0d -> rgb(104, 13, 13) -> hsl(0, 78, 23)

 */