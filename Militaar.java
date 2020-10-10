//  Militærresepter utgis til vernepliktige i tjeneste. Som en forenkling sier vi at
// militærresepter alltid gir en 100% rabatt på prisen til et legemiddel.

public class Militaar extends Hvit{
  public Militaar(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel,utskrivendeLege,pasient,reit);

  }
  @Override
  public double prisAaBetale(){
    return 0;
  }

}
