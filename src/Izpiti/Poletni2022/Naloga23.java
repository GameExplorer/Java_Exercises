package Izpiti.Poletni2022;

public class Naloga23 {
    class Matrika {
        private int m;
        private int n;
        private int[][] vrednosti;

        public Matrika(int m, int n) {
            this.m = m;
            this.n = n;
            vrednosti = new int[m][n];
        }

        public Matrika(int[][] matrika) {
            this.m = matrika.length;
            this.n = matrika[0].length;
            vrednosti = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    vrednosti[i][j] = matrika[i][j];
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(String.format("Matrika %d x %d:\n", m, n));
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(String.format("%2d ", vrednosti[i][j]));
                }
                sb.append("\n");
            }
            return sb.toString();
        }

        public void pomnozi(int skalar) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    vrednosti[i][j] *= skalar;
                }
            }
        }

        public static Matrika vsota(Matrika matrika1, Matrika matrika2) {
            if (matrika1.m != matrika2.m || matrika1.n != matrika2.n)
                return null;
            Matrika rez = new Matrika(matrika1.m, matrika1.n);
            for (int i = 0; i < matrika1.m; i++) {
                for (int j = 0; j < matrika1.n; j++) {
                    rez.vrednosti[i][j] = matrika1.vrednosti[i][j] + matrika2.vrednosti[i][j];
                }
            }
            return rez;
        }
    }
    public class Naloga23 {
        public static void main(String[] args) {
            Matrika m1 = new Matrika(new int[][]{{1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}, {10, 11, 12, 13, 14}});
            Matrika m2 = new Matrika(new int[][]{{7, 8, 10, 1, 1}, {1, 1, 1, 1, 0}, {0, 1, 1, 1, 5}});
            Matrika m3 = new Matrika(new int[][]{{0, 1, 1}, {1, 1, 1}, {0, 1, 1}});
            System.out.println(m1);
            System.out.println(m2);
            System.out.println(m3);

            m1.pomnozi(3);
            System.out.println(m1);
            Matrika vsota = Matrika.vsota(m1, m2);
            System.out.println(vsota);
            vsota = Matrika.vsota(m1, m3);
            System.out.println(vsota);
        }
    }
}
