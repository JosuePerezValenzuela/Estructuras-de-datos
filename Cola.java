public class Cola<T>{
    private NodoSE<T> frente;
    private NodoSE<T> fin;
    private int longitud;
    public Cola(){
        frente=fin=null;
        longitud = 0;
    }
    public boolean vacia(){
        return frente==null;
    }
    public void encolar(T dato){
        NodoSE<T> p = new NodoSE<T>(dato);
        if(vacia()){
            frente=fin=p;
            longitud++;
        }else{
            fin.setSuc(p);
            fin=p;
            longitud++;
        }
    }
    public T  decolar(){
        T dato;
        if(vacia()){
            dato=null;
        }else{
            dato=frente.getDato();
            frente=frente.getSuc();
            if(frente==null){
                fin=null;
            }
            longitud--;
        }
        return dato;
    }
    public T ver(){
        T dato=null;
        if(!vacia()){
            dato=frente.getDato();
        }
        return dato;
    }
    public int longitud(){
        return longitud;
    }
}