import java.util.TreeMap;

public class Proizvod {
private int ID_proizvod;
private String naziv;
private	String opis;
private float cijena;
private static TreeMap<Integer,Proizvod> spisakProizvoda=new TreeMap<>();

	public Proizvod(int ID_proizvod,String naziv,String opis,float cijena){
		this.ID_proizvod=ID_proizvod;
		this.naziv=naziv;
		this.opis=opis;
		this.cijena=cijena;
		boolean prisutan=false;
		for(Integer id: spisakProizvoda.keySet()){
			if(id==ID_proizvod){
				prisutan=true;
			}
		}
		if(prisutan==false)
			spisakProizvoda.put(ID_proizvod, this);
	}
	public int getID(){
		return this.ID_proizvod;
	}
	public String getNaziv(){
		return this.naziv;
	}
public float getCijena(){
	return this.cijena;
}
public String getOpis(){
	return this.opis;
}
public static TreeMap<Integer,Proizvod> getProizvodi(){
	return spisakProizvoda;
}

public static Proizvod getProizvod(int ID){
	Proizvod trazeni=null;
	for(Integer id: spisakProizvoda.keySet()){
		if(id==ID){
			trazeni=spisakProizvoda.get(id);
		}
	}
	return trazeni;
}
public void setNaziv(String naziv) {
	this.naziv=naziv;
}

public void setCijena(float cijena) {
	this.cijena=cijena;
}

public void setOpis(String opis) {
	this.opis=opis;
}



}
