package kviz2;

public class kviz3 {
    public static void main(String[] args) {

    }

    public static int [] range (int a, int b, int c) {
        java.util.ArrayList<Integer> range = new java.util.ArrayList<Integer>();
        int x = 0;
        while(a + x * c < b) {
            range.add(a + x * c);
            x++;
        }

        int[] range2 = new int[range.size()];
        for (int i = 0; i < range.size(); i++) {
            range2[i] = range.get(i);
        }

        return range2;
    }
}
