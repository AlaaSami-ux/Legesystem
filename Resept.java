// En Resept har en ID. I tillegg skal en resept ha en referanse til et legemiddel, en referanse til
// den legen som har skrevet ut resepten, og ID-en til den pasienten som eier resepten. En
// resept har et antall ganger som er igjen på resepten (kalles reit). Hvis antall ganger igjen er
// 0, er resepten ugyldig.
// B2: Skriv klassen Resept og dens subklasser. Konstruktøren i Resept skal ta inn et
// Legemiddel legemiddel, en Lege utskrivendeLege, en int pasientId og int reit (i den
// rekkefølgen). Merk: Vi skal ikke kunne opprette en instans av selve klassen Resept, kun
// av subtypene.
// Klassen Resept skal ha følgende metoder som henter relevant data: hentId, hentLegemiddel
// (henter tilhørende Legemiddel), hentLege (henter utskrivende Lege), hentPasientId og
// hentReit

public abstract class Resept{
  protected int id;
  protected static int teller=0;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected Pasient pasient;
  protected int reit;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasient = pasient;
    this.reit = reit;
    id = teller;
    teller++;
  }


  public Legemiddel hentLegemiddel(){
    return legemiddel;
  }
  public Lege hentLege(){
    return utskrivendeLege;
  }
  public Pasient hentPasient(){
    return pasient;
  }
  public int hentReit(){
    return reit;
  }
  public int hentId(){
    return id;
  }

//   I tillegg skal klassen ha faalgende metoder:
//  public boolean bruk: Forsaaker aa bruke resepten en gang. Returner false om resepten
// alt er oppbrukt, ellers returnerer den true.
//  abstract public String farge: Returnerer reseptens farge. Enten hvit  eller "blaa".
//  abstract public double prisAaBetale: Returnerer prisen pasienten maa betale.

  public boolean bruk(){
    if (reit == 0){
      return false;
    }else{
      reit--;
    }
    return true;
  }
  
  abstract public String farge();
  abstract public double prisAaBetale();
@Override
  public String toString(){
    return "Reseptens ID Nummer : " + hentId() + "\nlegemiddel er : "+ hentLegemiddel() + "\nPASIENT : " + hentPasient() + " \nAntall ganger som er igjen paa resepten : " +  hentReit() + "\nResepts farge er : "+ farge() +  " \nPris aa beatale  " + prisAaBetale()+ "\nLegens Navn : "+ utskrivendeLege;
  }
}
