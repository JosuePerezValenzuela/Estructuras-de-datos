public class ListaSE<T> implements Lista<T>{
    private T raiz;
    private ListaSE<T> sig;
    private int tamanio;
    public ListaSE(){
        tamanio = 0;
        raiz = null;
        sig = null;
    }
    public ListaSE(T dato){
        tamanio = 1;
        raiz = dato;
        sig = new ListaSE();
    }
    public boolean vacia(){
        return raiz == null;
    }
    public void insertar(T dato){
        tamanio++;
        if(vacia()){
            raiz = dato;
            sig = new ListaSE();
        }else{
            sig.insertar(dato);
        }
    }
    public T eliminar(int pos){
        T res;
        if(vacia())
            res = null;
        else{
            if(pos < tamanio){
                tamanio--;
                if(pos == 0){
                    res = raiz;
                    raiz = sig.raiz;
                    sig = sig.sig;
                }else{
                    res = sig.eliminar(pos-1);
                }
            }else
                res = null;
        }
        return res;
    }
    public T acceder(int pos){
        T res;
        if(vacia())
            res = null;
        else{
            if(pos < tamanio){
                if(pos == 0){
                    res = raiz;
                }else{
                    res = sig.acceder(pos-1);
                }
            }else
                res = null;
        }
        return res;
    }
    public int longitud(){
        return tamanio;
    }
    public T buscar(T dato){
        T res;
        if(vacia())
            res = null;
        else{
            if(dato.equals(raiz)){
                res = raiz;
            }else
                res = sig.buscar(dato);
        }
        return res;
    }
    public void reemplazar(int pos, T dato){
        if(!vacia()){
            if(pos < tamanio)
                if(pos == 0){
                    raiz = dato;
                }else{
                    sig.reemplazar(pos-1, dato);
                }
        }
    }
    public void insertar(int pos, T dato){
        if(!vacia()){
            if(pos <= tamanio){
                tamanio++;
                if(pos == 0){
                    T raizAux = raiz;
                    ListaSE aux = sig;
                    raiz = dato;
                    sig = new ListaSE();
                    sig.insertar(raizAux);
                    sig.sig = aux;
                }else{
                    sig.insertar(pos-1, dato);
                }
            }
        }
    }
    public void intercambiar(int pos1, int pos2){
        if(pos1 < tamanio && pos2 < tamanio){
            T dato1 = acceder(pos1);
            T dato2 = acceder(pos2);
            reemplazar(pos1, dato2);
            reemplazar(pos2, dato1);
        }
    }
    public void invertir(){
        if(!vacia()){
            if(!sig.vacia()){
                sig.invertir();
                sig.insertar(raiz);
                raiz = sig.raiz;
                sig = sig.sig;
            }else{
                sig.insertar(raiz);
                raiz = sig.raiz;
                sig = sig.sig;
            }
        }
    }
}