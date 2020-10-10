import java.util.Iterator;
 public class Lenkeliste<T> implements Liste<T>{
  public Node start;
  int ant = 0;
  // public Lenkeliste(){
  //   start = new Node(null);
  // }

   class Node{
    T data;
    Node neste;
    public Node(T data){
      this.data = data;
      //neste = new Node(null);
    }
  }
  public int stoerrelse(){
    return ant;
  }
  public void leggTil(T x){
// vi sjekker hvis listen er tom
    Node ny = new Node (x);
    Node p = start;
    if (start == null ){
      start = ny;
      ant++;
    }
// eller hvis listen ikke er tom
    else{
      while(p.neste != null){
        p = p.neste;
      }
      //System.out.println("nytt element "+ p.data);
      p.neste = ny;
      //System.out.println("nytt element "+ p.data);
      ant++;
    }
  }

  public T fjern()throws UgyldigListeIndeks{
      if (stoerrelse()==0){
        throw new UgyldigListeIndeks(-1);
      }
    Node slettedeelement = new Node(start.data);
     if(stoerrelse() == 1){
      start = null;
      ant--;
      System.out.println("slettedeelement "+ slettedeelement.data);
      return slettedeelement.data;
    }else{
      start = start.neste;
      ant--;
        System.out.println("slettedeelement "+ slettedeelement.data);
      return slettedeelement.data;
    }
  }
// Metoden sett(int pos, T x) skal sette inn elementet på en gitt posisjon og overskrive
// det som var der fra før av.
  public void sett(int pos, T x)throws UgyldigListeIndeks{
    Node ny = new Node(x);
    Node p = start;
  if (stoerrelse() == 0 || pos < 0 || pos >= stoerrelse()){
    throw new UgyldigListeIndeks(pos);
  }
    for(int i = 0; i<pos; i++){
      p=p.neste;
    }
    p.data=ny.data;
    //System.out.println("ny data er :  "+ p.data);
  }
  //Metoden leggTil(int pos, T x) skal legge inn et nytt element i listen og skyve neste
  //element ett hakk lenger bak.
  public void leggTil(int pos, T x)throws UgyldigListeIndeks{
    Node ny = new Node(x);
    Node p = start;
    if (pos < 0 || pos > stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    if(start == null){
      start = ny;
      ant++;
      return;
    }
    if(pos == 0){
      ny.neste = start;
      start = ny;
      ant++;
      return;
    }
    for(int i = 1; i < pos; i++){
      p = p.neste;
    }
    ny.neste = p.neste;
    p.neste = ny;
    ant ++;
  }
  // Metoden fjern(int pos) skal fjerne på gitt indeks i listen.
  public T fjern(int pos)throws UgyldigListeIndeks{
    Node p = start;
    Node fl= new Node(null);
    if (stoerrelse() == 0 || pos < 0 || pos >= stoerrelse()){
      throw new UgyldigListeIndeks(pos);}
    //stoerrelse() == 1 &&
    else if( pos ==0 && stoerrelse()==1){
      start = null;
      ant--;
    //  System.out.println("str == 1 funk "+ fl.data);
      return p.data;
    }
    for(int i = 0; i < stoerrelse(); i++){
      if (i == pos -1){
        fl=p.neste;
        if(p.neste.neste == null){
          p.neste = null;
          ant--;
          return fl.data;
        }else{
          p.neste= p.neste.neste;
          ant--;
        }
      }
      else{
        p = p.neste;
      }
    }
    return fl.data;
  }
  public T hent(int pos)throws UgyldigListeIndeks{
    Node p = start;
    if(stoerrelse() == 0){
      throw new UgyldigListeIndeks(-1);
    }
  if (pos < 0 || pos >= stoerrelse()){
    throw new UgyldigListeIndeks(pos);
  }
    for(int i = 0; i < pos; i++){
      if(p.neste != null){
        p=p.neste;
        }
      }
      //System.out.println(p);
    //System.out.println("ønskede element: "+ p.data);
    return p.data;
  }
  void skrivall(){
    Node p = start;
    while (p!= null){
      System.out.println(p.data);
      System.out.println();
    p=  p.neste;
    }
  }
  public Iterator<T> iterator(){
    return new LenkelisteIterator();
  }
    class LenkelisteIterator implements Iterator<T> {
    public Node gjeldendeIndeks;
    public LenkelisteIterator(){
      gjeldendeIndeks = start;

    }
    @Override
    public T next() {
      Node tmp = gjeldendeIndeks;
      gjeldendeIndeks = gjeldendeIndeks.neste;
      return tmp.data;
    }
    @Override
    public boolean hasNext() {
      return gjeldendeIndeks != null;
    }
  }
  // public String toString(){
  //   // System.out.println("------------------");
  //   for(T data : this){
  //     System.out.println(data);
  //   }
  //   return"";
  // }
}
