
import java.sql.*;

public class PovezivanjeSaBazom {

		static String url = "jdbc:mysql://localhost:3306/seminarski_ors1";
		static String user = "root";
		static String password = "";

		Connection con;

		//PODACI IZ TABELE KUPAC
		public static void bazaKupac() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String c= "SELECT * FROM `kupac`";
				Statement stt = con.createStatement();
				ResultSet rs = stt.executeQuery(c);
				while(rs.next()) {
					int id = rs.getInt("id");
					String korisnicko_ime = rs.getString("korisnicko_ime");
					String ime=rs.getString("ime");
					String prezime = rs.getString("prezime");
					String lozinka = rs.getString("lozinka");
					String telefon = rs.getString("telefon");
					String adresa = rs.getString("adresa");
					String grad=rs.getString("grad");
					String drzava = rs.getString("drzava");
					String postanski_broj = rs.getString("postanski_broj");
					String pol = rs.getString("pol");
					String email = rs.getString("email");
					
					Kupac.getKupci().put(id,new Kupac(id,korisnicko_ime, ime,prezime, lozinka,telefon, adresa, grad, drzava, postanski_broj, pol,email)); 
					System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", id,korisnicko_ime,ime,prezime,lozinka,telefon,adresa,grad,drzava, postanski_broj,pol,email);
					
				}
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
		//PDACI IZ TABELE TRGOVAC
		public static void bazaTrgovac() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String f="SELECT * FROM `trgovac`";
				Statement stt = con.createStatement();
				ResultSet rs = stt.executeQuery(f);
				while(rs.next()) {
					int id = rs.getInt("id");
					String korisnicko_ime= rs.getString("korisnicko_ime");
					String ime=rs.getString("ime");
					String prezime = rs.getString("prezime");
					String lozinka=rs.getString("lozinka");
					String pol =rs.getString("pol");
					String telefon = rs.getString("telefon");
					String email = rs.getString("email");
					int prodajno_mjesto_id = rs.getInt("prodajno_mjesto_id");
					
					Trgovac.getSpisakTrgovaca().put(id, new Trgovac(id,korisnicko_ime,ime,prezime, lozinka,pol, telefon,email,prodajno_mjesto_id));
					System.out.format("%s, %s, %s, %s, %s, %s, %s,%s,%s\n",id,korisnicko_ime,ime,prezime,lozinka, pol, telefon, email,prodajno_mjesto_id);
				}
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		//PODACI IZ TABELE PRODAJNO MJESTO
		public static void bazaProdajnoMjesto() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String e = "SELECT * FROM `prodajno_mjesto`";
				Statement stt=con.createStatement();
				ResultSet rs = stt.executeQuery(e);
				while(rs.next()) {
					int id = rs.getInt("id");
					String grad = rs.getString("grad");
					String drzava = rs.getString("drzava");
					String adresa = rs.getString("adresa");
					String telefon = rs.getString("telefon");
					
					Prodajno_mjesto.getProdajnaMjesta().put(id, new Prodajno_mjesto(id,grad,drzava, adresa, telefon));
					//System.out.format("%s, %s, %s, %s, %s\n",id,grad,drzava,adresa,telefon);
				
					
				}
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//PODACI IZ TABELE NARUDZBA
		public static void bazaNarudzba() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String d ="SELECT * FROM `narudzba`";
				Statement stt =con.createStatement();
				ResultSet rs = stt.executeQuery(d);
				while(rs.next()) {
					int id = rs.getInt("id");
					int kupac_id = rs.getInt("kupac_id");
					int trgovac_id = rs.getInt("trgovac_id");
					String datum_narudzbe = rs.getString("datum_narudzbe");
					String datum_isporuke = rs.getString("datum_isporuke");
					String napomena=rs.getString("napomena");
	
					Narudzba.getSpisakNarudzbi().put(id,new Narudzba(id,kupac_id,trgovac_id,datum_narudzbe,datum_isporuke,napomena));
					//System.out.format("%s, %s, %s, %s, %s, %s\n", id, kupac_id,trgovac_id,datum_narudzbe,datum_isporuke,napomena);
					
					
				}
				stt.close();
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
		// PODACI IZ TABELE ARTIKAL NARUDZBE
		public static void bazaArtikalNaruzbe() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String b= "SELECT * FROM `artikal_narudzbe`";
				Statement stt = con.createStatement();
				ResultSet rs = stt.executeQuery(b);
				while(rs.next()) {
					int id = rs.getInt("id");
					int narudzba_id = rs.getInt("narudzba_id");
					int proizvod_id= rs.getInt("proizvod_id");
					int kolicina = rs.getInt("kolicina");
					float cijena= rs.getFloat("cijena_po_komadu");
					Artikal_narudzbe.getArtikliNarudzbe().put(id, new Artikal_narudzbe( narudzba_id,proizvod_id,kolicina,cijena,id));
					//System.out.format("%s, %s, %s, %s, %s\n",narudzba_id,proizvod_id ,kolicina, cijena,id);
				}
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}                         
		}	
		
		// PODACI IZ TABELE PROIZVOD
		public static void bazaProizvod() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String a = "SELECT * FROM `proizvod`";
				Statement stt = con.createStatement();
				ResultSet rs = stt.executeQuery(a);
			      
			      // iterate through the java resultset
			      while (rs.next())
			      {
			        int id = rs.getInt("id");
			        String naziv = rs.getString("naziv");
			        String opis = rs.getString("opis");
			        float  cijena = rs.getFloat("cijena");
			        
			        Proizvod.getProizvodi().put(id, new Proizvod(id,naziv,opis,cijena));
			        //System.out.format("%s, %s, %s, %s\n", id, naziv, opis, cijena);
			      }
			      stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		//REGISTRACIJA PRODAJNOG MJESTA
		public static void registracijaProdajnogMjesta(String drzava, String grad,String adresa, String telefon) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String c= String.format("INSERT INTO `prodajno_mjesto`(`drzava`, `grad`, `adresa`, `telefon`) VALUES ('%s','%s','%s','%s')",
						drzava,grad,adresa,telefon );
				Statement stt = con.createStatement();
				stt.executeUpdate(c);
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		//REGISTRACIJA PROIZVODA
		public static void registracijaProizvoda(String naziv, String opis,float cijena) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String c= String.format("INSERT INTO `proizvod`(`naziv`, `opis`, `cijena`) VALUES ('%s','%s','%s')",
				naziv,opis,cijena);
				Statement stt = con.createStatement();
				stt.executeUpdate(c);
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		//REGISTRACIJA KUPCA
		public static void registracijaKupca(int id,String korisnickoIme,String ime,String prezime, String lozinka, String telefon,
				String grad, String adresa,String drzava, String postanskiBroj, String pol, String email) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String c= String.format("INSERT INTO `kupac`(`id`,`korisnicko_ime`, `ime`, `prezime`, `lozinka`, `telefon`, `adresa`, `grad`, `drzava`,"
			    		+ " `postanski_broj`, `pol`, `email`) VALUES ('%s','%s','%s','%s','%s','%s','%s',"
			    		+ "'%s','%s','%s','%s','%s')",id,korisnickoIme,ime,prezime,lozinka,telefon,grad,adresa, drzava,postanskiBroj, pol,email);
				Statement stt = con.createStatement();
				stt.executeUpdate(c);
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		//AZURIRANJE PROIZVODA
		public static void azuriranjeProizvoda(String naziv,String opis, float cijena) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String c= String.format("UPDATE `proizvod` SET `opis`='%s',`cijena`='%f' WHERE `naziv`='%s'",opis,cijena,naziv);
				Statement stt = con.createStatement();
				stt.executeUpdate(c);
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}}
		//REGISTRACIJA TRGOVCA
		public static void registracijaTrgovca(int id_trgovac,String korisnickoIme,String ime,String prezime, String lozinka, 
				String pol,String telefon, String email, int prodajno_mjesto_id) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String c= String.format("INSERT INTO `trgovac`(`id`,`korisnicko_ime`, `ime`, `prezime`, `lozinka`, `pol`, `telefon`, "
						+ " `email`, `prodajno_mjesto_id`) VALUES ('%s','%s','%s','%s','%s','%s','%s',"
						+ "'%s','%s')",id_trgovac,korisnickoIme,ime,prezime,lozinka,pol,telefon,email, prodajno_mjesto_id );
				Statement stt = con.createStatement();
				stt.executeUpdate(c);
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}}
		//DODAVANJE NARUDZBE
		public static void dodajNarudzbu(Narudzba n) {
			
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				con= DriverManager.getConnection(url,user,password);
				ps=con.prepareStatement("INSERT INTO narudzba (id,kupac_id,trgovac_id,datum_narudzbe,datum_isporuke,napomena)" + "VALUES (?,?,?,?,?,?)");
			
				ps.setInt(1, n.getID());
				Kupac k=n.getKupac();
			
				ps.setInt(2, k.getID());
				Trgovac t= n.getTrgovac();
				if(t==null)
					ps.setInt(3, -1);
				else
					ps.setInt(3, t.getID());
			
				ps.setString(4, n.getDatumNarudzbe());
				ps.setString(5, n.getDatumIsporuke());
				ps.setString(6, n.getNapomena());
			
				ps.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				if(ps !=null) {
					try {
						ps.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	/*	//DODAVANJE ARTIKLA
		public static void dodajArtikalNarudzbe(int narudzba_id,int proizvod_id,int kolicina, float cijena) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,password);
				String c= String.format("INSERT INTO `artikal_narudzbe`(`narudzba_id`, `proizvod_id`, `kolicina`, `cijena_po_komadu`) "
						+ "VALUES ('%d','%d','%d','%f')",narudzba_id, proizvod_id, kolicina,cijena);
				Statement stt = con.createStatement();
				stt.executeUpdate(c);
				stt.close();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}*/
		
	//AZURIRANJE PROIZVODA
		public static void updateProizvod(Proizvod p, Object o, String s) {
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				
				con=DriverManager.getConnection(url,user,password);
				if(s.equals("cijena")) {
					
					ps=con.prepareStatement("UPDATE proizvod SET " +"naziv = ?, opis = ?, cijena = ? WHERE id = ?");
					ps.setString(1,p.getNaziv());
					ps.setString(2,p.getOpis());
					ps.setDouble(3,(float)o);
					ps.setInt(4,p.getID());
					
					p.setCijena((float)o);
				}
				else if(s.equals("naziv")) {
					
					ps=con.prepareStatement("UPDATE proizvod SET " +"naziv = ?, opis = ?, cijena = ? WHERE id = ?");
					ps.setString(1,(String)o);
					ps.setString(2,p.getOpis());
					ps.setDouble(3,p.getCijena());
					ps.setInt(4,p.getID());
					
					p.setNaziv((String)o);
				}
				else {
					
					ps=con.prepareStatement("UPDATE proizvod SET " +"naziv = ?, opis = ?, cijena = ? WHERE id = ?");
					ps.setString(1,p.getNaziv());
					ps.setString(2,(String)o);
					ps.setDouble(3,p.getCijena());
					ps.setInt(4,p.getID());
					
					p.setOpis((String)o);
				}
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(ps!=null) {
					try {
						ps.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

		//UCITAVANJE PODATAKA
		public static void ucitajPodatke() {
			
			Connection myConn=null;
			
			try {
				myConn=DriverManager.getConnection(url,user,password);
				Statement myStmt=myConn.createStatement();
				
				ResultSet myRs3 = myStmt.executeQuery("select * from prodajno_mjesto");
				
				while (myRs3.next()) {
					new Prodajno_mjesto(myRs3.getInt("id"),myRs3.getString("grad"),
							myRs3.getString("drzava"), 
							myRs3.getString("adresa"),
							myRs3.getString("telefon"));
					
					
				}
				
				ResultSet myRs = myStmt.executeQuery("select * from kupac");
				while (myRs.next()) {
					
					
					new Kupac(Integer.parseInt(myRs.getString("id")),
							myRs.getString("korisnicko_ime"),
							myRs.getString("ime"), 
							myRs.getString("prezime"), 
							myRs.getString("lozinka"),
							myRs.getString("telefon"),
							myRs.getString("adresa"),
							myRs.getString("grad"),
							myRs.getString("drzava"),
							myRs.getString("postanski_broj"),
							myRs.getString("pol"),
							myRs.getString("email"));
				}
				ResultSet myRs1 = myStmt.executeQuery("select * from trgovac");
				while (myRs1.next()) {
					
					new Trgovac(Integer.parseInt(myRs1.getString("id")),
							myRs1.getString("korisnicko_ime"),
							myRs1.getString("ime"), 
							myRs1.getString("prezime"), 
							myRs1.getString("lozinka"),
							myRs1.getString("pol"),
							myRs1.getString("telefon"),
							
							myRs1.getString("email"),
							Integer.parseInt(myRs1.getString("prodajno_mjesto_id")));
					
				
				}
				
				ResultSet myRs2 = myStmt.executeQuery("select * from proizvod");
				while (myRs2.next()) {
					new Proizvod(Integer.parseInt(myRs2.getString("id")),
							myRs2.getString("naziv"),
							myRs2.getString("opis"),
							Float.parseFloat(myRs2.getString("cijena")));
				}
				
				
				ResultSet myRs4 = myStmt.executeQuery("select * from narudzba");
				while (myRs4.next()) {
					new Narudzba(Integer.parseInt(myRs4.getString("id")),
							Integer.parseInt(myRs4.getString("kupac_id")),
							Integer.parseInt(myRs4.getString("trgovac_id")),
							myRs4.getString("datum_narudzbe"),
							myRs4.getString("datum_isporuke"),
							myRs4.getString("napomena"));
				}
				ResultSet myRs5 = myStmt.executeQuery("select * from artikal_narudzbe");
				while (myRs5.next()) {
					new Artikal_narudzbe(Integer.parseInt(myRs5.getString("narudzba_id")),
							Integer.parseInt(myRs5.getString("proizvod_id")),
							Integer.parseInt(myRs5.getString("kolicina")),
							Float.parseFloat(myRs5.getString("cijena_po_komadu")),
							Integer.parseInt(myRs5.getString("id"))
							);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(myConn != null) {
				try {
					myConn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		
	//BRISANJE NARUDZBE
		public static void obrisiNarudzbu(int id) {
			Connection con = null;
			PreparedStatement ps= null;
			PreparedStatement ps1= null;
			
			try {
				
				con=DriverManager.getConnection(url,user,password);
				ps=con.prepareStatement("DELETE FROM narudzba WHERE id = ?");
				ps.setInt(1, id);
				ps.executeUpdate();
				
				ps1=con.prepareStatement("DELETE FROM artikal_narudzbe WHERE narudzba_id = ?");
				ps1.setInt(1, id);
				ps1.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(ps!=null) {
					try {
						ps.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			if(con!= null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	//DODAVANJE ARTIKLA NARUDZBE
		public static void dodajArtikalNarudzbe(Artikal_narudzbe an) {
			
			Connection con=null;
			PreparedStatement ps=null;
			
			try {
				
				con=DriverManager.getConnection(url,user,password);
				ps=con.prepareStatement("INSERT INTO artikal_narudzbe (narudzba_id,proizvod_id,kolicina,cijena_po_komadu,id)" + "VALUES (?,?,?,?,?)");
				
				ps.setInt(1,an.getNarudzba().getID());
				ps.setInt(2,an.getProizvod().getID());
				ps.setInt(3,an.getKolicina());
				ps.setFloat(4,an.getCijenaPoKomadu());
				ps.setInt(5,an.getID());
				
				ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(ps!=null) {
					try {
						ps.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}		
public	static int veciDatum(String datum1,String datum2){
int rez=0;
String []d1=datum1.split("-");

int dan1=Integer.parseInt(d1[2]);
int mjesec1=Integer.parseInt(d1[1]);
int godina1=Integer.parseInt(d1[0]);

String []d2=datum2.split("-");

int dan2=Integer.parseInt(d2[2]);
int mjesec2=Integer.parseInt(d2[1]);
int godina2=Integer.parseInt(d2[0]);

if(godina1>godina2)
	rez=1;
if(godina2>godina1 && rez==0)
	rez=2;
if(mjesec1>mjesec2 && rez==0)
	rez=1;
if(mjesec2>mjesec1 && rez==0)
	rez=2;
if(dan1>dan2 && rez==0)
	rez=1;
if(dan2>dan1 && rez==0)
	rez=2;
return rez;
}

		
		public static void main(String [] args)	 {
	//bazaTrgovac();

	}
	}
	
	

