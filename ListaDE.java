public class ListaDE<T> implements Lista<T>{
    private NodoDE<T> raiz;
    private int tamanio;
    public ListaDE(){
        raiz = null;
        tamanio = 0;
    }
    public ListaDE(T dato){
        raiz = new NodoDE(dato);
        tamanio = 1;
    }
    public boolean vacia(){
        return raiz == null;
    }
    public void insertar(T dato){
        tamanio++;
        NodoDE<T> nuevo = new NodoDE(dato);
        if(vacia()){
            raiz = nuevo;
        }else{
            NodoDE<T> ult = raiz;
            while(ult.getSuc() != null){
                ult = ult.getSuc();
            }
            ult.setSuc(nuevo);
            nuevo.setAnt(ult);
        }
    }
    public T eliminar(int pos){
        T res;
        if(vacia() || pos >= tamanio)
            res = null;
        else{
            tamanio--;
            NodoDE<T> fichado = raiz;
            if(pos == 0){
                raiz = fichado.getSuc();
                raiz.setAnt(null);
            }else{
                while(pos > 0){
                    pos--;
                    fichado = fichado.getSuc();
                }
                fichado.getAnt().setSuc(fichado.getSuc());
                if(fichado.getSuc() != null)
                    fichado.getSuc().setAnt(fichado.getAnt());
            }
            res = fichado.getDato();
        }
        return res;
    }
    public T acceder(int pos){
        T res;
        if(vacia() || pos >= tamanio)
            res = null;
        else{
            NodoDE<T> nodo = raiz;
            while(pos > 0){
                pos--;
                nodo = nodo.getSuc();
            }
            res = nodo.getDato();
        }
        return res;
    }
    public int longitud(){
        return tamanio;
    }
    public NodoDE<T> buscar(T dato){
        NodoDE<T> res = null;
        if(!vacia()){
            NodoDE<T> nodo = raiz;
            boolean encontro = false;
            while(!encontro && nodo != null){
                if(nodo.getDato().equals(dato)){
                    encontro = true;
                    res = nodo;
                }else
                    nodo = nodo.getSuc();
            }
        }
        return res;
    }
    public void reemplazar(int pos, T dato){
        if(!vacia() && pos < tamanio){
            NodoDE<T> nodo = raiz;
            while(pos > 0){
                pos--;
                nodo = nodo.getSuc();
            }
            nodo.setDato(dato);
        }
    }
    public void insertar(int pos, T dato){
        if(!vacia() && pos < tamanio){
            tamanio++;
            NodoDE<T> nuevo = new NodoDE(dato);
            NodoDE<T> nodo = raiz;
            while(pos > 0){
                nodo = nodo.getSuc();
                pos--;
            }
            nuevo.setAnt(nodo.getAnt());
            nodo.getAnt().setSuc(nuevo);
            nuevo.setSuc(nodo);
            nodo.setAnt(nuevo);
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
}
