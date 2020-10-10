// Blå resepter
// Det er stor forskjell på vanlige (hvite) og blå resepter (blant annet er utstedelsen av en blå
// resept forbundet med en del kontroller), men igjen skal vi gjøre en forenkling og si at bare
// prisen som betales er forskjellig: Blå resepter er alltid sterkt subsidiert, og for enkelhets skyld
// sier vi her at de har 75% rabatt slik at pasienten må betale 25% av prisen på legemidlet.

public class Blaa extends Resept{
  public Blaa(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel,utskrivendeLege,pasient,reit);
  }
  public String farge(){
    return "Blaa Resept";
  }
  public double prisAaBetale(){
    return legemiddel.hentPris() * 0.25;
  }

  // public String toString(){
  //   return "legemiddel er : "+ hentLegemiddel() + "\npasient Id er : " + hentPasientId() + " \nantall ganger som er igjen paa resepten : " +  hentReit() + "\nResepts farge er : "+ farge() +  " \npris aa beatale  " + prisAaBetale()+ "\nLegens Navn : "+ utskrivendeLege;
  // }
}
