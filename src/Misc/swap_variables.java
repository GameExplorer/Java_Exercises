package Misc;

public class swap_variables {
    public static void main(String[] args) {

        int a, b, temp;
        a = 15;
        b = 27;
        System.out.println("Before swapping : a = " +a+", b = "+ b);
        temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping : a = " +a+", b = "+ b);
    }
}
