public class Bicola<T>{
    private NodoDE<T> frente;
    private NodoDE<T> fin;
    private int longitud;
    public Bicola(){
        frente=fin=null;
        longitud = 0;
    }
    public boolean vacia(){
        return frente==null;
    }
    public void encolarFrente(T dato){
        NodoDE<T> p = new NodoDE<T>(dato);
        if(vacia()){
            frente=fin=p;
            longitud++;
        }else{
            frente.setAnt(p);
            p.setSuc(frente);
            frente = p;
            longitud++;
        }
    }
    public T decolarFrente(){
        T dato;
        if(vacia()){
            dato=null;
        }else{
            dato=frente.getDato();
            frente=frente.getSuc();
            frente.setAnt(null);
            if(frente==null){
                fin=null;
            }
            longitud--;
        }
        return dato;
    }
    public T verFrente(){
        T dato=null;
        if(!vacia()){
            dato=frente.getDato();
        }
        return dato;
    }
    public void encolarFinal(T dato){
        NodoDE<T> p = new NodoDE<T>(dato);
        if(vacia()){
            frente=fin=p;
            longitud++;
        }else{
            fin.setSuc(p);
            fin=p;
            longitud++;
        }
    }
    public T decolarFinal(){
        T dato;
        if(vacia()){
            dato=null;
        }else{
            dato=fin.getDato();
            fin=fin.getAnt();
            fin.setSuc(null);
            if(fin==null){
                frente=null;
            }
            longitud--;
        }
        return dato;
    }
    public T verFinal(){
        T dato=null;
        if(!vacia()){
            dato=fin.getDato();
        }
        return dato;
    }
    public int longitud(){
        return longitud;
    }
    public void unir(Bicola<T> o){
        while(!o.vacia()){
            encolarFinal(o.decolarFrente());
        }
    }
}