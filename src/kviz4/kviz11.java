package kviz4;

public class kviz11 {
    
}
interface SkladInterface {
    public boolean isEmpty();   // je sklad prazen?
    public void push(Object o); // doda element na vrh sklada
    public Object pop();        // vrne element z vrha sklada
    public void reverse();      // obrne vrstni red elementov na skladu
}

class Sklad implements SkladInterface {
    java.util.Stack<Object> sklad = new java.util.Stack<>();

    public boolean isEmpty() {
        return sklad.isEmpty();
    }

    
    public void push(Object o) {
        sklad.push(o);
    }

    public Object pop() {
        return sklad.pop();
    }

    public void reverse() {
        sklad.sort(java.util.Collections.reverseOrder());
    }
}