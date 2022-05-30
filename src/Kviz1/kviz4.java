package Kviz1;

/*
Napiši metodo void krog(double r, int d), ki izračuna in izpiše obseg in 
ploščino kroga na d decimalk natančno. Če je r negativen, naj metoda 
izpiše Napaka: negativen polmer. Če je d negativen, naj izpiše Napaka: 
negativen d.
*/

public class kviz4 {
    public static void main(String[] args) {
        krog(20, 14);
    }
    static void krog(double r, int d){
        if(r < 0 ){
            System.out.println("Napaka: negativen polmer");
        }
        else if (d < 0 ){
            System.out.println("Napaka: negativen d");
        }
        else{
            System.out.printf("Obseg kroga s polmerom r=%.2f je %." + d + "f\n", r, 2*Math.PI*r);
            System.out.printf("Ploscina kroga s polmerom r=%.2f je %." + d + "f\n", r, Math.PI*r*r);
        }
    }
    
}
