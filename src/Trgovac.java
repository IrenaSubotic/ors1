import java.util.TreeMap;

public class Trgovac {
	private int ID_trgovac;
	private String korisnicko_ime;
	private String ime;
	private String prezime;
	private String lozinka;
	private String pol;
	private String telefon;
	private String email;
	private Prodajno_mjesto prodajnoMjesto;
private static TreeMap<Integer,Trgovac> spisakTrgovaca=new TreeMap<>();
	
	public Trgovac(int ID,String korisnicko_ime,String ime,String prezime, String lozinka,String pol,String telefon,String email, int prodajnoMjestoID){
		this.ID_trgovac= ID;
		this.korisnicko_ime=korisnicko_ime;
		this.ime=ime;
		this.prezime=prezime;
		this.lozinka=lozinka;
		this.telefon=telefon;
		this.pol=pol;
		this.email=email;
		this.prodajnoMjesto=Prodajno_mjesto.getProdajnoMjesto(prodajnoMjestoID);
         boolean prisutan=false;
         for(Trgovac t: spisakTrgovaca.values()){
        	 if(t.jednakiTrgovci(this)){
        		 prisutan=true;
        		 break;
        	 }
        		 
         }
         if(prisutan==false)
        	 spisakTrgovaca.put(ID_trgovac,this);
	
		
}
	
public boolean jednakiTrgovci(Trgovac trgovac2){
		 return (this.korisnicko_ime.equals(trgovac2.korisnicko_ime));
	 }	


public String getKorisnickoIme(){
	return this.korisnicko_ime;
}
public String getIme(){
	return this.ime;
}
public String getPrezime(){
	return this.prezime;
}
public String getLozinka(){
	return this.lozinka;
}

public String getPol(){
	return this.pol;
}
public String getTelefon(){
	return this.telefon;
}
public String getEmail(){
	return this.email;
}
public Prodajno_mjesto getProdajnoMjesto(){
	return prodajnoMjesto;
}
public int getID(){
	return this.ID_trgovac;
}
public static TreeMap<Integer,Trgovac> getSpisakTrgovaca(){
	return spisakTrgovaca;
}


public static  Trgovac getTrgovac(int ID){
	Trgovac trazeni=null;
	for(Integer id : spisakTrgovaca.keySet()){
		if(id==ID){
			trazeni=spisakTrgovaca.get(id);
		}
	}
	return trazeni;
}
/*public static TreeMap<Integer, Narudzba> getNarudzbeTrgovca(Trgovac t){
	TreeMap<Integer,Narudzba> narudzbeTrgovca=new TreeMap<>();
	for(Narudzba n: Narudzba.getSpisakNarudzbi().values()){
		if(n.getTrgovac().jednakiTrgovci(t)){
			narudzbeTrgovca.put(n.getID(),n);
		}
	}
	return narudzbeTrgovca;
}*/
public static boolean ispravnoKorisnickoIliEmail(String unos ){
for(Trgovac t: spisakTrgovaca.values()){
	if(t.korisnicko_ime.equals(unos)){
		return true;
	}
}
for(Trgovac t: spisakTrgovaca.values()){
	if(t.email.equals(unos)){
		return true;
	}
}
return false;
}

public static boolean ispravnaLozinka(String s, String l) {
	
	for(Trgovac t: spisakTrgovaca.values()) {
		if(t.korisnicko_ime.equals(s) && t.lozinka.equals(l)) {
			return true;
		}
	}
	
	return false;
}

public static Trgovac pronadjiTrgovca(String korisnickoIme){
	Trgovac trazeni=null;
	for(Trgovac t: spisakTrgovaca.values()){
		if(t.korisnicko_ime.equals(korisnickoIme)){
			trazeni=t;
			break;
		}
	}
	return trazeni;
}


public boolean daLiJeTrgovacUOvojDrzavi(String drzava) {
	if(this.prodajnoMjesto.equals(drzava)) {
		return true;
	}
	else
		return false;
}


public static TreeMap<Integer,Narudzba> getNarudzbeTrgovca(Trgovac t){
	
	TreeMap<Integer,Narudzba> sveNarudzbe=Narudzba.getSpisakNarudzbi();
	TreeMap<Integer,Narudzba> narudzbeTrgovca=new TreeMap<>();
	
	for(Narudzba n: sveNarudzbe.values()) {
		if(n.getTrgovac()==null)
			break;
		else if(n.getTrgovac().ID_trgovac==t.ID_trgovac)
			narudzbeTrgovca.put(n.getID(), n);
	}
	
	return narudzbeTrgovca;	
}
public static TreeMap<Integer,Narudzba> getPrihvaceneNarudzbeTrgovca(Trgovac t){
	
	TreeMap<Integer,Narudzba> sveNarudzbe=Narudzba.getSpisakNarudzbi();
	TreeMap<Integer,Narudzba> narudzbeTrgovca=new TreeMap<>();
	
	for(Narudzba n: sveNarudzbe.values()) {
		if(n.getTrgovac()==null)
			break;
		else if(n.getTrgovac().ID_trgovac==t.ID_trgovac && n.getDatumIsporuke()!=null)
			narudzbeTrgovca.put(n.getID(), n);
	}
	
	return narudzbeTrgovca;	
}




public static int getPosljednjiID() {
	
	TreeMap<Integer,Trgovac> tr=Trgovac.getSpisakTrgovaca();
	int zadnji=tr.get(tr.size()-1).getID()+1;
	return zadnji;
}
}
