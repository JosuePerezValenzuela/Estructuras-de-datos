 
import org.junit.Test;
public class ListaSE2Test extends junit.framework.TestCase{
    @Test
    public void testVacia(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
        assertEquals(true,lista.vacia());
    }
    @Test
    public void testInsertar(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        lista.insertar(1, 7);
        assertEquals(false,lista.vacia());
        assertEquals(1, lista.longitud());
    }
    @Test
    public void testEliminar(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
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
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null, lista.acceder(10));
        lista.insertar(2);
        lista.insertar(5);
        assertEquals(null,lista.acceder(2));
        assertEquals(new Integer(5),lista.acceder(1));
        assertEquals(false,lista.vacia());
    }
    @Test
    public void testVacia2(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
        assertEquals(true,lista.vacia());
    }
    @Test
    public void testInsertar2(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        lista.insertar(9);
        lista.insertar(10);
        lista.insertar(2, 7);
        assertEquals(false,lista.vacia());
        assertEquals(true, lista.longitud() == 4);
        assertEquals(true, lista.acceder(2) == 7);
        assertEquals(true, lista.acceder(1) == 9);
        assertEquals(true, lista.acceder(10) == null);
        assertEquals(true, lista.buscar(10) == 10);
        assertEquals(true, lista.buscar(9) == 9);
        assertEquals(true, lista.buscar(-1) == null);
    }
    @Test
    public void testEliminar2(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null,lista.eliminar(0));
        lista.insertar(9);
        lista.insertar(9);
        lista.insertar(9);
        assertEquals(false,lista.vacia());
        assertEquals(new Integer(9),lista.eliminar(1));
        assertEquals(new Integer(9),lista.eliminar(0));
        assertEquals(null, lista.eliminar(1));
        assertEquals(null, lista.eliminar(5));
        assertEquals(false,lista.vacia());
        assertEquals(1, lista.longitud());
    }
    @Test
    public void testAcceder2(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null, lista.acceder(10));
        lista.insertar(2);
        lista.insertar(5);
        assertEquals(null,lista.acceder(2));
        assertEquals(new Integer(5),lista.acceder(1));
        assertEquals(false,lista.vacia());
    }
    @Test
    public void testReemplazar2(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        lista.insertar(9);
        lista.insertar(10);
        lista.reemplazar(0,6);
        lista.reemplazar(3,9);
        lista.insertar(2, 7);
        lista.intercambiar(1,3);
        assertEquals(true, lista.acceder(0) == 6);
        assertEquals(true,lista.acceder(1) == 10);
        assertEquals(true, lista.acceder(2) == 7);
        assertEquals(true, lista.acceder(3) == 9);
    }
    @Test
    public void testInvertir(){
        ListaSE2<Integer> lista;
        lista= new ListaSE2();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        lista.insertar(9);
        lista.insertar(10);
        lista.reemplazar(0,6);
        lista.reemplazar(3,9);
        lista.insertar(2, 7);
        lista.intercambiar(1,3);
        lista.invertir();
        assertEquals(true, lista.acceder(3) == 6);
        assertEquals(true,lista.acceder(2) == 10);
        assertEquals(true, lista.acceder(1) == 7);
        assertEquals(true, lista.acceder(0) == 9);
    }
}
