 
public class NodoDE<T>{
    private NodoDE<T> ant;
    private T dato;
    private NodoDE<T> suc;
    public NodoDE(T d){
        dato=d;
        ant=null;
        suc=null;
    }
    public NodoDE<T> getAnt(){
        return ant;
    }
    public NodoDE<T> getSuc(){
        return suc;
    }
    public T getDato(){
        return dato;
    }
    public void setDato(T d){
        dato=d;
    }
    public void setAnt(NodoDE<T> n){
        ant=n;
    }
    public void setSuc(NodoDE<T> n){
        suc=n;
    }
}
