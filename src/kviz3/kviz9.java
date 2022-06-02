package kviz3;

public class kviz9 {
    public static void main(String[] args) {
    }
    /*
    Write the method static int calculateRPN (String account),
    who receives the invoice in the inverted field record and 
    calculates its value. Only integers and operators +, -, * and / can 
    be in a given string. Individual parts of the RPN record are separated 
    by a space.
    */
    public static int izracunajRPN(String racun) {
        String[] parts = racun.split(" ");
        java.util.Stack<Integer> num = new java.util.Stack<Integer>();
        for (String part : parts) {
            int a;
            int b;
            switch (part) {
                case "+":
                    a = num.pop();
                    b = num.pop();
                    num.push(b + a);
                    break;
                case "-":
                    a = num.pop();
                    b = num.pop();
                    num.push(b - a);
                    break;
                case "*":
                    a = num.pop();
                    b = num.pop();
                    num.push(b * a);
                    break;
                case "/":
                    a = num.pop();
                    b = num.pop();
                    num.push(b / a);
                    break;
                default:
                    num.push(Integer.parseInt(part));
                    break;
            }
        }
        return num.pop();
    }

}
