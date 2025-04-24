
import java.util.TreeMap;

public class Kupac {
private int ID_kupac;
private String korisnicko_ime;
private String ime;
private String prezime;
private String lozinka;
private String telefon;
private String adresa ;
private String grad;
private String drzava;
private String postanski_broj;
private String pol;
private String email;


private static TreeMap<Integer, Kupac> kupci=new TreeMap<>();

///
public Kupac(int ID_kupac,String korisnicko_ime,String ime,String prezime, String lozinka, String telefon, String adresa,String grad,String drzava,String postanski_broj,String pol,String email){
	this.ID_kupac=ID_kupac;
	this.korisnicko_ime=korisnicko_ime;
	this.ime=ime;
	this.prezime=prezime;
	this.lozinka=lozinka;
	this.telefon=telefon;
	this.adresa=adresa;
	this.grad=grad;
	this.drzava=drzava;
	this.postanski_broj=postanski_broj;
	this.pol=pol;
	this.email=email;	
	
	boolean prisutan=false;
	for(Integer id: kupci.keySet()){
		if(id==this.ID_kupac &&  kupci.get(id).korisnicko_ime.equals(korisnicko_ime)){
			prisutan =true;
		}
	}
	if(prisutan==false)
		kupci.put(this.ID_kupac,this);
}




///
public String getKorisnickoIme(){
	return this.korisnicko_ime;
}
public String getIme(){
	return this.ime;
}
public String getPrezime(){
	return this.prezime;
}
public String getTelefon(){
	return this.telefon;
}
public String getLozinka(){
	return this.lozinka;
}

public String getAdresa(){
	return this.adresa;
}
public String getGrad(){
	return this.grad;
}

public String getDrzava(){
	return this.drzava;
}
public String getPol(){
	return this.pol;
}
public String getEmail(){
	return this.email;
}
public String getPostanskiBroj(){
	return this.postanski_broj;
}
public int getID(){
	return ID_kupac;
}
public static TreeMap<Integer,Kupac> getKupci(){
	return kupci;
}



///
 public boolean jednakiKupci(Kupac kupac2){
	 return (this.korisnicko_ime.equals(kupac2.korisnicko_ime) );
 }
 
 public static Kupac getKupac(int ID){
	 Kupac trazeni=null;
	 for(Integer id: kupci.keySet()){
		 if(id==ID){
			 trazeni=kupci.get(id);
		 }
	 }
	 return trazeni;
 }
 
 
 
 public TreeMap<Integer,Narudzba> getSpisakNarudzbiKupca(){
	 TreeMap<Integer,Narudzba> spisakNarudzbiKupca=new TreeMap<>();
	 for(Narudzba n: Narudzba.getSpisakNarudzbi().values()){
		if(n.getKupac().jednakiKupci(this)){
			 spisakNarudzbiKupca.put(n.getID(),n);
			 
		 }
	 }
	 return spisakNarudzbiKupca;
 }

public TreeMap<Integer,Narudzba> getSpisakNarudzbiCijaSeIsporukaCeka(){
	TreeMap<Integer,Narudzba> narudzbeNaCekanju=new TreeMap<>();
	 TreeMap<Integer,Narudzba> narudzbeKupca=getSpisakNarudzbiKupca();
	 for(Narudzba n: narudzbeKupca.values()){
		 if(n.getDatumIsporuke()==null){
			 narudzbeNaCekanju.put(n.getID(),n);
		 }
	 }
	 return narudzbeNaCekanju;
	 
}

public int brojNarudzbiNaCekanju(){
	int br=0;
	 TreeMap<Integer,Narudzba> narudzbeKupca=getSpisakNarudzbiKupca();
	 for(Narudzba n: narudzbeKupca.values()){
		 if(n.getDatumIsporuke()==null){
			 br++;
		 }
	 }
	 return br;
}

public int getBrojObavljenihNarudzbi(){
	int broj=0;
	TreeMap<Integer,Narudzba> sveNarudzbeKupca=getSpisakNarudzbiKupca();
	for(Narudzba n: sveNarudzbeKupca.values()){
		if( n.getDatumIsporuke()!=null){
			broj++;
		}
	}
	return broj;
}

public static boolean ispravnoKorisnickoIliEmail(String unos ){
for(Kupac k: kupci.values()){
	if(k.korisnicko_ime.equals(unos)){
		return true;
	}
}
for(Kupac k: kupci.values()){
	if(k.email.equals(unos)){
		return true;
	}
}
return false;
}

public static boolean ispravnaLozinka(String s, String l) {
	
	for(Kupac k: kupci.values()) {
		if(k.korisnicko_ime.equals(s) && k.lozinka.equals(l)) {
			return true;
		}
	}
	
	return false;
}

public static  Kupac pronadjiKupca(String korisnickoIme){
	Kupac trazeni=null;
	for(Kupac k: kupci.values()){
		if(k.korisnicko_ime.equals(korisnickoIme)){
			trazeni=k;
			break;
		}
	}
	return trazeni;
}


 public float getVrijednostNarudzbiNaCekanju(){
	 float vrijednostt=0;
	 TreeMap<Integer,Narudzba> narudzbeNaCekanju=getSpisakNarudzbiCijaSeIsporukaCeka();
	 for(Narudzba n: narudzbeNaCekanju.values()){
		 vrijednostt+=n.getVrijednostNarudzbe();
		 
	 }
	 return vrijednostt;
 }
 public static TreeMap<Integer,Narudzba> getPrihvaceneNarudzbeKupca(Kupac t){
		
		TreeMap<Integer,Narudzba> sveNarudzbe=Narudzba.getSpisakNarudzbi();
		TreeMap<Integer,Narudzba> narudzbeKupca=new TreeMap<>();
		
		for(Narudzba n: sveNarudzbe.values()) {
			if(n.getKupac().ID_kupac==t.ID_kupac && n.getDatumIsporuke()!=null)
				narudzbeKupca.put(n.getID(), n);
		}
		
		return narudzbeKupca;	
	}

 
 

 
 
 
 
 
 
 
 
 
 
 @Override
	public String toString() {
	 String res="";
	 res+="\nKorisnicko ime  "+this.korisnicko_ime;
	 res+="\nIme  "+this.ime;
	 res+="\nPrezime   "+this.prezime;
	 res+="\nLozinka   "+this.lozinka;
	 res+="\nAdresa   "+this.adresa;
	 res+="\nDrzava    "+this.drzava;
			 return res;
 }
}
