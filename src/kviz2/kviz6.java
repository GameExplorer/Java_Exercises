package kviz2;

public class kviz6 {
    public static void main(String[] args) {
        koren(4, 2);
    }
    public static double koren(int x, int d) {
        double[] decimal = new double[d + 1];
        decimal[0] = 1;
        
        
        
        for(int i = 1; i <= d; i++) {
            int j = 0;
            while ((decimal[i] + 1 / Math.pow(10, i)) * (decimal[i] + 1 / Math.pow(10, i)) <= x) {
                decimal[i] = decimal[i - 1] + j / Math.pow(10, i);
                j++;
            }
        }

        return decimal[decimal.length - 1];
    }
}
