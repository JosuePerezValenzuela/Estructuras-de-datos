public class FueraIntervalo {
    public static void main(String[] args) {
        ArbolBB<Integer> a = new ArbolBB();
        
        a.aniadir(20);
        a.aniadir(10);
        a.aniadir(60);
        a.aniadir(3);
        a.aniadir(15);
        a.aniadir(35);
        a.aniadir(70);
        a.aniadir(9);
        a.aniadir(12);
        a.aniadir(19);
        a.aniadir(25);
        a.aniadir(40);
        a.aniadir(72);
        a.aniadir(7);
        a.aniadir(14);
        a.aniadir(21);
        a.aniadir(50);
        
        FueraIntervalo f = new FueraIntervalo();
        
        Lista res = f.fueraIntervalo(a, 4, 25);
        System.out.println(res);
    }
    
    public Lista<Integer> fueraIntervalo(ArbolBB<Integer> arbol, int x, int y) {
        ListaSE<Integer> res = new ListaSE();
        elementosMenores(arbol, x, res);
        elementosMayores(arbol, y, res);
        
        return res;
    }
    
    private void elementosMenores(ArbolBB<Integer> a, int lim, Lista<Integer> res) {
        if (!a.vacia()) {
            if (a.getRaiz() < lim) {
                elementosMenores(a.getIzq(), lim, res);
                res.insertar(a.getRaiz());
                elementosMenores(a.getDer(), lim, res);
            } else {
                elementosMenores(a.getIzq(), lim, res);
            }
        }
    }
    
    private void elementosMayores(ArbolBB<Integer> a, int lim, Lista<Integer> res) {
        if (!a.vacia()) {
            if (a.getRaiz() > lim) {
                elementosMayores(a.getIzq(), lim, res);
                res.insertar(a.getRaiz());
                elementosMayores(a.getDer(), lim, res);
            } else {
                elementosMayores(a.getDer(), lim, res);
            }
        }
    }
}
