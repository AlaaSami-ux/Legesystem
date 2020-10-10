public class PreparatB extends Legemiddel{
  private int styrke;
  public PreparatB(String navn,String type, double pris, double virkestoff,int styrke){
    super(navn,type,pris,virkestoff);
    this.styrke = styrke;
  }
  public int hentVanedannendeStyrke(){
    return styrke;
  }

  public String toString(){
    return "RESEPT :[ ID nummer er : "+ hentId() +  ". Legemiddels navn er : " + this.navn + ". typen er : " + this.type +". Den koster : " + this.pris+ ". Virkestoff er : " + this.virkestoff + ". Vanedannende Styrke : " + hentVanedannendeStyrke() + " ]";
  }
}
