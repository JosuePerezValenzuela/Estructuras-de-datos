import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class PilaTest{
    @Test
    public void testPila(){
        Pila<Integer> pila= new Pila<Integer>();
        assertEquals(true,pila.vacia());
        pila.push(2);
        pila.push(7);
        pila.push(5);
        pila.push(3);
        pila.push(10);
        assertEquals(new Integer(10),pila.pop());
        assertEquals(new Integer(3),pila.peek());
        assertEquals(new Integer(3),pila.pop());
        assertEquals(new Integer(5),pila.pop());
        assertEquals(new Integer(7),pila.pop());
        assertEquals(new Integer(2),pila.pop());
        assertEquals(true,pila.vacia());
    }
}
