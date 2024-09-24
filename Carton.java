public class Carton{
    private int numCarton;
    private boolean gano;
    private ArbolBB<Integer> fichas;
    private ListaSE2<Integer> fic;
    public Carton(int nC){
        numCarton = nC;
        gano = false;
        fichas = new ArbolBB();
        fic = new ListaSE2();
        generar();
    }
    //se manejaran 20 numeros por carton
    private void generar(){
        int n = (int)(Math.random()*10)+45;
        do{
            if(!fichas.buscar(n)){
                fichas.aniadir(n);
                fic.insertar(n);
            }
            n = (int)(Math.random()*99) + 1;
        }while(fichas.cantNodos() < 20);
    }
    
    public int getNumCarton(){
        return numCarton;
    }
    
    public ListaSE2<Integer> getFichas(){
        return fic;
    }
    
    public void marcar(int x){
        if(fichas.eliminar(x) != null)
            if(fichas.vacia())
                gano = true;
    }
    
    public boolean gano(){
        return gano;
    }
    
    public void reiniciar(){
        fichas = new ArbolBB();
        for(int i = 0; i < fic.longitud(); i++){
            fichas.aniadir(fic.acceder(i));
        }
        gano = false;
    }
}
