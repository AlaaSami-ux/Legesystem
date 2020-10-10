/*A2: Skriv klassene Legemiddel, PreparatA, PreparatB og PreparatC.
De tre sistnevnte klassene arver den førstnevnte.
Konstruktøren til Legemiddel (og dermed også PreparatC)
skal ta inn String navn, double pris og double virkestoff (i den rekkefølgen).
Konstruktørene til PreparatA og PreparatB skal i tillegg ta inn int styrke.
Legemiddel skal ha metodene hentId, hentNavn, hentPris og hentVirkestoff som returnerer
de relevante verdiene.
I tillegg skal klassen ha metoden settNyPris.
PreparatA har i tillegg metoden hentNarkotiskStyrke, mens PreparatB har metoden
hentVanedannendeStyrke.*/

public abstract class Legemiddel{
  protected String navn;
  protected String type;
  protected double pris;
  protected double virkestoff;
  private int id;
  private static int teller =0;

  public Legemiddel(String navn,String type, double pris, double virkestoff){
    this.navn = navn;
    this.type = type;
    this.pris= pris;
    this.virkestoff= virkestoff;
    id = teller;
    teller++;
  }
  public int hentId(){
  return id;
  }
  public String hentNavn(){
    return navn;
  }
  public String hentType(){
    return type;
  }
  public double hentPris(){
    return pris;
  }
  public double hentVirkestoff(){
    return virkestoff;
  }
  public void settNyPris(double nyPris){
    this.pris = nyPris;
  }
}
