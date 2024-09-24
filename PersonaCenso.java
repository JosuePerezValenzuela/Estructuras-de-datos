public class PersonaCenso {
    private int id;
    private String nombre;
    private String direccion;
    
    public PersonaCenso(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public int getId() {
        return this.id;
    }
}
