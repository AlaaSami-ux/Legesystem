// Hvite resepter
// Hvite resepter har i seg selv ingen nye egenskaper (utover et annet klassenavn). Derimot
// finnes det to subtyper av hvit resept: Militærresepter og P-resepter.
// Militaarresepter utgis til vernepliktige i tjeneste. Som en forenkling sier vi at
// militærresepter alltid gir en 100% rabatt på prisen til et legemiddel.
// P-resepter gir unge en rabatt på prevensjonsmidler. Denne rabatten er statisk og
// gjør at brukeren betaler 108 kroner mindre for legemiddelet. Merk at brukeren aldri
// kan betale mindre enn 0 kroner. I tillegg til rabatten har P-resepter den egenskapen
// at de alltid utskrives med 3 reit.

public class Hvit extends Resept{
  public Hvit(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel,utskrivendeLege,pasient,reit);
  }
  public String farge(){
    return "Hvit Resept";
  }
  public double prisAaBetale(){
    return legemiddel.hentPris();
  }
  // public String toString(){
  //   return "legemiddel er : "+ hentLegemiddel() + "\npasient Id er : " + hentPasientId() + " \nAntall ganger som er igjen paa resepten : " +  hentReit() + "\nResepts farge er : "+ farge() +  " \npris aa beatale  " + prisAaBetale()+ "\nLegens Navn : "+ utskrivendeLege;
  // }
}
