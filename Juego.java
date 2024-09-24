public class Juego{
    private ListaSE2<Carton> cartones;
    private ArbolBB<Bolillo> bolillos;
    public Juego(int cantCartones, int cantFichas){
        cartones = new ListaSE2();
        for(int i = 0; i < cantCartones; i++)
            cartones.insertar(new Carton(i+1000));
        
        bolillos = new ArbolBB();
        controlBolillos(50);
    }
    private void controlBolillos(int x){
        Bolillo n = new Bolillo(x);
        if(x > 0 && x < 100){
            if(!bolillos.buscar(n))
                bolillos.aniadir(n);
            controlBolillos(x-x/2);
            controlBolillos(x+x/2);
        }
    }
}
