import java.util.TreeMap;

public class Narudzba {
	private int ID_narudzba;
	private Kupac kupac;
	private Trgovac trgovac;
	private String datum_narudzbe;
	private String datum_isporuke;
	private String napomena;
	private   static TreeMap<Integer,Narudzba> spisakNarudzbi=new TreeMap<>(); 
	
	public Narudzba(int ID_narudzba,int kupac_id, int trgovac_id, String datum_narudzbe,String datum_isporuke,String napomena){
		this.ID_narudzba=ID_narudzba;
		this.kupac=Kupac.getKupac(kupac_id);
		this.trgovac=Trgovac.getTrgovac(trgovac_id);
 this.datum_narudzbe=datum_narudzbe;
 this.datum_isporuke=datum_isporuke;
 this.napomena=napomena;
 spisakNarudzbi.put(ID_narudzba,this);
}
	public static TreeMap<Integer,Narudzba> getSpisakNarudzbi(){
		return spisakNarudzbi;
	}
	public int getID(){
		return this.ID_narudzba;
	}
public Kupac getKupac(){
	return kupac;
}
public Trgovac getTrgovac(){
	return trgovac;
}
public String getDatumIsporuke(){
	return this.datum_isporuke;
}
public String getDatumNarudzbe(){
	return this.datum_narudzbe;
}
public String getNapomena(){
	return napomena;
}

public static  Narudzba getNarudzba(int ID){
	Narudzba trazena=null;
	for(Integer id : spisakNarudzbi.keySet()){
		if(id==ID){
			trazena=spisakNarudzbi.get(id);
		}
	}
	return trazena;
}
public void setDatumIsporuke(String datumIsporuke){
	this.datum_isporuke=datumIsporuke;
}
public void setTrgovac(Trgovac t){
	this.trgovac=t;
}
public float getVrijednostNarudzbe() {
	
	float vrijednost=0;
	
	for(Artikal_narudzbe an: Artikal_narudzbe.getArtikliNarudzbe().values()){
		if(this.ID_narudzba==an.getNarudzba().getID()){
			vrijednost+=an.getKolicina()*an.getCijenaPoKomadu();}}
	
	return vrijednost;
}


public static TreeMap<Integer,Narudzba> getNeprihvaceneNarudzbe(){
	TreeMap<Integer,Narudzba> neprihvacene=new TreeMap<>();
	for(Narudzba n: spisakNarudzbi.values()){
		if(n.getDatumIsporuke()==null){
			neprihvacene.put(n.ID_narudzba, n);
		}
	}
	return neprihvacene;
}
public static TreeMap<Integer,Narudzba> getPrihvaceneNarudzbe(){
	TreeMap<Integer,Narudzba> prihvacene=new TreeMap<>();
	for(Narudzba n: spisakNarudzbi.values()){
		if(n.getDatumIsporuke()!=null){
			prihvacene.put(n.ID_narudzba, n);
		}
	}
	return prihvacene;
}

public TreeMap<Integer,Artikal_narudzbe> getArtikliNarudzbe(){
	TreeMap<Integer,Artikal_narudzbe> trazeno=new TreeMap<>();
	for(Artikal_narudzbe ana: Artikal_narudzbe.getArtikliNarudzbe().values()){
		if(ana.getNarudzba().getID()==ID_narudzba){
			trazeno.put(ana.getID(), ana);
		}
	}
	return trazeno;
}



}