public class ArbolBin<T>{
    private ArbolBin<T> izq;
    private T raiz;
    private ArbolBin<T> der;
    private boolean tocaIzq;
    private int nodos;
    public ArbolBin(){
       raiz=null;
       izq=der=null;
       tocaIzq=true;
       nodos = 0;
    }
    public boolean vacia(){
       return raiz==null;
    }
    public int getNodos(){
        return nodos;
    }
    public T getRaiz() {
        return raiz;
    }
    public ArbolBin<T> getIzq(){
        return izq;
    }
    public ArbolBin<T> getDer(){
        return der;
    }
    public void insertar(T dato){
        if(vacia()){
            raiz=dato;
            izq=new ArbolBin<T>();
            der=new ArbolBin<T>();
            tocaIzq=true;
            nodos++;
        }else{
            if(tocaIzq){
                izq.insertar(dato);
                nodos++;
            }else{
                der.insertar(dato);
                nodos++;
            }
            tocaIzq=!tocaIzq;
        }
    }
    public T eliminar(T dato){
       T datoElim;
       if(vacia()){
           datoElim=null;
       }else{
           if(raiz.equals(dato)){
               /*if(esHoja()){
                   datoElim=raiz;
                   raiz=null;
                   izq=der=null;
               }else{
                   datoElim=null;
               }*/
               if(izq != null){
                   izq.eliminar(izq.raiz);
               }
               if(der != null){
                   der.eliminar(der.raiz);
               }
               datoElim=raiz;
               raiz=null;
               izq=der=null;
               nodos--;
           }else{
               datoElim= izq.eliminar(dato);
               if(datoElim==null){
                   datoElim=der.eliminar(dato);
               }
           }
       }
       return datoElim;
    }
    public T acceder(T dato){
       T datoAcc=null;
       if(!vacia()){
           if(raiz.equals(dato)){
               datoAcc=raiz;
           }else{
               datoAcc=izq.acceder(dato);
               if(datoAcc==null){
                   datoAcc=der.acceder(dato);
               }
           }
       }
       return datoAcc;
    }
    public ListaSE<T> recorridoAmp(){
        ListaSE<T> res = new ListaSE();
        if(!vacia()){
            Cola<ArbolBin<T>> cola = new Cola();
            cola.encolar(this);
            while(!cola.vacia()){
                ArbolBin<T> aux = cola.decolar();
                if(aux.izq != null && !aux.izq.vacia())
                    cola.encolar(aux.izq);
                if(aux.der != null && !aux.der.vacia())
                    cola.encolar(aux.der);
                res.insertar(aux.raiz);
            }
        }  
        return res;
    }
    public ListaSE<T> recorridoProf(){
        ListaSE<T> res = new ListaSE();
        if(!vacia()){
            Pila<ArbolBin<T>> pila = new Pila();
            pila.push(this);
            while(!pila.vacia()){
                ArbolBin<T> aux = pila.pop();
                if(aux.der != null && !aux.der.vacia())
                    pila.push(aux.der);
                if(aux.izq != null && !aux.izq.vacia())
                    pila.push(aux.izq);
                res.insertar(aux.raiz);
            }
        }    
        return res;
    }
    public boolean samefringe(ArbolBin<T> o){
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
    private Pila<T> getHojas(Pila<T> p, ArbolBin<T> a){
        if(a.esHoja())
            p.push(a.raiz);
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
