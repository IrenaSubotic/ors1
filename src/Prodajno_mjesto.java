import java.util.TreeMap;

public class Prodajno_mjesto {
private int ID_prodajnoMjesto;
private String grad;
private String drzava;
private String adresa;
private String telefon;
private static  TreeMap<Integer,Prodajno_mjesto> spisakProdajnihMjesta= new TreeMap<>();
public Prodajno_mjesto(int ID_prodajnoMjesto,String grad,String drzava, String adresa, String telefon){
	this.ID_prodajnoMjesto=ID_prodajnoMjesto;
	this.grad=grad;
	this.drzava=drzava;
	this.adresa=adresa;
	this.telefon=telefon;
	spisakProdajnihMjesta.put(ID_prodajnoMjesto, this);
}

public int getID(){
	return ID_prodajnoMjesto;
}

public static Prodajno_mjesto getProdajnoMjesto(int ID) {
	Prodajno_mjesto trazeno=null;
	for(Prodajno_mjesto p: spisakProdajnihMjesta.values()){
		if(p.ID_prodajnoMjesto==ID){
			trazeno=p;
		}
	}
	return trazeno;
}

public String getGrad(){
	return this.grad;
}
public String getDrzava(){
	return drzava;
}
public String getAdresa(){
	return this.adresa;
}
public String getTelefon(){
	return this.telefon;
}
public static TreeMap<Integer,Prodajno_mjesto> getProdajnaMjesta(){
	return spisakProdajnihMjesta;
}
public static boolean postojiLiProdajnoMjestoUDrzavi(String drzava) {
	
	for(Prodajno_mjesto p: spisakProdajnihMjesta.values()) {
		if(p.drzava.equals(drzava))
			return true;
	}
	
	return false;
}
@Override
public String toString() {
	return " " + this.ID_prodajnoMjesto + " , " + this.grad + " , " + this.drzava + " , "+ this.telefon;
	
}



}
