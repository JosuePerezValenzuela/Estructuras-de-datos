public class ArbolBB<T extends Comparable<T>>{
    private T dato;
    private ArbolBB<T> izq, der;
    private int nodos;
    public ArbolBB(){
        dato = null;
        izq = null;
        der = null;
        nodos = 0;
    }
    public int cantNodos(){
        return nodos;
    }
    public boolean vacia(){
        return dato == null;
    }
    public void aniadir(T d){
        nodos++;
        if(vacia()){
            dato = d;
            izq = new ArbolBB();
            der = new ArbolBB();
        }else{
            if(dato.compareTo(d) > 0)
                izq.aniadir(d);
            else if(dato.compareTo(d) < 0)
                der.aniadir(d);
            else if(dato.compareTo(d) == 0) {
                // nada
            }
        }
    }
    public T getRaiz() {
        return dato;
    }
    public ArbolBB<T> getIzq() {
        return izq;
    }
    public ArbolBB<T> getDer() {
        return der;
    }
    public boolean buscar(T d){
        boolean res = false;
        if(!vacia())
            if(dato.equals(d))
                res = true;
            else{
                if(dato.compareTo(d) > 0)
                    res = izq.buscar(d);
                else
                    res = der.buscar(d);
            }
        return res;
    }
    public T eliminar(T d){
        T res = null;
        if(!vacia()){
            if(dato.equals(d)){
                nodos--;
                res = d;
                if((izq == null && der == null) || (izq.vacia() && der.vacia())){
                    dato = null;
                    izq = null;
                    der = null;
                }else if(izq == null){
                    dato = der.dato;
                    izq = der.izq;
                    der = der.der;
                }else{
                    ArbolBB<T> aux = der;                    
                    boolean cont = true;
                    while(cont){
                        if(!aux.izq.vacia())
                            aux = aux.izq;
                        else
                            cont = false;
                    }                    
                    dato = aux.dato;
                    aux.eliminar(dato);
                }
            }else{
                if(dato.compareTo(d) > 0)
                    res = izq.eliminar(d);
                else
                    res = der.eliminar(d);
            }
        }
        return res;
    }
    public ListaSE<T> recorridoAmp(){
        ListaSE<T> res = new ListaSE();
        if(!vacia()){
            Cola<ArbolBB<T>> cola = new Cola();
            cola.encolar(this);
            while(!cola.vacia()){
                ArbolBB<T> aux = cola.decolar();
                if(aux.izq != null && !aux.izq.vacia())
                    cola.encolar(aux.izq);
                if(aux.der != null && !aux.der.vacia())
                    cola.encolar(aux.der);
                res.insertar(aux.dato);
            }
        }
        return res;
    }
    public ListaSE<T> recorridoProf(){
        ListaSE<T> res = new ListaSE();
        if(!vacia()){
            Pila<ArbolBB<T>> pila = new Pila();
            pila.push(this);
            while(!pila.vacia()){
                ArbolBB<T> aux = pila.pop();
                if(aux.der != null && !aux.der.vacia())
                    pila.push(aux.der);
                if(aux.izq != null && !aux.izq.vacia())
                    pila.push(aux.izq);
                res.insertar(aux.dato);
            }
        }
        return res;
    }
    public boolean samefringe(ArbolBB<T> o){
        boolean res = true;
        Pila<T> hojasA = getHojas();
        Pila<T> hojasB = o.getHojas();
        if(hojasA.getTamanio() == hojasB.getTamanio()){
            while(!hojasA.vacia() && res)
                res = hojasA.pop().equals(hojasB.pop());
        }
        return res;
    }
    public Pila<T> getHojas(){
        return getHojas(new Pila<T>(), this);
    }
    private Pila<T> getHojas(Pila<T> p, ArbolBB<T> a){
        if(a.esHoja())
            p.push(a.dato);
        else{
            if(a.izq != null && !a.izq.vacia())
                getHojas(p, a.izq);
            if(a.der != null && !a.der.vacia())
                getHojas(p, a.der);
        }
        return p;
    }
    private boolean esHoja(){
       return izq.vacia() && der.vacia();
    }
}
