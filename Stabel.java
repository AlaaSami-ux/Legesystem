import java.util.Iterator;
public class Stabel<T> extends Lenkeliste<T>{
  public void leggPaa(T x){
    super.leggTil(x);
  }
  public T taAv(){
    return fjern(stoerrelse()-1);
  }
}
