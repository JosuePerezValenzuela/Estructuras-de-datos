import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ArbolBBTest{
    @Test
    public void test1(){
        ArbolBB<Integer> a = new ArbolBB();
        a.aniadir(40);
        a.aniadir(30);
        a.aniadir(20);
        a.aniadir(35);
        a.aniadir(31);
        a.aniadir(36);
        a.aniadir(50);
        a.aniadir(45);
        a.aniadir(60);
        ListaSE<Integer> l = a.recorridoAmp();
        for(int i = 0; i < l.longitud(); i++)
            System.out.print(l.acceder(i) + " ");
        System.out.println();
        l = a.recorridoProf();
        for(int i = 0; i < l.longitud(); i++)
            System.out.print(l.acceder(i) + " ");
        System.out.println();
            
        a.eliminar(30);
        l = a.recorridoAmp();
        for(int i = 0; i < l.longitud(); i++)
            System.out.print(l.acceder(i) + " ");
        System.out.println();
        l = a.recorridoProf();
        for(int i = 0; i < l.longitud(); i++)
            System.out.print(l.acceder(i) + " ");
        System.out.println();
        
        a.eliminar(40);
        l = a.recorridoAmp();
        for(int i = 0; i < l.longitud(); i++)
            System.out.print(l.acceder(i) + " ");
        System.out.println();
        l = a.recorridoProf();
        for(int i = 0; i < l.longitud(); i++)
            System.out.print(l.acceder(i) + " ");
        System.out.println();
    }
    @Test
    public void testSame(){
        ArbolBB<Integer> a = new ArbolBB();
        a.aniadir(40);
        a.aniadir(30);
        a.aniadir(20);
        a.aniadir(35);
        a.aniadir(31);
        a.aniadir(36);
        a.aniadir(50);
        a.aniadir(45);
        a.aniadir(60);
        
        ArbolBB<Integer> b = new ArbolBB();
        b.aniadir(40);
        b.aniadir(30);
        b.aniadir(20);
        b.aniadir(35);
        b.aniadir(31);
        b.aniadir(36);
        b.aniadir(50);
        b.aniadir(45);
        b.aniadir(60);
        
        assertEquals(true, a.samefringe(b));
        
        ArbolBB<Integer> c = new ArbolBB();
        c.aniadir(35);
        c.aniadir(30);
        c.aniadir(20);
        c.aniadir(33);
        c.aniadir(31);
        c.aniadir(36);
        c.aniadir(50);
        c.aniadir(45);
        c.aniadir(60);
        
        assertEquals(true, c.samefringe(b));
        
        ArbolBB<Integer> d = new ArbolBB();
        d.aniadir(40);
        d.aniadir(25);
        d.aniadir(10);
        d.aniadir(23);
        d.aniadir(20);
        d.aniadir(35);
        d.aniadir(31);
        d.aniadir(47);
        d.aniadir(41);
        d.aniadir(46);
        d.aniadir(45);
        d.aniadir(50);
        d.aniadir(60);
        
        assertEquals(true, c.samefringe(d));
        
        ArbolBB<Integer> e = new ArbolBB();
        e.aniadir(35);
        e.aniadir(30);
        e.aniadir(20);
        e.aniadir(33);
        e.aniadir(32);
        e.aniadir(36);
        e.aniadir(50);
        e.aniadir(45);
        e.aniadir(60);
        
        assertEquals(false, e.samefringe(d));
    }
}
