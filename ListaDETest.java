

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaDETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaDETest
{
    @Test
    public void testVacia(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        assertEquals(true,lista.vacia());
    }
    @Test
    public void testInsertar(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        assertEquals(true,lista.vacia());
        lista.insertar(8);
        assertEquals(false,lista.vacia());
    }
    @Test
    public void testEliminar(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null,lista.eliminar(0));
        lista.insertar(9);
        for(int i = 0;  i < 9; i++){
            lista.insertar((int)(Math.random()*10));
        }
        assertEquals(false,lista.vacia());
        assertEquals(null,lista.eliminar(11));
        assertEquals(new Integer(9),lista.eliminar(0));
        assertEquals(false,lista.vacia());
        assertEquals(9, lista.longitud());
        for(int i = 0;  i < 8; i++){
            lista.eliminar((int)(Math.random()*lista.longitud()));
        }
        assertEquals(1, lista.longitud());
    }
    @Test
    public void testAcceder(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null, lista.acceder(10));
        lista.insertar(2);
        lista.insertar(5);
        assertEquals(null,lista.acceder(2));
        assertEquals(new Integer(5),lista.acceder(1));
        assertEquals(false,lista.vacia());
    }
    @Test
    public void testBuscar(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        assertEquals(true,lista.vacia());
        assertEquals(null, lista.buscar(10));
        lista.insertar(2);
        lista.insertar(5);
        assertEquals(new Integer(2),lista.buscar(2));
        assertEquals(new Integer(5),lista.buscar(5));
        assertEquals(false,lista.vacia());
    }
    /*@Test
    public void testRecorrer(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.recorrer(-6);
        assertEquals(new Integer(2), lista.acceder(0));
        lista.recorrer(6);
        assertEquals(new Integer(5), lista.acceder(0));
        lista.recorrer(-11);
        assertEquals(new Integer(2), lista.acceder(0));
        lista.recorrer(11);
        assertEquals(new Integer(5), lista.acceder(0));
    }*/
    @Test
    public void testReemplazar(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.reemplazar(2, new Integer (7));
        assertEquals(new Integer (7), lista.acceder(2));
    }
    @Test
    public void testInsertarPos(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.insertar(2, new Integer (7));
        assertEquals(new Integer (7), lista.acceder(2));
        assertEquals(6, lista.longitud());
    }
    @Test
    public void testIntercambiar(){
        ListaDE<Integer> lista;
        lista= new ListaDE<Integer>();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.intercambiar(1, 4);
        assertEquals(new Integer (5), lista.acceder(1));
        assertEquals(new Integer (2), lista.acceder(4));
    }
}
