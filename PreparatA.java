public class PreparatA extends Legemiddel{
  private int styrke;

  public PreparatA(String navn,String type, double pris, double virkestoff,int styrke){
    super(navn,type,pris,virkestoff);
    this.styrke = styrke;
  }
  public int hentNarkotiskStyrke(){
    return styrke;
  }
  public String toString(){
    return "RESEPT : [ ID nummer er : "+ hentId() +  ". Legemiddels navn er : " + this.navn + ". typen er : " + this.type +  ". Den koster : " + this.pris+ ". Virkestoff er : " + this.virkestoff + ". Narkotisk Styrke : " + hentNarkotiskStyrke() + " ]";
  }
}
