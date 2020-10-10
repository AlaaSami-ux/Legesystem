public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

  // D1: Skriv klassen SortertLenkeliste<T extends Comparable<T> >. Denne listen arver også
  // fra Lenkeliste<T>, men vi ønsker at listen skal være sortert og krever derfor at elementer
  // som settes inn skal være sammenlignbare. Kall på leggTil(T x) skal altså sette inn elementer
  // i sortert rekkefølge (fra minst til størst), og når vi bruker fjern()-metoden (uten parametere)
  // skal det største elementet tas ut.

  @Override
  public void leggTil(T x){
    Node ny = new Node (x);
    Node p = start;
    // vi sjekker hvis listen er tom
    if (start == null ){
      start = ny;
      ant++;
      return;
    }
    // eller hvis listen ikke er tom
    for (int i = 0 ; i < stoerrelse(); i++){
      if (hent(i).compareTo(x) > 0){
        super.leggTil(null);
        for(int j = stoerrelse()-2; j >= i; j--){
          super.sett(j+1,hent(j));
        }
        super.sett(i,x);
        return;
      }
    }
    super.leggTil(x);
  }

  @Override
  public T fjern()throws UgyldigListeIndeks{
      if (stoerrelse()==0){
        throw new UgyldigListeIndeks(-1);
      }
    T innhold = start.data;
     if(stoerrelse() == 1){
      start = null;
      ant--;
      // System.out.println(" : " + inhold);
      return innhold;
    }
    else{
      innhold = super.fjern(stoerrelse()-1);
      // System.out.println(" siste element  " + inhold);
      return innhold;
    }
  }
  @Override
  public void sett(int pos, T x){
      throw new UnsupportedOperationException();
    }

  @Override
  public void leggTil(int pos, T x){
    throw new UnsupportedOperationException();
    }
  }
