 
import org.junit.Test;
public class ListaSETest extends junit.framework.TestCase{    
    @Test
    public void testVacia(){
        ListaSE<Integer> lista;
        lista= new ListaSE<Integer>();
        assertEquals(true,lista.vacia());
    }
    @Test
    public void testInsertar(){
        ListaSE<Integer> lista;
        lista= new ListaSE<Integer>();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        lista.insertar(9);
        lista.insertar(10);
        lista.insertar(2, 7);
        assertEquals(false,lista.vacia());
        assertEquals(true, lista.longitud() == 4);
        assertEquals(true, lista.acceder(3) == 10);
        assertEquals(true, lista.acceder(2) == 7);
    }
    @Test
    public void testEliminar(){
        ListaSE<Integer> lista;
        lista= new ListaSE<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null,lista.eliminar(0));
        lista.insertar(9);
        lista.insertar(9);
        lista.insertar(9);
        assertEquals(false,lista.vacia());
        assertEquals(new Integer(9),lista.eliminar(1));
        assertEquals(new Integer(9),lista.eliminar(0));
        assertEquals(false,lista.vacia());
        assertEquals(1, lista.longitud());
    }
    @Test
    public void testAcceder(){
        ListaSE<Integer> lista;
        lista= new ListaSE<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null, lista.acceder(10));
        lista.insertar(2);
        lista.insertar(5);
        assertEquals(null,lista.acceder(2));
        assertEquals(new Integer(5),lista.acceder(1));
        assertEquals(false,lista.vacia());
    }
    @Test
    public void testReemplazar(){
        ListaSE<Integer> lista;
        lista= new ListaSE();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        lista.insertar(9);
        lista.insertar(10);
        lista.insertar(2, 7);
        lista.intercambiar(1,3);
        lista.intercambiar(1,6);
        assertEquals(true, lista.acceder(0) == 8);
        assertEquals(true,lista.acceder(1) == 10);
        assertEquals(true, lista.acceder(2) == 7);
        assertEquals(true, lista.acceder(3) == 9);
    }
    @Test
    public void testInvertir(){
        
        ListaSE<Integer> lista;
        lista= new ListaSE();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        lista.insertar(9);
        lista.insertar(10);
        lista.insertar(2, 7);
        lista.intercambiar(1,3);
        lista.intercambiar(1,6);
        lista.invertir();
        assertEquals(true, lista.acceder(3) == 8);
        assertEquals(true,lista.acceder(2) == 10);
        assertEquals(true, lista.acceder(1) == 7);
        assertEquals(true, lista.acceder(0) == 9);
    }
}
