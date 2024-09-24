import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ArbolBinTest{
    @Test
    public void testSameFringe(){
        ArbolBin<Integer> a = new ArbolBin();
        a.insertar(5);
        a.insertar(1);
        a.insertar(4);
        a.insertar(10);
        a.insertar(2);
        a.insertar(11);
        a.insertar(3);
        a.eliminar(10);
        a.eliminar(11);
        
        ArbolBin<Integer> b = new ArbolBin();
        b.insertar(5);
        b.insertar(7);
        b.insertar(3);
        b.insertar(1);
        b.insertar(10);
        b.insertar(2);
        b.insertar(11);
        b.eliminar(10);
        b.eliminar(11);
        
        assertEquals(true, a.samefringe(b));
        
        ArbolBin<Integer> c = new ArbolBin();
        c.insertar(5);
        c.insertar(7);
        c.insertar(3);
        c.insertar(1);
        c.insertar(10);
        c.insertar(4);
        c.insertar(11);
        c.eliminar(10);
        c.eliminar(11);
        
        assertEquals(false, a.samefringe(c));
        
        ArbolBin<Integer> d = new ArbolBin();
        d.insertar(5);
        d.insertar(7);
        d.insertar(1);
        d.insertar(2);
        d.insertar(10);
        d.insertar(3);
        d.insertar(11);
        d.eliminar(10);
        d.eliminar(11);
        
        assertEquals(false, a.samefringe(d));        
        
        ArbolBin<Integer> e = new ArbolBin();
        e.insertar(5);
        e.insertar(2);
        e.insertar(4);
        e.insertar(10);
        e.insertar(3);
        e.insertar(11);
        e.insertar(1);
        e.eliminar(10);
        e.eliminar(11);
        
        assertEquals(true, e.samefringe(d));  
    }
}
