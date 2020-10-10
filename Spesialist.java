public class Spesialist extends Lege implements Godkjenningsfritak{
  protected int kontrollID;
  public Spesialist(String navn,int kontrollID){
    super(navn);
    this.kontrollID = kontrollID;

  }
  public int hentKontrollID(){
    return kontrollID;
  }

  // @Override
  // public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) {
  //   return new Militaar(legemiddel,this, pasient, reit);
  // }
  @Override
  public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit){
    Resept nyResept = new Hvit(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
    }

  @Override
  public Resept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) {
    Resept nyResept = new Hvit(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  @Override
  public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit){
    Resept nyResept = new Blaa(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  @Override
  public Resept skrivMillitaarResept(Legemiddel legemiddel, Pasient pasient, int reit){
    Resept nyResept = new Militaar(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  @Override
  public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit){
    Resept nyResept = new Presepter(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  @Override
  public String toString(){
    return navn + ".  Kontroll ID er : " + kontrollID;
  }
}
