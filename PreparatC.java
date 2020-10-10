
public class PreparatC extends Legemiddel{
  public PreparatC(String navn,String type, double pris, double virkestoff){
    super( navn, type, pris,  virkestoff);
  }
  public String toString(){
    return "RESEPT : [ ID nummer er : "+ hentId() +  ". Legemiddels navn er : " + this.navn + ". typen er : " + this.type +". Den koster : " + this.pris+ ". Virkestoff er : " + this.virkestoff+ " ]";
  }
}
