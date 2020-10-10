// P-resepter gir unge en rabatt på prevensjonsmidler. Denne rabatten er statisk og
// gjør at brukeren betaler 108 kroner mindre for legemiddelet. Merk at brukeren aldri
// kan betale mindre enn 0 kroner. I tillegg til rabatten har P-resepter den egenskapen
// at de alltid utskrives med 3 reit.

public class Presepter extends Hvit{
  public Presepter(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel,utskrivendeLege,pasient,reit);

  }
  @Override
  public double prisAaBetale(){
    if (legemiddel.hentPris() - 108 < 0){
        return 0;
    }
    return legemiddel.hentPris() - 108;
  }
}
