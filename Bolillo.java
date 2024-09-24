public class Bolillo implements Comparable<Bolillo>{
    private int num;
    private ListaSE2<Carton> cartones;
    public Bolillo(int n){
        num = n;
        cartones = new ListaSE2();
    }
    public int getNum(){
        return num;
    }
    public int compareTo(Bolillo o){
        return ((Integer)(num)).compareTo(o.num);
    }
}
