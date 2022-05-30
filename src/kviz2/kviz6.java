
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

/*
Napiši metodo double koren(int x, int d),  ki izračuna koren podanega števila na d decimal natančno. Izračun korena naj metoda opravi po naslednjem postopku:

najprej izračuna celi del korena tako, da se z zanko sprehodi od 1 do c, kjer je c prvo število, za katerega velja: c*c <= x in (c+1)*(c+1) > x;
izračuna prvo decimalko tako, da poišče število c1, ki je prvo med števili c, c+1/10, c+2/10, c+3/10, …, c+9/10, za katerega velja: c1*c1<=x, (c1+1/10)*(c1+1/10)>x;
izračuna drugo decimalko tako, da poišče število c2, ki je prvo med števili c1, c1+1/100, c1+2/100, c+3/100, …, c1+9/100, za katerega velja: c2*c2<=x, (c2+1/100)*(c2+1/100)>x;
… postopek ponavljaj toliko časa, da bo rezultat pravilen na d decimal (z drugimi besedami: metoda naj izračuna c1, c2, c3, …, cd, c(d+1) in vrne c(d+1)).
*/