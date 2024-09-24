public class ListaSE2<T> implements Lista<T>{
    private NodoSE<T> raiz;
    private int tamanio;
    public ListaSE2(){
        raiz = null;
        tamanio = 0;
    }
    public ListaSE2(T dato){
        raiz = new NodoSE(dato);
        tamanio = 1;
    }
    public boolean vacia(){
        return raiz == null;
    }
    public void insertar(T dato){
        tamanio++;
        if(vacia()){
            raiz = new NodoSE(dato);
        }else{
            NodoSE ant = raiz;
            NodoSE ult = raiz.getSuc();
            while(ult != null){
                ant = ult;
                ult = ult.getSuc();
            }
            ult = new NodoSE(dato);
            ant.setSuc(ult);
        }
    }
    public T eliminar(int pos){
        T res;
        if(vacia() || pos >= tamanio)
            res = null;
        else{
            tamanio--;
            res = raiz.getDato();
            NodoSE<T> ant = raiz;
            NodoSE<T> act = raiz.getSuc();
            if(pos > 0){
                while(pos > 0){
                    pos--;
                    ant = act;
                    act = act.getSuc();
                }
                ant.setSuc(act.getSuc());
            }else{
                res = ant.getDato();
                raiz = act;
            }
        }
        return res;
    }
    public T acceder(int pos){
        T res;
        if(vacia() || pos >= tamanio){
            res = null;
        }else{
            NodoSE<T> aux = raiz;
            do{
                res = aux.getDato();
                aux = aux.getSuc();
                pos--;
            }while(pos >= 0);
        }
        return res;
    }
    public int longitud(){
        return tamanio;
    }
    public T buscar(T dato){
        T res = null;
        if(!vacia()){
            NodoSE<T> aux = raiz;
            boolean encontro = false;
            do{
                res = aux.getDato();
                if(res.equals(dato))
                    encontro = true;
                else
                    res = null;
                aux = aux.getSuc();
            }while(!encontro && aux != null);
        }
        return res;
    }
    public void reemplazar(int pos, T dato){
        if(!vacia() && pos < tamanio){
            NodoSE<T> aux = raiz;
            while(pos > 0){
                aux = aux.getSuc();
                pos--;
            }
            aux.setDato(dato);
        }
    }
    public void insertar(int pos, T dato){
        if(!vacia() && pos < tamanio){
            tamanio++;
            NodoSE<T> aux = raiz;
            while(pos > 0){
                aux = aux.getSuc();
                pos--;
            }
            NodoSE<T> suc = new NodoSE<T>(aux.getDato());
            suc.setSuc(aux.getSuc());
            aux.setDato(dato);
            aux.setSuc(suc);
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
        invertir(0, tamanio-1);
    }
    private void invertir(int i, int j){
        if(i < j){
            intercambiar(i, j);
            invertir(i+1, j-1);
        }
    }
}