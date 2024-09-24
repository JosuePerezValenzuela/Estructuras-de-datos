public class Censo {
    public static void main(String[] args) {
        ArbolBin<PersonaCenso> a = new ArbolBin();
        
        PersonaCenso p1 = new PersonaCenso(12, "Luis", "Av. Rivas");
        PersonaCenso p2 = new PersonaCenso(10, "Mario", "Av. JJ");
        PersonaCenso p3 = new PersonaCenso(3, "Juana", "Av. Arco");
        PersonaCenso p4 = new PersonaCenso(2, "Coni", "Av. Ansando");
        PersonaCenso p5 = new PersonaCenso(12, "Luismi", "Av. Rivas");
        PersonaCenso p6 = new PersonaCenso(1, "Pedro", "Av. Santos");
        PersonaCenso p7 = new PersonaCenso(8, "Ana", "Av. Montes");
        PersonaCenso p8 = new PersonaCenso(7, "Mia", "Av. Corrientes");
        PersonaCenso p9 = new PersonaCenso(6, "Dani", "Av. Sexta");
        PersonaCenso p10 = new PersonaCenso(6, "Carlos", "Av. Conti");
        PersonaCenso p11 = new PersonaCenso(20, "Carmen", "Av. Heroes");
        PersonaCenso p12 = new PersonaCenso(12, "Jose", "Av. Perez");
        PersonaCenso p13 = new PersonaCenso(6, "Carlo", "Av. Conti");
        PersonaCenso p14 = new PersonaCenso(3, "Moira", "Av. Casas");
        PersonaCenso p15 = new PersonaCenso(1, "Bartolome", "Av. Dos");
        PersonaCenso p16 = new PersonaCenso(7, "Keny", "Av. Primera");
        
        a.insertar(p1);
        a.insertar(p2);
        a.insertar(p3);
        a.insertar(p4);
        a.getIzq().getDer().insertar(p5);
        a.getDer().getDer().insertar(p6);
        a.getIzq().getDer().insertar(p7);
        a.getIzq().getDer().insertar(p8);
        a.getDer().getDer().getDer().insertar(p9);
        a.getIzq().getDer().getIzq().insertar(p10);
        a.getIzq().getDer().getDer().insertar(p11);
        a.getIzq().getDer().getDer().insertar(p12);
        a.getIzq().getDer().getIzq().getIzq().insertar(p13);
        a.getIzq().getDer().getDer().getIzq().insertar(p14);
        a.getIzq().getDer().getDer().getDer().insertar(p15);
        a.getIzq().getDer().getDer().getDer().insertar(p16);
        
        Censo c = new Censo();
        
        Lista<PersonaCenso> res = c.identificarImpostores(a);
        System.out.println(res);
    }
    
    public Lista<PersonaCenso> identificarImpostores(ArbolBin<PersonaCenso> poblacion) {
        ListaSE<PersonaCenso> impostores = new ListaSE();
        Cola<ArbolBin<PersonaCenso>> cola = new Cola();
        cola.encolar(poblacion);
        
        ArbolBin<PersonaCenso> actual;
        
        while (!cola.vacia()) {
            actual = cola.decolar();
            if (!actual.vacia() && esImpostor(actual.getRaiz(), poblacion)) {
                impostores.insertar(actual.getRaiz());
            }
            
            if (!actual.getIzq().vacia()) {
                cola.encolar(actual.getIzq());
            }
            if (!actual.getDer().vacia()) {
                cola.encolar(actual.getDer());
            }
        }
        
        return impostores;
    }
    
    private boolean esImpostor(PersonaCenso p, ArbolBin<PersonaCenso> poblacion) {
        boolean res = true;
        
        Cola<ArbolBin<PersonaCenso>> cola = new Cola();
        cola.encolar(poblacion);
        
        ArbolBin<PersonaCenso> actual;
        
        while (!cola.vacia() && res) {
            actual = cola.decolar();
            
            if (actual.getRaiz() == p) {
                res = false;
            } else if (!actual.vacia()) {
                if (actual.getRaiz().getId() == p.getId()) {
                    res = true;
                    cola = new Cola();
                } else {
                    if (!actual.getIzq().vacia()) {
                        cola.encolar(actual.getIzq());
                    }
                    if (!actual.getDer().vacia()) {
                        cola.encolar(actual.getDer());
                    }
                }
            }
        }
        
        return res;
    }
}
