import java.util.TreeMap;

public class Artikal_narudzbe {
	private int ID_artikalNarudzbe;
	private Narudzba narudzba;
	private Proizvod proizvod;
	private int kolicina;
	private float cijena_po_komadu;
	private static TreeMap<Integer,Artikal_narudzbe> artikliNarudzbe=new TreeMap<>();
	
public Artikal_narudzbe(int narudzba_id, int proizvod_id,int kolicina,float cijena ,int ID_artikalNarudzbe){
	this.ID_artikalNarudzbe=ID_artikalNarudzbe;
	this.narudzba=Narudzba.getNarudzba(narudzba_id);
	this.proizvod=Proizvod.getProizvod(proizvod_id);
	this.kolicina=kolicina;
	this.cijena_po_komadu=cijena;
	artikliNarudzbe.put(ID_artikalNarudzbe,this);
}
public int getID(){
	return ID_artikalNarudzbe;
}
public Narudzba getNarudzba(){
	return narudzba;
}
public Proizvod getProizvod(){
	return proizvod;
}
public int getKolicina(){
	return kolicina;
}
public float getCijenaPoKomadu(){
	return cijena_po_komadu;
}

public static TreeMap<Integer,Artikal_narudzbe> getArtikliNarudzbe(){
	return artikliNarudzbe;
}
}
