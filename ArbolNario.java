public class ArbolNario<T> {
    private NodoTE<T> raiz;
    
    public static void main(String[] args) {
        ArbolNario<Integer> a = new ArbolNario();
        
        a.insertar(7, null);
        a.insertar(10, new Cola());
        a.insertar(15, new Cola());
        a.insertar(40, new Cola());
        a.insertar(50, new Cola());
        
        Cola<Integer> c1 = new Cola();
        c1.encolar(10);
        a.insertar(11, c1);
        c1.encolar(10);
        a.insertar(12, c1);
        c1.encolar(10);
        a.insertar(13, c1);
        
        
        Cola<Integer> c2 = new Cola();
        c2.encolar(40);
        a.insertar(41, c2);
        c2.encolar(40);
        a.insertar(42, c2);
        c2.encolar(40);
        a.insertar(43, c2);
        
        Lista<Integer> res = a.bfs();
        
        for (int i = 0; i < res.longitud(); i++) {
            System.out.println(res.acceder(i));
        }
    }
    
    public ArbolNario() {
        raiz = null;
    }
    
    public boolean vacio() {
        return raiz == null;
    }
    
    public void insertar(T dato, Cola<T> ruta) {
        if (vacio()) {
            this.raiz = new NodoTE(dato);
        } else {
            NodoTE<T> actual = this.raiz;
            while (!ruta.vacia()) {
                T paso = ruta.decolar();
                
                actual = actual.getHijo().buscar(paso);
            }
            
            NodoTE<T> nuevo = new NodoTE(dato);
            
            actual.agregarHijo(nuevo);
        }
    }
    
    public Lista<T> bfs() {
        Lista<T> res = new ListaSE();
        
        Cola<NodoTE<T>> c = new Cola();
        c.encolar(raiz);
        NodoTE<T> actual;
        NodoTE<T> hijo;
        
        while (!c.vacia()) {
            actual = c.decolar();
            
            res.insertar(actual.getDato());
            
            hijo = actual.getHijo();
            
            while (hijo != null) {
                c.encolar(hijo);
                hijo = hijo.getHno();
            }
        }
        
        return res;
    }
}








