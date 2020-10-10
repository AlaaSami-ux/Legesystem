// Konstruktøren i Lege tar kun inn en String med legens navn. Lege skal ha en metode for å
// hente ut et navn og skrive ut en resept.

public class Lege implements Comparable<Lege>{
  protected String navn;
  protected Lenkeliste<Resept> utskrevedeResepter;

  public Lege(String navn){
    this.navn = navn;
    this.utskrevedeResepter = new Lenkeliste<Resept>();
  }

  public String hentNavn(){
    return navn;
  }
/*Modifiser skrivResept() slik at den tar inn et Pasient objekt i stedet for en pasientid, og
når en resept opprettes, legges den til i utskrevedeResepter i legeobjektet som skriver den
ut, og i pasientens stabel av resepter.*/

  @Override
  public int compareTo(Lege x){
    return navn.compareTo(x.hentNavn());

  }

  public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    if ( legemiddel instanceof PreparatA){
      throw new UlovligUtskrift( this,  legemiddel);
    }

    Resept nyResept = new Hvit(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
    }

// (Frivillig) Erstatt skrivResept() med metodene skrivHvitResept(), skrivBlaaResept(),
// skrivMillitærResept(), og skrivPResept() som tar inn de relevante parameterene, og skriver
// ut en resept av riktig type på samme måte som skrivResept()
  public Resept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    if ( legemiddel instanceof PreparatA){
      throw new UlovligUtskrift( this,  legemiddel);
    }
    Resept nyResept = new Hvit(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }


  public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    if ( legemiddel instanceof PreparatA){
      throw new UlovligUtskrift( this,  legemiddel);
    }
    Resept nyResept = new Blaa(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }


  public Resept skrivMillitaarResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    if ( legemiddel instanceof PreparatA){
      throw new UlovligUtskrift( this,  legemiddel);
    }
    Resept nyResept = new Militaar(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }


  public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    if ( legemiddel instanceof PreparatA){
      throw new UlovligUtskrift( this,  legemiddel);
    }
    Resept nyResept = new Presepter(legemiddel,this, pasient, reit);
    utskrevedeResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }


  @Override
  public String toString(){
    return navn;
  }
}
