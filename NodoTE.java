public class NodoTE<T> {
    private T dato;
    private NodoTE<T> padre;
    private NodoTE<T> hijo;
    private NodoTE<T> hno;
    
    public NodoTE(T dato) {
        this.dato = dato;
        padre = hijo = hno = null;
    }
    
    public void agregarHijo(NodoTE<T> nuevo) {
        if (hijo == null) {
            hijo = nuevo;
            hijo.padre = this;
        } else {
            hijo.agregarHermano(nuevo);
        }
    }
    
    public void agregarHermano(NodoTE<T> nuevo) {
        if (hno == null) {
            hno = nuevo;
            hno.padre = padre;
        } else {
            hno.agregarHermano(nuevo);
        }
    }
    
    public NodoTE<T> buscar(T dato) {
        NodoTE<T> res = null;
        
        if (this.dato == dato) {
            res = this;
        } else if (hno != null) {
            res = hno.buscar(dato);
        }
        
        return res;
    }
    
    public T getDato() {
        return dato;
    }
    
    public NodoTE<T> getPadre() {
        return padre;
    }
    
    public NodoTE<T> getHijo() {
        return hijo;
    }
    
    public NodoTE<T> getHno() {
        return hno;
    }
    
    public void setDato(T nuevoDato) {
        dato = nuevoDato;
    }
    
    public void setPadre(NodoTE<T> nuevo) {
        padre = nuevo;
    }
    
    public void setHijo(NodoTE<T> nuevo) {
        hijo = nuevo;
    }
    
    public void setHno(NodoTE<T> nuevo) {
        hno = nuevo;
    }
}










