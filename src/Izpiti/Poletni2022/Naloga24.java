package Izpiti.Poletni2022;

import java.awt.Color;

public class Naloga24 {

    class Sonce {

        int x;
        int y;
        int r;
        int n;

        public Sonce(int x, int y, int r, int n) {
            this.r = r;
            this.x = x;
            this.y = y;
            this.n = n;
        }

        public void narisi() {
            StdDraw.setPenColor(Color.yellow);

            StdDraw.circle(x, y, r);
            for (int i = 0; i < n; i++) {
                double x1 = x + r * Math.sin(2 * Math.PI * i / n);
                double x2 = x + 2 * r * Math.sin(2 * Math.PI * i / n);
                double y1 = y + r * Math.cos(2 * Math.PI * i / n);
                double y2 = y + 2 * r * Math.cos(2 * Math.PI * i / n);
                StdDraw.line(x1, y1, x2, y2);

                x1 = x + 1.3 * r * Math.sin(2 * Math.PI * (i + 0.5) / n);
                x2 = x + 2.3 * r * Math.sin(2 * Math.PI * (i + 0.5) / n);
                y1 = y + 1.3 * r * Math.cos(2 * Math.PI * (i + 0.5) / n);
                y2 = y + 2.3 * r * Math.cos(2 * Math.PI * (i + 0.5) / n);
                StdDraw.line(x1, y1, x2, y2);
            }
        }

    }
    public class Naloga24 {

        public static void main(String[] args) {
            StdDraw.setScale(-100, 100);
            StdDraw.setPenRadius(0.01);
            Sonce s = new Sonce(0, 0, 30, 10);
            s.narisi();
        }
    }
}
