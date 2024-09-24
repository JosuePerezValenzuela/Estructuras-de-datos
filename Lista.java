public interface Lista<T>{
    public boolean vacia();
    public void insertar(T dato);
    public T eliminar(int pos);
    public T acceder(int pos);
    public int longitud();
    public void reemplazar(int pos, T dato);
    public void insertar(int pos, T dato);
    public void intercambiar(int pos1, int pos2);
}
