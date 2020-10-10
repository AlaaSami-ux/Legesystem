public class Pasient{
  protected  int id;
  protected static int teller = 0;
  protected String navn;
  protected String faadselsnummer;
  protected Stabel<Resept> resept = new Stabel<Resept>();

  public Pasient(String navn, String faadselsnummer){
    this.navn = navn;
    this.faadselsnummer = faadselsnummer;
    id = teller;
    teller++;
  }
  public String hentNavn(){
    return navn;
  }
  public String hentFaadselsnummer(){
    return faadselsnummer;
  }
  public int hentId(){
    return id;
  }
  public void leggTilResept(Resept x){
   resept.leggPaa(x);
  }
  public int lengden(){
    return resept.stoerrelse();
  }
  public Stabel<Resept> hentResept(){
    return resept;
  }
  public String toString(){
    return "Pasientens navn : "+ this.navn +  ". Faadselsnummer :  " + this.faadselsnummer + ". Pasient ID er  : " + hentId();
  }
}
 // + " lengde " + lengden()
