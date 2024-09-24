public class NodoSE<T>{
    private T dato;
    private NodoSE<T> suc;
    public NodoSE(T d){
        dato=d;
        suc=null;
    }
    public void setSuc(NodoSE<T> s){
        suc=s;
    }
    public void setDato(T d){
        dato=d;
    }
    public NodoSE<T> getSuc(){
        return suc;
    }
    public T getDato(){
        return dato;
    }   
}