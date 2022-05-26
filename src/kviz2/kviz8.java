package kviz2;

public class kviz8 {
    public static void main(String[] arga){

    }
    /*Write the method int sum of Common Digits (int a, int b), which calculates the sum of all digits 
    that appear simultaneously in the number a and b. If any of the digits appears more than once, count it only once in the sum.*/

    public static int vsotaSkupnihCifer(int a, int b) {
        int vsota = 0;
        String stavekA = Integer.toString(a);
        String stavekB = Integer.toString(b);
        java.util.HashSet<Integer> upostevana = new java.util.HashSet<>();

        

        for (int i = 0; i < stavekA.length(); i++) {
            for (int j = 0; j < stavekB.length(); j++) {
                int trenutenA = Character.getNumericValue(stavekA.charAt(i));;
                int trenutenB = Character.getNumericValue(stavekB.charAt(j));;
                if (trenutenA == trenutenB && !upostevana.contains(trenutenA)) {
                    vsota += trenutenA;
                    upostevana.add(trenutenA);
                }
            }
        }
        return vsota;

    }
}
