package Misc;

import java.util.Scanner;

public class hex_converter {
    public static void main(String[] args)
    {
        int dec_num, rem;
        StringBuilder hexdec_num= new StringBuilder();

        /* hexadecimal number digits */

        char[] hex ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        Scanner in = new Scanner(System.in);
10
        System.out.print("Input a decimal number: ");
        dec_num = in.nextInt();

        while(dec_num>0)
        {
            rem = dec_num%16;
            hexdec_num.insert(0, hex[rem]);
            dec_num = dec_num/16;
        }
        System.out.print("Hexadecimal number is : "+hexdec_num+"\n");
    }
}
