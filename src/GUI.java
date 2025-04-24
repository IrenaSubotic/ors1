

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application{

	public void start(Stage primaryStage)throws Exception{
		PovezivanjeSaBazom.bazaKupac();
		PovezivanjeSaBazom.bazaArtikalNaruzbe();
		PovezivanjeSaBazom.bazaNarudzba();
		PovezivanjeSaBazom.bazaProdajnoMjesto();
		PovezivanjeSaBazom.bazaTrgovac();
		PovezivanjeSaBazom.bazaProizvod();
		PovezivanjeSaBazom.ucitajPodatke();
		
///*****************PRIJAVA**********************************************		
		VBox prijava=new VBox(15);
		
		prijava.setAlignment(Pos.BASELINE_CENTER);
		prijava.setPadding(new Insets(15,50,50,50));
		prijava.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null,null)));
		
		InputStream stream=new FileInputStream("C:/Users/Dell2018/Desktop/eclipse/SEMINARSKI_RAD_ORS1/logo.jpg");
		Image logo=new Image(stream);
		ImageView ivLogo=new ImageView();
		ivLogo.setImage(logo);
		ivLogo.setX(15);
		ivLogo.setY(15);
		ivLogo.setFitWidth(270);
		ivLogo.setPreserveRatio(true);
		
		Label labela=new Label("DOBRODOŠLI U PRODAVNICU SPORTSKE OPREME NEVER GIVE UP");
		labela.setTextFill(Color.BLACK);
		labela.setFont(Font.font("Arial", 18));
		labela.setMaxSize(600, 600);
		
	Label lab= new Label("PRIJAVA"); 
	lab.setTextFill(Color.BLACK);
	lab.setFont(Font.font("Arial", 20));
	lab.setMaxSize(250, 250);
	lab.setAlignment(Pos.CENTER); 
	
	
	Label oglasnaTabla=new Label("");
	oglasnaTabla.setFont(Font.font("Arial", 15));
	Label identifikacija=new Label("     PRIJAVITE SE KAO    ");
	identifikacija.setFont(Font.font("Arial", 15));
	RadioButton k = new RadioButton("KUPAC");
	k.setFont(Font.font("Arial", 15));
	RadioButton t = new RadioButton("TRGOVAC");
	t.setFont(Font.font("Arial", 15));
	ToggleGroup tg=new ToggleGroup();
	k.setToggleGroup(tg);
	t.setToggleGroup(tg);
	HBox izbor=new HBox(20);
	izbor.getChildren().addAll(identifikacija,k,t);
	
	Label lab1= new Label("UNESITE VASE KORISNICKO IME ILI EMAIL");
	lab1.setFont(Font.font("Arial", 15));
	TextField korisnickoime=new TextField();
	korisnickoime.setMaxWidth(300);
	Label lab2=new Label("UNESITE LOZINKU");
	lab2.setFont(Font.font("Arial", 15));
	PasswordField lozinka=new PasswordField();
	lozinka.setMaxWidth(300);
	
	
	Button prijav=new Button("PRIJAVITE SE");
	Label nalog=new Label("Nemate nalog -> ");
	nalog.setFont(Font.font("Arial", 15));
	Button registr=new Button("REGISTRUJTE SE");
	HBox reg=new HBox(30);
	reg.getChildren().addAll(nalog,registr);
	prijava.getChildren().addAll(ivLogo,labela,lab,izbor,lab1,korisnickoime,lab2,lozinka, prijav,reg,oglasnaTabla);
	
	

	Scene scene = new Scene(prijava, 700, 730);
   primaryStage.setScene(scene);
	
	
	
//*****************************REGISTRACIJA	******
	
	VBox registracija=new VBox(10);
	registracija.setAlignment(Pos.BASELINE_CENTER);
	registracija.setPadding(new Insets(15,50,50,50));
	registracija.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null, null)));
	
	
	Label molba=new Label("Molimo Vas da popunite sljedeca polja, ukoliko zelite da se registrujete");
	molba.setFont(Font.font("Arial", 12));
	
	
	Label ime=new Label("Ime:");
	TextField unosImena=new TextField();
	VBox imeBox=new VBox(10);
	imeBox.getChildren().addAll(ime,unosImena);
	
	Label prezime=new Label("Prezime:");
	TextField unosPrezimena=new TextField();
	VBox prezimeBox=new VBox(10);
	prezimeBox.getChildren().addAll(prezime,unosPrezimena);
	
	
	HBox imePrezime=new HBox(20);
	imePrezime.getChildren().addAll(imeBox,prezimeBox);
	
	Label drzava=new Label("Drzava:");
	TextField unosDrzave=new TextField();
	unosDrzave.setMinWidth(50);
	VBox drzavaBox=new VBox(10);
	drzavaBox.getChildren().addAll(drzava,unosDrzave);
	
	Label grad=new Label("Grad:");
	TextField unosGrada=new TextField();
	unosGrada.setMinWidth(50);
	VBox gradBox=new VBox(10);
	gradBox.getChildren().addAll(grad,unosGrada);
	
	HBox gradDrzava=new HBox(20);
	gradDrzava.getChildren().addAll(gradBox,drzavaBox);
	
	
	Label adresa=new Label("Adresa:");
	TextField unosAdrese=new TextField();
	VBox adresaBox=new VBox(10);
	adresaBox.getChildren().addAll(adresa,unosAdrese);
	
	Label postanskiBroj=new Label("Postanski broj:");
	TextField unosPostanskogBroja=new TextField();
	VBox postanskiBrojBox=new VBox(10);
	postanskiBrojBox.getChildren().addAll(postanskiBroj,unosPostanskogBroja);
	
	HBox adresaPosta=new HBox(20);
	adresaPosta.getChildren().addAll(adresaBox,postanskiBrojBox);
	
	Label telefon=new Label("Broj telefona:");
	TextField unosTelefona=new TextField();
	VBox telefonBox=new VBox(10);
	telefonBox.getChildren().addAll(telefon,unosTelefona);
	
	Label email=new Label("Email:");
	TextField unosEmail=new TextField();
	VBox emailBox=new VBox(10);
	emailBox.getChildren().addAll(email,unosEmail);
	
	HBox telefonEmail=new HBox(20);
	telefonEmail.getChildren().addAll(telefonBox,emailBox);
	
	Label pol=new Label("Pol:");
    RadioButton m=new RadioButton("Muski");
    RadioButton z=new RadioButton("Zenski");
    m.setToggleGroup(tg);
	z.setToggleGroup(tg);
    HBox MZ=new HBox(20);
    MZ.getChildren().addAll(pol,m,z);
	
    Label korisnickoIme=new Label("Korisnicko ime:");
	TextField unosKorisnickoIme=new TextField();
	VBox korisnickoImeBox=new VBox(10);
	korisnickoImeBox.getChildren().addAll(korisnickoIme,unosKorisnickoIme);
	
	Label sifra=new Label("Sifra:");
	TextField unosSifra=new TextField();
	VBox sifraBox=new VBox(10);
	sifraBox.getChildren().addAll(sifra,unosSifra);
	
	HBox imeSifra=new HBox(20);
	imeSifra.getChildren().addAll(korisnickoImeBox,sifraBox);
	
	Button registrujSe=new Button("Registrujte se");
	Button nazad=new Button("<- Nazad");
	
	Label oglas=new Label("");
	
	registracija.getChildren().addAll(molba, imePrezime,gradDrzava,adresaPosta,telefonEmail,MZ,imeSifra,registrujSe,nazad,oglas);
	  
	Scene scene2 = new Scene(registracija,480, 550);
	
	
    primaryStage.setScene(scene);
    primaryStage.show();

    registr.setOnAction(e->{
		primaryStage.setScene(scene2);
		
		
	});
    //registracija
    registrujSe.setOnAction(e->{
    	if(unosImena.getText().isEmpty() || unosPrezimena.getText().isEmpty() || unosDrzave.getText().isEmpty()
				|| unosGrada.getText().isEmpty() || unosPostanskogBroja.getText().isEmpty() ||
				unosEmail.getText().isEmpty() || (!m.isSelected() && !z.isSelected())
				|| unosKorisnickoIme.getText().isEmpty() || unosSifra.getText().isEmpty()
				) {
			oglas.setText(" Molimo Vas da popunite polja koja nedostaju.");
			return;
		}
    	//telefon i adresa mogu biti null
    	
    	TreeMap<Integer,Kupac> registrovaniKupci=Kupac.getKupci();
		for(Kupac kupac : registrovaniKupci.values()) {
			if(kupac.getKorisnickoIme().equals(unosKorisnickoIme.getText())) {
				oglas.setText("Postoji registrovan kupac sa ovim korisnickim imenom");
				return;
			}
		}
		
		for(Kupac kupac : registrovaniKupci.values()) {
			if(kupac.getEmail().equals(unosEmail.getText())) {
				oglas.setText("Postoji registrovan kupac sa ovim email-om");
				return;
			}
		}
		

		String korisnickoImeNovo=unosKorisnickoIme.getText();
		String imeNovo=unosImena.getText();
		String prezimeNovo=unosPrezimena.getText();
		String lozinkaNovo=unosSifra.getText();
		String gradNovo=unosGrada.getText();
		String drzavaNovo=unosDrzave.getText();
		String postaBrNovo=unosPostanskogBroja.getText();
		String emailNovo=unosEmail.getText();
		
		String polNovo="";
		if(m.isSelected())
			 polNovo+="M";
		if(z.isSelected())
			 polNovo+="Z";
		//mogu biti i null
		String adresaNovo="";
		if(unosAdrese.getText().isEmpty())
			adresaNovo="null";
		else
			adresaNovo=unosAdrese.getText();
		
		String telefonNovo="";
		if(unosTelefona.getText().isEmpty())
			telefonNovo="null";
		else
			telefonNovo=unosTelefona.getText();
		
		int IDNovi=registrovaniKupci.get(registrovaniKupci.lastKey()).getID()+1;
		
		//Kupac noviKupac=new Kupac(IDNovi,korisnickoImeNovo,imeNovo,prezimeNovo,lozinkaNovo,telefonNovo,adresaNovo,gradNovo,drzavaNovo,postaBrNovo,polNovo,emailNovo);
		//PovezivanjeSaBazom.registracijaKupca(noviKupac);
		PovezivanjeSaBazom.registracijaKupca(IDNovi,korisnickoImeNovo,imeNovo,prezimeNovo,lozinkaNovo,telefonNovo,adresaNovo,gradNovo,drzavaNovo,postaBrNovo,polNovo,emailNovo);
		
    	oglas.setText("Vasa registracija je prihvaæena");
    	
    	unosImena.setText("");
    	unosPrezimena.setText("");
    	unosGrada.setText("");
    	unosPostanskogBroja.setText("");
    	unosTelefona.setText("");
    	unosAdrese.setText("");
    	unosDrzave.setText("");
    	unosEmail.setText("");
    	unosKorisnickoIme.setText("");
    	unosSifra.setText("");
    	
    	m.setSelected(false);
		z.setSelected(false);
    	
		
		
		
	});
    
    
    nazad.setOnAction(e->{
		primaryStage.setScene(scene);
	
	
	});
    
    
    // *****************PRIJAVA*************************************
    prijav.setOnAction(e->{
		if(korisnickoime.getText().isEmpty() || lozinka.getText().isEmpty()) {
			oglasnaTabla.setText("Doslo je do greske. Molimo Vas da oba polja popunite.");
			return;
		}
		if(!k.isSelected() && !t.isSelected()) {
    		oglasnaTabla.setText("Potrebno je izabrati da li ste kupac ili trgovac");
    		return;
    	}
	
		
		
		
		
		
		
		
		
		
		
		
    //************************PRIJAVA KUPCA***************
	if(k.isSelected()) {
		
		oglasnaTabla.setText("");
		
		if(!Kupac.ispravnoKorisnickoIliEmail(korisnickoime.getText())) {
			oglasnaTabla.setManaged(true);
			oglasnaTabla.setText("Neispravno korisnicko ime.");
			return;
		}
		
		if(!Kupac.ispravnaLozinka(korisnickoime.getText(), lozinka.getText())) {
			oglasnaTabla.setText("Neispravna sifra.");
			return;
		}
		
		oglasnaTabla.setText("");
		
		String ki=korisnickoime.getText();
		
		final Kupac kupac=Kupac.pronadjiKupca(ki);
		
		
    VBox kupacBox=new VBox(10);

   kupacBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null, null)));
    Label info=new Label("   ***OSNOVNE INFORMACIJE O VAMA***       ");
    info.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255),null, null)));
    info.setAlignment(Pos.BASELINE_CENTER);
    info.setTextFill(Color.BLACK);
	info.setFont(Font.font("Arial", 18));
    
    
    VBox informacijeKupac=new VBox(10);
    
    Label ime_kupca=new Label("  Ime: "+kupac.getIme());
    ime_kupca.setFont(Font.font("Arial", 15));
    Label prezime_kupca=new Label("  Prezime: "+kupac.getPrezime());
    prezime_kupca.setFont(Font.font("Arial", 15));
    Label id_kupca=new Label("  ID "+kupac.getID());
    id_kupca.setFont(Font.font("Arial", 15));
    Label grad_kupca=new Label("  Grad: "+kupac.getGrad());
    grad_kupca.setFont(Font.font("Arial", 15));
    Label adresa_kupca=new Label("  Adresa: "+kupac.getAdresa());
    adresa_kupca.setFont(Font.font("Arial", 15));
    Label drzava_kupca=new Label("  Drzava: "+kupac.getDrzava());
    drzava_kupca.setFont(Font.font("Arial", 15));
    Label postBr_kupca=new Label("  Postanski broj: "+kupac.getPostanskiBroj());
    postBr_kupca.setFont(Font.font("Arial", 15));
    Label pol_kupca=new Label("  Pol: "+kupac.getPol());
    pol_kupca.setFont(Font.font("Arial", 15));
    Label telefon_kupca=new Label("  Broj telefona: "+kupac.getTelefon());
    telefon_kupca.setFont(Font.font("Arial", 15));
    Label email_kupca=new Label("  Email: "+kupac.getEmail());
    email_kupca.setFont(Font.font("Arial", 15));
    Label on_kupca=new Label("  Broj obavljenih narudzbi : "+kupac.getBrojObavljenihNarudzbi());  
    on_kupca.setFont(Font.font("Arial", 15));
    Label nc_kupca=new Label("  Broj narudzbi na cekanju:  "+kupac.brojNarudzbiNaCekanju());
    nc_kupca.setFont(Font.font("Arial", 15));
   Label vnc_kupca=new Label("  Vrijednost narudzbi na cekanju: "+ kupac.getVrijednostNarudzbiNaCekanju());
   vnc_kupca.setFont(Font.font("Arial", 15));
    
    informacijeKupac.getChildren().addAll(id_kupca,ime_kupca,prezime_kupca,grad_kupca, adresa_kupca,drzava_kupca, postBr_kupca, pol_kupca,telefon_kupca,email_kupca,on_kupca,nc_kupca,vnc_kupca);
    
    VBox dugmici=new VBox(20);
    Button d1=new Button("Pogledajte Vase narudzbe");
    Button d2=new Button("Pogledajte Vase narudzbe na cekanju");
    Button d3=new Button("Pogledajte raspolozive proizvode i naruèite nešto ukoliko želite");
    Button n=new Button("NAZAD");
    dugmici.getChildren().addAll(d1,d2,d3,n);
    n.setOnAction(e2->{
		   primaryStage.setScene(scene);
		   primaryStage.show();
	   }); 
    
    
    
	 kupacBox.getChildren().addAll(info,informacijeKupac, dugmici);
	Scene scene3=new Scene(kupacBox,400,610);
	   primaryStage.setScene(scene3);
	   primaryStage.show();
	
/////********************PREGLED ODOBRENIH NARUDZBI KUPCA****************
	   d1.setOnAction(en->{
	    	Label l=new Label("      *** PREGLED ODOBRENIH NARUDZBI ***");
	    	
	    	TableView tabelaNarudzbi = new TableView();
	
	    	TableColumn<Map, String> column1 = new TableColumn<>("Datum narudzbe:");
	        TableColumn<Map,String>  column2=new TableColumn<>("Datum isporuke:");
	        TableColumn<Map,String> column3=new TableColumn<>("Vrijednost narudzbe:");
	        
	        column1.setCellValueFactory(new MapValueFactory<>("datum_narudzbe"));
	        column2.setCellValueFactory(new MapValueFactory<>("datum_isporuke"));
	        column3.setCellValueFactory(new MapValueFactory<>("vrijednost_narudzbe"));
	        
	        column1.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.3));
	        column2.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.3));
	        column3.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.4));
	        
	        column1.setResizable(false);
	        column1.setResizable(false);
	        column1.setResizable(false);
	  
	        tabelaNarudzbi.getColumns().add(column1);
	        tabelaNarudzbi.getColumns().add(column2);
	        tabelaNarudzbi.getColumns().add(column3);
	        
	    	VBox tabelaBox=new VBox(10);
	    	VBox.setMargin(tabelaBox,new Insets(10,10,10,10));
	    	tabelaBox.getChildren().add(tabelaNarudzbi);	    	    	
	    	
	        
	        TreeMap<Integer,Narudzba>narudzbe=Kupac.getPrihvaceneNarudzbeKupca(kupac);
	        
			for(Narudzba nr: narudzbe.values()) {
				
					Map<String,Object>itemm1=new HashMap<>();
					itemm1.put("datum_narudzbe", nr.getDatumNarudzbe());
					itemm1.put("datum_isporuke", nr.getDatumIsporuke());
					DecimalFormat df = new DecimalFormat("#.00");
					itemm1.put("vrijednost_narudzbe", df.format(nr.getVrijednostNarudzbe()));
					itemm1.put("id",nr.getID());

					tabelaNarudzbi.getItems().add(itemm1);
				
				}
				    	        
	        
			Label gresk=new Label();
			gresk.setBackground(new Background(new BackgroundFill(Color.rgb(255,192,203),CornerRadii.EMPTY, Insets.EMPTY)));
	        
			VBox opcije=new VBox(10);
			
	        Button odjava=new Button("<-Nazad");
	        Button prikaziDetalje=new Button("Detalji");
	        
	        odjava.setMinWidth(100);
	        prikaziDetalje.setMinWidth(100);
	        
	        opcije.getChildren().addAll(prikaziDetalje,odjava);
	        opcije.setAlignment(Pos.CENTER);
	        VBox.setMargin(opcije, new Insets(7,7,7,7));
	        
	        VBox izbornoMjesto=new VBox(10);
	        VBox prikazDet=new VBox();
	        
	        prikazDet.setPadding(new Insets(5,10,0,20));
	        prikazDet.setManaged(false);
	        
	        izbornoMjesto.getChildren().addAll(l,tabelaBox,gresk,opcije,prikazDet);
	        izbornoMjesto.setBackground(new Background(new BackgroundFill(Color.rgb(0, 193, 233), CornerRadii.EMPTY, Insets.EMPTY)));
	        
	        Scene scene333=new Scene(izbornoMjesto,500,500);
   		primaryStage.setScene(scene333);
   		
   		odjava.setOnAction(en1->{
   			primaryStage.setScene(scene3);
   		});
   		
   		//*****klik na detalje
   		prikaziDetalje.setOnAction(aa->{
   			
   			TableView tabelaDetalja=new TableView();
   	
   			
   			TableColumn<Map, String> column1D = new TableColumn<>("Artikal:");
   	        TableColumn<Map,String>  column2D=new TableColumn<>("Kolicina:");
   	        TableColumn<Map,String> column3D=new TableColumn<>("Cijena po komadu:");
   	        //TableColumn<Map,String> column4D=new TableColumn<>("Prodajno mjesto:");
   	        
   	        column1D.setCellValueFactory(new MapValueFactory<>("artikal"));
   	        column2D.setCellValueFactory(new MapValueFactory<>("kolicina"));
   	        column3D.setCellValueFactory(new MapValueFactory<>("cijena"));
   	     
   	        
   	        column1D.prefWidthProperty().bind(tabelaDetalja.widthProperty().multiply(0.333));
   	        column2D.prefWidthProperty().bind(tabelaDetalja.widthProperty().multiply(0.333));
   	        column3D.prefWidthProperty().bind(tabelaDetalja.widthProperty().multiply(0.333));
   	        
   	        
   	        column1D.setResizable(false);
   	        column2D.setResizable(false);
   	        column3D.setResizable(false);
   	  
   	        
   	        tabelaDetalja.getColumns().add(column1D);
   	        tabelaDetalja.getColumns().add(column2D);
   	        tabelaDetalja.getColumns().add(column3D);
   	       
   	        
   	        Map<String,Object> izabrano=(HashMap<String,Object>)tabelaNarudzbi.getSelectionModel().getSelectedItem();
				if(prikazDet.isManaged() && prikazDet.isVisible()) {
					prikazDet.setManaged(false);
					prikazDet.setVisible(false);
					return;
				}
				
				
				tabelaDetalja.getItems().clear();
				
				
   	        int ID=(int)izabrano.get("id");
   	        
				Narudzba narudzba=narudzbe.get(ID);
				
				
				if(izabrano.isEmpty()) {
					gresk.setText("Niste odabrali narudzbu.");
					return;	
				}
   	        
   	        TreeMap<Integer,Artikal_narudzbe> artikliNarudzbe=Artikal_narudzbe.getArtikliNarudzbe();
   	        
   	        for(Artikal_narudzbe a: artikliNarudzbe.values()) {
   	        	if(!a.getNarudzba().equals(narudzba))
						continue;
					
					Map<String,Object>item3=new HashMap<>();
					item3.put("artikal", a.getProizvod().getNaziv());
					item3.put("kolicina", a.getKolicina());
					DecimalFormat df = new DecimalFormat("#.00");
					item3.put("cijena", df.format(a.getCijenaPoKomadu()));
					
					tabelaDetalja.getItems().add(item3);
   	        }
   	        
   	        Label prodajno_mjesto=new Label();
   	        Prodajno_mjesto pm1=narudzba.getTrgovac().getProdajnoMjesto();
   	     	prodajno_mjesto.setText(""+pm1.toString());
   	        
   	        prodajno_mjesto.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
			    prodajno_mjesto.setMinWidth(440);
			    prodajno_mjesto.setMinHeight(25);
			    prodajno_mjesto.setAlignment(Pos.CENTER);
			    
			    Button zatvori=new Button("Zatvori detalje");
				
			    prikazDet.getChildren().addAll(tabelaDetalja,prodajno_mjesto,zatvori);
				prikazDet.setVisible(true);
				prikazDet.setManaged(true);
				
				zatvori.setOnAction(ee->{
					prikazDet.getChildren().clear();
					prikazDet.setVisible(false);
					prikazDet.setManaged(false);
				});
				
				
				
   	        
   			
   			
   		});
	    });
	   
	  
	   
	   
	   
//NA CEKANJU 	   
	   d2.setOnAction(ed2->{
		   
		   Label ld2=new Label ("***VASE NARUDZBE KOJE SU NA CEKANJU***");
	    	
	    	TableView naCekanju = new TableView();
	    	
	    	TableColumn<Map, String> column1 = new TableColumn<>("Datum narudzbe:");
	        TableColumn<Map,String>  column2=new TableColumn<>("Datum isporuke:");
	        TableColumn<Map,String> column3=new TableColumn<>("Vrijednost narudzbe:");
	        
	        column1.setCellValueFactory(new MapValueFactory<>("datum_narudzbe"));
	        column2.setCellValueFactory(new MapValueFactory<>("datum_isporuke"));
	        column3.setCellValueFactory(new MapValueFactory<>("vrijednost_narudzbe"));
	        
	        column1.prefWidthProperty().bind(naCekanju.widthProperty().multiply(0.3));
	        column2.prefWidthProperty().bind(naCekanju.widthProperty().multiply(0.3));
	        column3.prefWidthProperty().bind(naCekanju.widthProperty().multiply(0.4));
	        
	        column1.setResizable(false);
	        column2.setResizable(false);
	        column3.setResizable(false);
	        
	        naCekanju.getColumns().add(column1);
	        naCekanju.getColumns().add(column2);
	        naCekanju.getColumns().add(column3);
	        
	        ScrollPane sp=new ScrollPane();
			sp.setContent(naCekanju);
			sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
	        
			TreeMap<Integer,Narudzba> narudzbe=kupac.getSpisakNarudzbiCijaSeIsporukaCeka();
	        
	        for(Narudzba nra: narudzbe.values()) {

	        		Map<String,Object>item2=new HashMap<>();
	        		item2.put("datum_narudzbe", nra.getDatumNarudzbe());
	        		item2.put("datum_isporuke", "Nije definisano");
	        		DecimalFormat df = new DecimalFormat("#.00");
	        		item2.put("vrijednost_narudzbe", df.format(nra.getVrijednostNarudzbe()));
	        		item2.put("id",nra.getID());
				
	        		naCekanju.getItems().add(item2);
	        	}
	        
	        VBox tabelaBox = new VBox(naCekanju);
	        VBox.setMargin(tabelaBox,new Insets(10,10,10,10));
	        
	        VBox opcije=new VBox(10);
	        Button vrNazad=new Button("Nazad");
	        vrNazad.setMinWidth(180);
	        Button prikaziDetaljeN=new Button("Detalji narudzbe");
	        prikaziDetaljeN.setMinWidth(180);
	        Button otkaziNarudzbu=new Button("Otkazi oznacenu narudzbu");
	        otkaziNarudzbu.setMinWidth(180);
	        
	        VBox izbornoMjesto2=new VBox(10);
	        VBox prikazDet2=new VBox(10);
	        prikazDet2.setPadding(new Insets(5,10,0,20));
	        prikazDet2.setManaged(false);
	        
	        
	        opcije.getChildren().addAll(prikaziDetaljeN,otkaziNarudzbu,vrNazad);
	        
	        
	        izbornoMjesto2.getChildren().addAll(ld2,naCekanju,opcije,prikazDet2);
	        opcije.setAlignment(Pos.CENTER);
	        izbornoMjesto2.setBackground(new Background(new BackgroundFill(Color.rgb(0, 193, 233), CornerRadii.EMPTY, Insets.EMPTY)));
	        
	        Scene sceneCekanje=new Scene(izbornoMjesto2,650,650);
	        primaryStage.setScene(sceneCekanje);
	        
	        
	        vrNazad.setOnAction(en->{
   			primaryStage.setScene(scene3);
   		});
	        
	        
	        prikaziDetaljeN.setOnAction(enn1->{
	        	TableView detaljiTabela=new TableView();
   			
   			TableColumn<Map, String> column1D = new TableColumn<>("Artikal:");
   	        TableColumn<Map,String>  column2D=new TableColumn<>("Kolicina:");
   	        TableColumn<Map,String> column3D=new TableColumn<>("Cijena po komadu:");
   	        
   	        
   	        column1D.setCellValueFactory(new MapValueFactory<>("artikal"));
   	        column2D.setCellValueFactory(new MapValueFactory<>("kolicina"));
   	        column3D.setCellValueFactory(new MapValueFactory<>("cijena"));
   	        
   	        
   	        column1D.prefWidthProperty().bind(detaljiTabela.widthProperty().multiply(0.333));
   	        column2D.prefWidthProperty().bind(detaljiTabela.widthProperty().multiply(0.333));
   	        column3D.prefWidthProperty().bind(detaljiTabela.widthProperty().multiply(0.333));
   	        
   	        
   	        column1D.setResizable(false);
   	        column2D.setResizable(false);
   	        column3D.setResizable(false);
   	        
   	        detaljiTabela.getColumns().add(column1D);
   	        detaljiTabela.getColumns().add(column2D);
   	        detaljiTabela.getColumns().add(column3D);
   	        
   	        Map<String,Object> izabrano=(HashMap<String,Object>)naCekanju.getSelectionModel().getSelectedItem();
				if(prikazDet2.isManaged() && prikazDet2.isVisible()) {
					prikazDet2.setManaged(false);
					prikazDet2.setVisible(false);
					return;
				}
				
				detaljiTabela.getItems().clear();
				
				
   	        int ID=(int)izabrano.get("id");
				Narudzba narudzba=narudzbe.get(ID);
				
				
				if(izabrano==null)
					return;	
				
				TreeMap<Integer,Artikal_narudzbe> artikliNarudzbe=Artikal_narudzbe.getArtikliNarudzbe();
   	        
   	        for(Artikal_narudzbe a: artikliNarudzbe.values()) {
   	        	if(!a.getNarudzba().equals(narudzba))
						continue;
   	        	
					Map<String,Object>itemmm=new HashMap<>();
					itemmm.put("artikal", a.getProizvod().getNaziv());
					itemmm.put("kolicina", a.getKolicina());
					DecimalFormat df = new DecimalFormat("#.00");
					itemmm.put("cijena", df.format(a.getCijenaPoKomadu()));
					
					detaljiTabela.getItems().add(itemmm);
   	        }
   	        
   	        Label labelaProdajnoMjesto=new Label();
   	        Prodajno_mjesto prodajnoMjesto2;
   	        if(narudzba.getTrgovac()==null)
   	        	prodajnoMjesto2=null;
   	        else
   	        	prodajnoMjesto2=narudzba.getTrgovac().getProdajnoMjesto();
   	        	
   	        
				if(prodajnoMjesto2==null)
					labelaProdajnoMjesto.setText("Prodajno mjesto nije jos odabrano");
				else
					labelaProdajnoMjesto.setText("Prodajno mjesto: "+prodajnoMjesto2.toString());
   	        
				labelaProdajnoMjesto.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
				labelaProdajnoMjesto.setMinWidth(515);
				labelaProdajnoMjesto.setMinHeight(30);
				labelaProdajnoMjesto.setAlignment(Pos.CENTER);
			    
			    Button zatvoriDetalje=new Button("Zatvori detalje");
				
			    prikazDet2.getChildren().addAll(detaljiTabela,labelaProdajnoMjesto,zatvoriDetalje);
				prikazDet2.setVisible(true);
				prikazDet2.setManaged(true);
				
				
				zatvoriDetalje.setOnAction(ee->{
					prikazDet2.getChildren().clear();
					prikazDet2.setVisible(false);
					prikazDet2.setManaged(false);
				});
				
				
	        });
	   
	        otkaziNarudzbu.setOnAction(es->{
	        	
	        	Map<String,Object> izabrana=(HashMap<String,Object>)naCekanju.getSelectionModel().getSelectedItem();
	        	
	        	if(izabrana==null)
	        		return;
	        	
	        	int ID=(int)izabrana.get("id");
				Narudzba narudzba=narudzbe.get(ID);
				
				TreeMap<Integer,Narudzba> neprihvacene=Narudzba.getNeprihvaceneNarudzbe();
				neprihvacene.remove(ID);
				
				PovezivanjeSaBazom.obrisiNarudzbu(ID);
				
				naCekanju.getItems().remove(izabrana);
				
				if(prikazDet2.isManaged() && prikazDet2.isVisible()) {
					prikazDet2.setManaged(false);
					prikazDet2.setVisible(false);
				}
				
				narudzbe.remove(ID);
				
	        });
	    });
	   
	   
	   
	   
//PREGLED PROIZVODA
	   d3.setOnAction(e2->{
		   HBox katalog=new HBox(15);
		   
		   HBox pregled3=new HBox(15);
		   Button nazaD=new Button("<-NAZAD");
		   
		   TableView tabela3=new TableView();
		   
		   TableColumn <Map,String > kolona11 = new TableColumn<>("ARTIKAL");
		   kolona11.setCellValueFactory(new MapValueFactory<>("artikal"));
	        TableColumn<Map,String>  kolona22=new TableColumn<>("CIJENA ARTIKLA");
	        kolona22.setCellValueFactory(new MapValueFactory<>("cijena_artikla"));
	       
		   tabela3.getColumns().addAll(kolona11,kolona22);
		   //****
		   PovezivanjeSaBazom.bazaProizvod();
		   TreeMap<Integer,Proizvod> proizvodi=Proizvod.getProizvodi();
		   
			for(Proizvod pr: proizvodi.values()) {
					Map<String,Object>item=new HashMap<>();
					item.put("artikal",pr.getNaziv());
					item.put("cijena_artikla",pr.getCijena());
					item.put("id",pr.getID());
					
					tabela3.getItems().addAll(item);}
					
					
				
			Label unesiKolicinu=new Label("Unesi kolicinu");
			TextField unosKol=new TextField();
			Button izaberi=new Button("Izaberi");
			
			pregled3.getChildren().addAll(tabela3,unesiKolicinu,unosKol,izaberi);
			
			nazaD.setOnAction(e3->{
				   primaryStage.setScene(scene3);
				   primaryStage.show();
			   }); 
			
			 VBox korpa=new VBox(15);
			 TableView tabela4=new TableView();
			   
			   TableColumn <Map,String > kolona111 = new TableColumn<>("ARTIKAL");
			   kolona111.setCellValueFactory(new MapValueFactory<>("artikal"));
		        TableColumn<Map,String>  kolona222=new TableColumn<>("CIJENA ");
		        kolona222.setCellValueFactory(new MapValueFactory<>("cijena_artikla"));
		        TableColumn<Map,String>  kolona333=new TableColumn<>("KOLICINA");
		        kolona333.setCellValueFactory(new MapValueFactory<>("kolicina_artikla"));
		       
			   tabela4.getColumns().addAll(kolona111,kolona222,kolona333);
			  
			   
			  
			   Label kor=new Label("Korpa");
			   Button izbaci=new Button("Izbaci");
			   Button izbaciSve=new Button("Isprazni korpu");
			   Button naruci=new Button("Naruci");
			   Label ukupno=new Label("Ukupno");
			   ukupno.setTextFill(Color.BLACK);
			   ukupno.setFont(Font.font("Arial", 15));
			   Label obavjestenje=new Label("");
			   obavjestenje.setTextFill(Color.RED);
			obavjestenje.setFont(Font.font("Arial", 30));
			   
			   korpa.getChildren().addAll(kor,tabela4,izbaci,izbaciSve,naruci,ukupno,obavjestenje);

				katalog.getChildren().addAll(pregled3,korpa,nazaD);
				katalog.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null, null)));
				Scene scene5=new Scene(katalog,970,800);
				
				primaryStage.setScene(scene5);
				primaryStage.show();
			   
				izbaciSve.setOnAction(e3->{
					tabela4.getItems().clear();
					tabela4.refresh();
				});
				
	//izaberi proizvode u korpu			
				izaberi.setOnAction(i->{
					Map<String,Object> oznaceni=(HashMap<String,Object>)tabela3.getSelectionModel().getSelectedItem();
					if(oznaceni== null)
						return;
					if(unosKol.getText().equals("") || unosKol.getText().equals("0")) {
						obavjestenje.setText("Neispravan unos.");
						return;
					}
	
					int poljeKolicina=0;
					
					try {
						poljeKolicina=Integer.parseInt(unosKol.getText());
					}catch(Exception excep) {
						obavjestenje.setText("Neispravan unos.");
						obavjestenje.setVisible(true);
						obavjestenje.setManaged(true);
						return;
					}
					
					if(obavjestenje.isManaged() && obavjestenje.isVisible()) {
						obavjestenje.setVisible(false);
						obavjestenje.setManaged(false);
					}
					
					int id_proizvoda=(int)oznaceni.get("id");
					Proizvod proizvod=proizvodi.get(id_proizvoda);
					
					float zbir=0;
					for(Object mapa: tabela4.getItems()) {
						Map<String,Object>ma=(HashMap<String, Object>)mapa;
						zbir+=(float)ma.get("cijena_artikla")*(int)ma.get("kolicina_artikla");
					}
					
					for(Object mapa: tabela4.getItems()) {
						
						Map<String,Object>ma=(HashMap<String, Object>)mapa;
						
						if((int)ma.get("id")==id_proizvoda) {
							ma.put("kolicina_artikla",(int)ma.get("kolicina_artikla")+poljeKolicina);
							zbir+=(float)ma.get("cijena_artikla")*poljeKolicina;
							DecimalFormat df = new DecimalFormat("#.00");
							BigDecimal bd=BigDecimal.valueOf(zbir);
							bd=bd.setScale(2,RoundingMode.HALF_UP);
							ukupno.setText(bd.floatValue()+"");
							tabela4.refresh();
							return;
						}
					}
					
					DecimalFormat df = new DecimalFormat("#.00");
					Map<String,Object>m1=new HashMap<>();
					m1.put("artikal", proizvod.getNaziv());
					BigDecimal bd=BigDecimal.valueOf(proizvod.getCijena());
					bd=bd.setScale(2,RoundingMode.HALF_UP);
					m1.put("cijena_artikla",bd.floatValue());
					m1.put("kolicina_artikla", poljeKolicina);
					m1.put("id", proizvod.getID());
					
					tabela4.getItems().add(m1);
					zbir+=proizvod.getCijena()*poljeKolicina;
					BigDecimal bd1=BigDecimal.valueOf(zbir);
					bd1=bd1.setScale(2,RoundingMode.HALF_UP);
					ukupno.setText(bd1.floatValue()+"");
					
				});	
//naruci---baza				
				naruci.setOnAction(na->{
					PovezivanjeSaBazom.bazaNarudzba();
					TreeMap<Integer,Narudzba> narudzbe=Narudzba.getSpisakNarudzbi();
					
					int narudzba_id=narudzbe.lastKey()+1;
					int kupac_ID=kupac.getID();
					LocalDate datum=LocalDate.now();
					String datum_narudzbe=datum.toString();
					String datum_isporuke=null;
					String napomena=null;
					
					Narudzba nova=new Narudzba(narudzba_id,kupac_ID,-1,datum_narudzbe,
							datum_isporuke,napomena);
					
					PovezivanjeSaBazom.dodajNarudzbu(nova);
				
					TreeMap<Integer,Artikal_narudzbe>artikli=Artikal_narudzbe.getArtikliNarudzbe();
					for(Object mapa: tabela4.getItems()) {
						
						Map<String,Object>mapaa=(HashMap<String, Object>)mapa;
						int proizvodID=(int)mapaa.get("id");
						int kolicinaPr=(int)mapaa.get("kolicina_artikla");
						float cijenaP=(float)mapaa.get("cijena_artikla");
						int artNarID=artikli.lastKey()+1;
						Artikal_narudzbe artik=new Artikal_narudzbe(narudzba_id,proizvodID,kolicinaPr,cijenaP,artNarID);
						PovezivanjeSaBazom.dodajArtikalNarudzbe(artik);
					}
					
					primaryStage.setScene(scene3);
					primaryStage.show();
					
					
					
				});
	//izbaci
	izbaci.setOnAction(sa1->{
					
					Map<String,Object> selected=(HashMap<String,Object>)tabela4.getSelectionModel().getSelectedItem();
					if(selected==null)
						return;
					int id_izbaci=(int)selected.get("id");
					
					tabela4.getItems().remove(selected);
					
					if(tabela4.getItems().size()==1){
						ukupno.setText("");}
					else {
						float zbir=Float.parseFloat(ukupno.getText())-(float)selected.get("cijena_artikla")*(int)selected.get("kolicina");
						BigDecimal bd1=BigDecimal.valueOf(zbir);
						bd1=bd1.setScale(3,RoundingMode.HALF_UP);
						ukupno.setText(bd1.doubleValue()+"");
					}
					
				});
				
				
			
			   
				   }); 
	
	}
	
	
	
	
	//****************PRIJAVA TRGOVCA****************************
	if(t.isSelected()) {
            oglasnaTabla.setText("");
		
		if(!Trgovac.ispravnoKorisnickoIliEmail(korisnickoime.getText())) {
			oglasnaTabla.setManaged(true);
			oglasnaTabla.setText("Neispravno korisnicko ime.");
			return;
		}
		
		if(!Trgovac.ispravnaLozinka(korisnickoime.getText(), lozinka.getText())) {
			oglasnaTabla.setText("Neispravna sifra.");
			return;
		}
		
		oglasnaTabla.setText("");
		String korisnickoImeTrgovca=korisnickoime.getText();
		PovezivanjeSaBazom.bazaTrgovac();
		
	 Trgovac trgovac=Trgovac.pronadjiTrgovca(korisnickoImeTrgovca);
	 
		Prodajno_mjesto prodajnoMjesto=trgovac.getProdajnoMjesto();
		TreeMap<Integer,Narudzba> prihvacene=Trgovac.getPrihvaceneNarudzbeTrgovca(trgovac);
		
		VBox trgovacBox=new VBox(10);
		   trgovacBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null, null)));
		    Label info=new Label("   ***OSNOVNE INFORMACIJE O VAMA***       ");
		    info.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255),null, null)));
		    info.setAlignment(Pos.BASELINE_CENTER);
		    info.setTextFill(Color.BLACK);
			info.setFont(Font.font("Arial", 18));
		    
		    
		    VBox informacijeTrgovac=new VBox(15);
		    
		    Label ime_trgovca=new Label("  Ime: "+trgovac.getIme());
		    ime_trgovca.setFont(Font.font("Arial", 15));
		    Label prezime_trgovca=new Label("  Prezime: "+trgovac.getPrezime());
		    prezime_trgovca.setFont(Font.font("Arial", 15));
		    Label id_trgovca=new Label("  ID: "+trgovac.getID());
		    id_trgovca.setFont(Font.font("Arial", 15));
		    Label pol_trgovca=new Label("  Pol: "+trgovac.getPol());
		    pol_trgovca.setFont(Font.font("Arial", 15));
		    Label telefon_trgovca=new Label("  Broj telefona: "+trgovac.getTelefon());
		    telefon_trgovca.setFont(Font.font("Arial", 15));
		    Label email_trgovca=new Label("  Email: "+trgovac.getEmail());
		    email_trgovca.setFont(Font.font("Arial", 15));
		    Label prodajnoMjesto_trgovca=new Label("Prodajno mjesto: "+trgovac.getProdajnoMjesto());
		    prodajnoMjesto_trgovca.setFont(Font.font("Arial", 15));
		
		    informacijeTrgovac.getChildren().addAll(id_trgovca,ime_trgovca,prezime_trgovca,prodajnoMjesto_trgovca,pol_trgovca,telefon_trgovca,email_trgovca);
		
		    VBox dugmici=new VBox(20);
		    Button d1=new Button("Pogledajte narudzbe na cekanju(neprihvacene narudzbe)");
		    Button d2=new Button("Pogledajte odobrene narudzbe");
		    Button d3=new Button("Dodajte prodajno mjesto");
		    Button d4=new Button("Dodajte trgovca na prodajno mjesto");
		    Button d5=new Button("Dodajte proizvod");
		    Button d6=new Button("Azurirajte proizvod");
		    Button n=new Button("<-NAZAD");
		    dugmici.getChildren().addAll(d1,d2,d3,d4,d5,d6,n);
		    n.setOnAction(e2->{
				   primaryStage.setScene(scene);
				   primaryStage.show();
			   }); 
		    
			  trgovacBox.getChildren().addAll(info,informacijeTrgovac,dugmici);
				Scene scene5=new Scene(trgovacBox,480,610);
				   primaryStage.setScene(scene5);
				   primaryStage.show();
				  
/////neprihvacene 	 narudzbe			   
				  d1.setOnAction(ed1->{
					  Label poc=new Label("         ***NARUDZBE KOJIMA NIJE ODREDJEN DATUM ISPORUKE***");
		    			poc.setAlignment(Pos.BASELINE_CENTER);
		    			poc.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255),null, null)));
					 
					  
		    			TableView tabelaNarudzbi = new TableView();

		    			TableColumn<Map, String> column1 = new TableColumn<>("Kupac:");
		    	        TableColumn<Map,String>  column2=new TableColumn<>("Drzava:");
		    			TableColumn<Map, String> column3 = new TableColumn<>("Datum narudzbe:");
		    	        TableColumn<Map,String>  column4=new TableColumn<>("Datum isporuke:");
		    	        TableColumn<Map,String> column5=new TableColumn<>("Vrijednost narudzbe:");
		    	        
		    	        column1.setCellValueFactory(new MapValueFactory<>("kupac"));
		    	        column2.setCellValueFactory(new MapValueFactory<>("drzava"));
		    	        column3.setCellValueFactory(new MapValueFactory<>("datum_narudzbe"));
		    	        column4.setCellValueFactory(new MapValueFactory<>("datum_isporuke"));
		    	        column5.setCellValueFactory(new MapValueFactory<>("vrijednost_narudzbe"));
		    	        
		    	        column1.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.2));
		    	        column2.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.2));
		    	        column3.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.2));
		    	        column4.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.2));
		    	        column5.prefWidthProperty().bind(tabelaNarudzbi.widthProperty().multiply(0.2));
		    	        
		    	        column1.setResizable(false);
		    	        column2.setResizable(false);
		    	        column3.setResizable(false);
		    	        column4.setResizable(false);
		    	        column5.setResizable(false);
		    	        
		    	        tabelaNarudzbi.getColumns().add(column1);
		    	        tabelaNarudzbi.getColumns().add(column2);
		    	        tabelaNarudzbi.getColumns().add(column3);
		    	        tabelaNarudzbi.getColumns().add(column4);
		    	        tabelaNarudzbi.getColumns().add(column5);
		    	        
		    	        ScrollPane sp=new ScrollPane();
		    			sp.setContent(tabelaNarudzbi);
		    			sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		    			sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		    	        
		    			TreeMap<Integer,Narudzba> narudzbeNeprihvacene=Narudzba.getNeprihvaceneNarudzbe();
		    			
		    	        
		    	        for(Narudzba nn: narudzbeNeprihvacene.values()) {
		    				
		    	        	boolean prodajnomjesto=Prodajno_mjesto.postojiLiProdajnoMjestoUDrzavi(nn.getKupac().getDrzava());
		    	        	
		    	        		if(!prodajnomjesto) {
		    						Kupac kup=nn.getKupac();
		    						String ime_prezime=kup.getIme()+" "+kup.getPrezime();
		    						
		    						Map<String,Object>itemm2=new HashMap<>();
		    						itemm2.put("kupac",ime_prezime);
		    						itemm2.put("drzava",kup.getDrzava());
		    						itemm2.put("datum_narudzbe", nn.getDatumNarudzbe());
		    						itemm2.put("datum_isporuke", nn.getDatumIsporuke());
		    						DecimalFormat df = new DecimalFormat("#.00");
		    						itemm2.put("vrijednost_narudzbe", df.format(nn.getVrijednostNarudzbe()));
		    						itemm2.put("id",nn.getID());
		    				
		    				
		    						tabelaNarudzbi.getItems().add(itemm2);
		    					}
		    					else {
		    						Kupac kup=nn.getKupac();
		    						boolean odgovaraLiDrzava=trgovac.daLiJeTrgovacUOvojDrzavi(kup.getDrzava());
		 
		    						if(odgovaraLiDrzava) {
		    							
		    							String ime_prezime=kup.getIme()+" "+kup.getPrezime();
		    							Map<String,Object>itemm=new HashMap<>();
			    						itemm.put("kupac",ime_prezime);
			    						itemm.put("drzava",kup.getDrzava());
			    						itemm.put("datum_narudzbe", nn.getDatumNarudzbe());
			    						itemm.put("datum_isporuke", nn.getDatumIsporuke());
			    						DecimalFormat df = new DecimalFormat("#.00");
			    						itemm.put("vrijednost_narudzbe", df.format(nn.getVrijednostNarudzbe()));
			    						itemm.put("id",nn.getID());
			    				
			    				
			    						tabelaNarudzbi.getItems().add(itemm);
		    							
		    						}
		    					
		    	        	}
		    	        	
		    	        
		    	        }
		    	        VBox tabelaBox = new VBox(tabelaNarudzbi);
		    	        VBox.setMargin(tabelaBox,new Insets(10,10,10,10));
		    	        
		    	        
		    	        
		    	        Label greska=new Label("Neispravan unos.");
		    	        greska.setBackground(new Background(new BackgroundFill(Color.rgb(0,193,233),null,null)));
		    	        greska.setVisible(false);
		    	        greska.setManaged(false);
		    	        
		    	        Label DatIsporuke=new Label("Unesite datum isporuke:");
		    	        TextField unosDatumaIsporuke=new TextField();
		    	   
		    	        HBox datumi=new HBox(10);
		    	        datumi.getChildren().addAll(greska,DatIsporuke,unosDatumaIsporuke);
		    	        
		    	        
		    	        Button azuriraj=new Button("Azuriraj");
		    	        Button zatvori1=new Button("Zatvori");
		    	        Button prihvatiNarudzbu=new Button("Prihvati narudzbu");
		    	        Button odjava=new Button("Nazad");
		    	        
		    	        VBox izbornoMjesto=new VBox(10);
		    	 
		    	        izbornoMjesto.getChildren().addAll(poc,tabelaBox,datumi,prihvatiNarudzbu,odjava);
		    	        izbornoMjesto.setBackground(new Background(new BackgroundFill(Color.rgb(0, 193, 233),null,null)));
		    	        
		    	        Scene sceneNeprihvacenihNarudzbi=new Scene(izbornoMjesto,500,550);
		    	        primaryStage.setScene(sceneNeprihvacenihNarudzbi);
		    	        
		    	        prihvatiNarudzbu.setOnAction(e1->{
		    	        	
			    	       	    	       
			    	        	if(unosDatumaIsporuke.getText().isEmpty()) {
			    	        		greska.setText("Niste unijeli datum isporuke");
			    	        		greska.setVisible(true);
			    	    	        greska.setManaged(true);
			    	        	}
			    	        	
			    	        	Map<String,Object> izabrana=(HashMap<String,Object>)tabelaNarudzbi.getSelectionModel().getSelectedItem();
			    	        	if(izabrana==null)
			    	        		return;
			    	        	
			    	        	int id=(int)izabrana.get("id");
			    	        	
			    	        	Narudzba narudzbaNeprihvacena=narudzbeNeprihvacene.get(id);
			    	        	
								greska.setText("");
			    	        	
								String datum=unosDatumaIsporuke.getText();
								String datumNarudzbe=narudzbaNeprihvacena.getDatumNarudzbe();
								if(PovezivanjeSaBazom.veciDatum(datumNarudzbe,datum)==2) {
			    	     
			    	        	narudzbaNeprihvacena.setDatumIsporuke(datum);
			    	        	narudzbaNeprihvacena.setTrgovac(trgovac);
								prihvacene.put(narudzbaNeprihvacena.getID(),narudzbaNeprihvacena);
							
                 for(Object mapa: tabelaNarudzbi.getItems()) {
									
									Map<String,Object>item33=(HashMap<String, Object>)mapa;
									if((int)item33.get("id")==narudzbaNeprihvacena.getID()) {
										item33.put("datum_isporuke",(String)datum);
										 tabelaNarudzbi.refresh();
										return;
									}
								}
								
								
								narudzbeNeprihvacene.remove(narudzbaNeprihvacena);
								
								narudzbaNeprihvacena.setDatumIsporuke(datum);
								prihvacene.put(narudzbaNeprihvacena.getID(),narudzbaNeprihvacena);
							
								
								greska.setText("Datum isporuke odredjen");
								greska.setText("Datum isporuke je prihvacen!");}
								else {
									greska.setText("Pogresan datum");
								    greska.setVisible(true);}
								
									
								
			    	        });
		    	       
		    	        odjava.setOnAction(eodjava->{
			    			primaryStage.setScene(scene5);
			    		});
		    		});		   

///ODOBRENE 
				   
				   
			  d2.setOnAction(ex123->{
				  TableView tabela11=new TableView();
				   
				   TableColumn <Map,String > kol1 = new TableColumn<>("Datum narudzbe");
				   kol1.setCellValueFactory(new MapValueFactory<>("datum_narudzbe"));
			      TableColumn<Map,String>  kol2=new TableColumn<>("Datum isporuke");
			      kol2.setCellValueFactory(new MapValueFactory<>("datum_isporuke"));
			      TableColumn<Map,String>  kol3=new TableColumn<>("Vrijednost");
			      kol3.setCellValueFactory(new MapValueFactory<>("vrijednost"));
			      
			     
				   tabela11.getColumns().addAll(kol1,kol2,kol3);

				   ObservableList<Map<String,Object>> lista5=FXCollections.<Map<String,Object>> observableArrayList();
					for(Narudzba narudd: prihvacene.values()) {
							Map<String,Object>item=new HashMap<>();
							item.put("datum_narudzbe",narudd.getDatumNarudzbe());
							item.put("datum_isporuke",narudd.getDatumIsporuke());
							item.put("vrijednost",narudd.getVrijednostNarudzbe());
							item.put("id",narudd.getID());
							lista5.add(item);}
							tabela11.getItems().addAll(lista5);
							
		    				
		    			Label st=new Label("         ***ODOBRENE NARUDZBE***");
		    			st.setAlignment(Pos.BASELINE_CENTER);
		    			VBox opcije=new VBox(10);
		    			opcije.setAlignment(Pos.CENTER);
		    	        Button odjava_t=new Button("<-Nazad");
		    	        odjava_t.setMinWidth(100);
		    	        Button prikaziDetaljee=new Button("Detalji o narudzbi");
		    	        prikaziDetaljee.setMinWidth(100);
		    	        
		    	        VBox izbornoMjesto=new VBox(10);
		    	        VBox prikazDet=new VBox(10);
		    	        prikazDet.setPadding(new Insets(5,10,0,20));
		    	        prikazDet.setManaged(false);
		    	        VBox ta11 = new VBox(tabela11);
		    	        VBox.setMargin(ta11,new Insets(10,10,10,10));
		    	        
		    	        opcije.getChildren().addAll(prikaziDetaljee,odjava_t);
		    	        
		    	        izbornoMjesto.getChildren().addAll(st,ta11,opcije,prikazDet);
		    	        izbornoMjesto.setBackground(new Background(new BackgroundFill(Color.rgb(0, 193, 233), CornerRadii.EMPTY, Insets.EMPTY)));
		    	        
		    	        Scene scenaNar=new Scene(izbornoMjesto,600,700);
		    	        primaryStage.setScene(scenaNar);
		    	        
		    	        odjava_t.setOnAction(en->{
			    			primaryStage.setScene(scene5);
			    		});
		    	        
		    	       prikaziDetaljee.setOnAction(u->{
		    	        	
		 	    	        	TableView tabelaDetalja=new TableView();
		 		    			
		 		    			TableColumn<Map, String> column1D = new TableColumn<>("Artikal:");
		 		    	        TableColumn<Map,String>  column2D=new TableColumn<>("Kolicina:");
		 		    	        TableColumn<Map,String> column3D=new TableColumn<>("Cijena po komadu:");
		 		    	        
		 		    	        
		 		    	        column1D.setCellValueFactory(new MapValueFactory<>("artikal"));
		 		    	        column2D.setCellValueFactory(new MapValueFactory<>("kolicina"));
		 		    	        column3D.setCellValueFactory(new MapValueFactory<>("cijena"));
		 		    	        
		 		    	        
		 		    	        column1D.prefWidthProperty().bind(tabelaDetalja.widthProperty().multiply(0.333));
		 		    	        column2D.prefWidthProperty().bind(tabelaDetalja.widthProperty().multiply(0.333));
		 		    	        column3D.prefWidthProperty().bind(tabelaDetalja.widthProperty().multiply(0.333));
		 		    	        
		 		    	        
		 		    	        column1D.setResizable(false);
		 		    	        column2D.setResizable(false);
		 		    	        column3D.setResizable(false);
		 		    	        
		 		    	        tabelaDetalja.getColumns().add(column1D);
		 		    	        tabelaDetalja.getColumns().add(column2D);
		 		    	        tabelaDetalja.getColumns().add(column3D);
		 		    	        
		 		    	        Map<String,Object> izabrano=(HashMap<String,Object>)tabela11.getSelectionModel().getSelectedItem();
		 						
		 		    	        if(prikazDet.isManaged() && prikazDet.isVisible()) {
		 							prikazDet.setManaged(false);
		 							prikazDet.setVisible(false);
		 							return;
		 						}
		 						
		 						tabelaDetalja.getItems().clear();
		 						
		 						int ID=0;
		 		    	        try {ID=(int)izabrano.get("id");}
		 		    	        catch(Exception et){}
		 		    	        
		 						Narudzba narudzba=prihvacene.get(ID);
		 						
		 						if(izabrano==null)
		 							return;	
		 						
		 						TreeMap<Integer,Artikal_narudzbe> artikliNarudzbe=Artikal_narudzbe.getArtikliNarudzbe();
		 		    	        
		 		    	        for(Artikal_narudzbe a: artikliNarudzbe.values()) {
		 		    	        	if(!a.getNarudzba().equals(narudzba))
		 								continue;
		 							
		 							Map<String,Object>ma1=new HashMap<>();
		 							ma1.put("artikal", a.getProizvod().getNaziv());
		 							ma1.put("kolicina", a.getKolicina());
		 							DecimalFormat df = new DecimalFormat("#.00");
		 							ma1.put("cijena", df.format(a.getCijenaPoKomadu()));
		 							
		 							tabelaDetalja.getItems().add(ma1);
		 		    	        }
		 		    	        
		 		    	        Label prodajnomjesto1=new Label();
		 		    	        Prodajno_mjesto pm2=narudzba.getTrgovac().getProdajnoMjesto();
		 						prodajnomjesto1.setText(" "+pm2.toString());
		 		    	        
		 					  prodajnomjesto1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
							   prodajnomjesto1.setMinWidth(520);
							   prodajnomjesto1.setMinHeight(30);
							    prodajnomjesto1.setAlignment(Pos.CENTER);
		 					   
		 					    Button zatvori1=new Button("Zatvorite detalje");
		 						
		 					    prikazDet.getChildren().addAll(tabelaDetalja,prodajnomjesto1,zatvori1);
		 						prikazDet.setVisible(true);
		 						prikazDet.setManaged(true);
		 						
		 						zatvori1.setOnAction(ee->{
		 							prikazDet.getChildren().clear();
		 							prikazDet.setVisible(false);
		 							prikazDet.setManaged(false);
		 						});

		    	        });
		    		});
				   
	//noviii trgovac
				  d4.setOnAction(ee->{
		    			Label start=new Label("***DODAVANJE TRGOVCA NA PRODAJNO MJESTO***");
		    			start.setAlignment(Pos.BASELINE_CENTER);
		    			Label obavjestenje=new Label("");
		    			
		    			Label izaberi=new Label("Molimo Vas da izaberete prodajno mjesto novog trgovca:");
		    			
                         TableView prodajnoM=new TableView();
		    			
						TableColumn<Map,String> column1=new TableColumn("Mjesto:");
		    	    	TableColumn<Map,String> column2=new TableColumn("Adresa:");
		    	    	TableColumn<Map,String> column3=new TableColumn("Drzava:");
		    	    	
		    	    	column1.setCellValueFactory(new MapValueFactory<>("mjesto"));
		    	        column2.setCellValueFactory(new MapValueFactory<>("adresa"));
		    	        column3.setCellValueFactory(new MapValueFactory<>("drzava"));
		    	       
		    	        prodajnoM.getColumns().addAll(column1,column2,column3);
		    	        prodajnoM.setMinSize(220, 170);
		    	        TreeMap<Integer,Prodajno_mjesto> prodajna_mjesta=Prodajno_mjesto.getProdajnaMjesta();
		    	        
		    	        for(Prodajno_mjesto p:prodajna_mjesta.values()) {
		    	        	Map<String,Object>itm=new HashMap<>();
		    	        	itm.put("mjesto", p.getGrad());
							itm.put("adresa", p.getAdresa());
							itm.put("drzava", p.getDrzava());
							itm.put("id",p.getID());
							prodajnoM.getItems().add(itm);
		    	        }
		    	        prodajnoM.setMaxHeight(120);
		    			
		    			
		    			
		    			
		    			Label imeTrgovca=new Label("Unesite ime: ");
		    			TextField unosImenaTrgovca=new TextField();
		    			HBox imeTBox=new HBox(10);
		    			imeTBox.getChildren().addAll(imeTrgovca,unosImenaTrgovca);
		    			
		    			Label prezimeTrgovca=new Label("Unesite prezime:");
		    			TextField unosPrezimenaTrgovca=new TextField();
		    			HBox prezimeTBox=new HBox(10);
		    			prezimeTBox.getChildren().addAll(prezimeTrgovca,unosPrezimenaTrgovca);
		    			
		    			Label telefonT=new Label("Unesite broj telefona: ");
		    			TextField unosTelefonT=new TextField();
		    			HBox telefonTBox=new HBox(10);
		    			telefonTBox.getChildren().addAll(telefonT,unosTelefonT);
		    			
		    			Label emailT=new Label("Unesite email:");
		    			TextField unosEmailT=new TextField();
		    			HBox emailTBox=new HBox(10);
		    			emailTBox.getChildren().addAll(emailT,unosEmailT);
		    			
		    			Label polT=new Label("Pol:");
		    			RadioButton mus=new RadioButton("Muski");
		    			RadioButton zen=new RadioButton("Zenski");
		    			mus.setToggleGroup(tg);
		    			zen.setToggleGroup(tg);
		    			HBox polTBox=new HBox(10);
		    			polTBox.getChildren().addAll(polT,mus,zen);
		    			
		    			
		    			
		    			
		    	        Label korisnickoT=new Label("Korisnicko ime:");
		    			TextField korisnickoUnos=new TextField();
		    			HBox korisnickoBox=new HBox(10);
		    			korisnickoBox.getChildren().addAll(korisnickoT,korisnickoUnos);
		    			Label lozinkaT=new Label("Lozinka:");
		    			PasswordField lozinkaUnos=new PasswordField();
		    			HBox lozinkaBox=new HBox(10);
		    			lozinkaBox.getChildren().addAll(lozinkaT,lozinkaUnos);
		    			
		    			Button dodaj=new Button("Dodaj");
		    			dodaj.setMinWidth(100);
		    			Button nazadd=new Button("<-Nazad");
		    			nazad.setMinWidth(100);
		    			VBox dugmad=new VBox(10);
		    			dugmad.setAlignment(Pos.CENTER);
		    			dugmad.getChildren().addAll(dodaj,nazadd);
		    			
		    			VBox unos=new VBox(10);
		    			VBox.setMargin(unos,new Insets(5,5,5,5));
		    			unos.getChildren().addAll(obavjestenje,imeTBox,prezimeTBox,telefonTBox,emailTBox,polTBox,korisnickoBox,lozinkaBox,dugmad);
		    			
		    			VBox sve=new VBox(10);
		    			VBox tabel=new VBox(prodajnoM);
		    			sve.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null,null)));;
		    			sve.getChildren().addAll(start,izaberi,tabel,unos);
		    			unos.setMaxHeight(100);
		    			
		    			Scene scene10=new Scene(sve,500,650);
			    		
		    			primaryStage.setScene(scene10);
		    			
		    			dodaj.setOnAction(a->{
		    				
		    				Map<String,Object> izabrano=(HashMap<String,Object>)prodajnoM.getSelectionModel().getSelectedItem();
		    	        	
		    				if(izabrano==null) {
		    	        		obavjestenje.setText("Niste odabrali prodajno mjesto.");
		    					obavjestenje.setVisible(true);
		    					obavjestenje.setManaged(true);
		    	        	}
		    	        	
		    	        	int id_prodajnoMjesto=(int)izabrano.get("id");
		    	        	Prodajno_mjesto pm=prodajna_mjesta.get(id_prodajnoMjesto);
		    				
		    	        	if(unosImenaTrgovca.getText().isEmpty() || unosPrezimenaTrgovca.getText().isEmpty()||(!zen.isSelected() && !mus.isSelected()) || unosTelefonT.getText().isEmpty()|| unosEmailT.getText().isEmpty() || korisnickoUnos.getText().isEmpty() || lozinkaUnos.getText().isEmpty()) {
		    					obavjestenje.setText("Niste popunili sva polja");
		    					obavjestenje.setVisible(true);
		    					obavjestenje.setManaged(true);
		    				}
		    				
		    				String ime_trgovac=unosImenaTrgovca.getText();
		    				String prezime_trgovac=unosPrezimenaTrgovca.getText();
		    				String korisnicko_trgovac=korisnickoUnos.getText();
		    				String lozinka_trgovac=lozinkaUnos.getText();
		    				String pol_trgovac=new String("");
		    				if(zen.isSelected())
		    					pol_trgovac="Z";
		    				else if(mus.isSelected())
		    					pol_trgovac="M";
		    				String telefon_trgovac=unosTelefonT.getText();
		    				String email_trgovac=unosEmailT.getText();
		    				int ID=trgovac.getPosljednjiID()+1;
		    				int pmID_t=0;
		    				int id_trgovac=Trgovac.getPosljednjiID()+1;
		    				
		    				Trgovac novi_trg=new Trgovac(id_trgovac,korisnicko_trgovac,ime_trgovac,prezime_trgovac,lozinka_trgovac,pol_trgovac,
		    						telefon_trgovac,email_trgovac,id_prodajnoMjesto);
		    				
		
		    				PovezivanjeSaBazom.registracijaTrgovca(id_trgovac,korisnicko_trgovac,ime_trgovac,prezime_trgovac,lozinka_trgovac,pol_trgovac,telefon_trgovac, email_trgovac,id_prodajnoMjesto);
		    				obavjestenje.setText("Registracija novog trgovca je prihvacena!");
		    				
		    			});
		    			
		    			nazadd.setOnAction(a->{
		    				primaryStage.setScene(scene5);
		    			});
		    		});
		    		   
				   
				   
//dodavanje prodajnog mjesta ZAVRSENO
		    d3.setOnAction(e2->{
		    	
		    	VBox novoProdajnoMjesto=new VBox(15);
		    	novoProdajnoMjesto.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null, null)));
		    	
		    	Label dd=new Label("***DODAVANJE PRODAJNOG MJESTA***");
		    	Label taboglas=new Label();
		    	
		    	Label gradNovo=new Label("Grad:");
    			TextField unosGrada1=new TextField();
    			unosGrada1.setMaxWidth(170);
    			VBox gradBox1=new VBox(10);
    			gradBox1.getChildren().addAll(gradNovo,unosGrada1);
    			
    			Label drzavaNovo=new Label("Drzava:");
    			TextField unosDrzave1=new TextField();
    			unosDrzave1.setMaxWidth(170);
    			VBox drzavaBox1=new VBox(10);
    			drzavaBox1.getChildren().addAll(drzavaNovo,unosDrzave1);
    			
    			Label adresaNovo=new Label("Adresa:");
    			TextField unosAdrese1=new TextField();
    			unosAdrese1.setMaxWidth(170);
    			VBox adresaBox1=new VBox(10);
    			adresaBox1.getChildren().addAll(adresaNovo,unosAdrese1);
    			
    			Label telefonNovo=new Label("Telefon");
    			TextField unosTelefona1=new TextField();
    			unosTelefona1.setMaxWidth(170);
    			VBox telefonBox1=new VBox(10);
    			telefonBox1.getChildren().addAll(telefonNovo,unosTelefona1);
    			Button dodaj=new Button("Dodajte");
    			Button vratiSe=new Button("<-NAZAD");
    			novoProdajnoMjesto.getChildren().addAll(dd,taboglas,gradBox1,drzavaBox1,adresaBox1,telefonBox1,dodaj,vratiSe);
    			
    			vratiSe.setOnAction(e5->{
 				   primaryStage.setScene(scene5);
 				   primaryStage.show();});
 				   
    			//dodaj prodajno mjesto
 				  dodaj.setOnAction(e6->{
 					  
 					 if(unosGrada1.getText().isEmpty() || unosDrzave1.getText().isEmpty() ||
	    						unosAdrese1.getText().isEmpty() || unosTelefona1.getText().isEmpty()) 
	    					taboglas.setText("Nisu popunjena sva polja.Popunite sva polja.");
 					 else
 					 {
	    				
	    				String gradNovo1=unosGrada1.getText();
	    				String drzavaNovo1=unosDrzave1.getText();
	    				String adresaNovo1=unosAdrese1.getText();
	    				String telefonNovo1=unosTelefona1.getText();
	    				
	    				TreeMap<Integer,Trgovac> registrovaniTrgovci=Trgovac.getSpisakTrgovaca();
		    			int idNovo1=registrovaniTrgovci.lastKey()+1;
		    			
		    			
		    			PovezivanjeSaBazom.registracijaProdajnogMjesta(gradNovo1,drzavaNovo1,adresaNovo1,telefonNovo1);
	    			
		    			taboglas.setText("");
		    			taboglas.setText("Uspjesno ste se registrovali prodajno mjesto");
		    			
		    			unosGrada1.setText("");
		    			unosDrzave1.setText("");
		    			unosAdrese1.setText("");
		    			unosTelefona1.setText("");}
		    			
		    			});   
 				   
 				   
 				   
 			  
    			Scene scene6=new Scene(novoProdajnoMjesto,400,500);
 			   primaryStage.setScene(scene6);
		    	
		    });  
//dodavanje proizvoda	ZAVRSENO	    
d5.setOnAction(e5->{
		    	
		    	VBox NoviProizvod=new VBox(15);
		    	NoviProizvod.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null, null)));
		    	
		    	Label dd=new Label(  "***  DODAVANJE NOVOG PROIZVODA  *** ");
		    	Label taboglas=new Label();
		    	
		    	Label nazivNovo=new Label("Naziv");
    			TextField unosNaziva=new TextField();
    			unosNaziva.setMaxWidth(170);
    			VBox nazivBox1=new VBox(10);
    			nazivBox1.getChildren().addAll(nazivNovo,unosNaziva);
    			
    			Label opisNovo=new Label("Opis:");
    			TextField unosOpisa=new TextField();
    			unosOpisa.setMaxWidth(170);
    			VBox opisBox1=new VBox(10);
    			opisBox1.getChildren().addAll(opisNovo,unosOpisa);
    			
    			Label cijenaNovo=new Label("Cijena:");
    			TextField unosCijene=new TextField();
    			unosCijene.setMaxWidth(170);
    			VBox cijenaBox1=new VBox(10);
    			cijenaBox1.getChildren().addAll(cijenaNovo,unosCijene);
    			
    			
    			Button dodaj=new Button("Dodajte");
    			Button vratiSe=new Button("<-NAZAD");
    			NoviProizvod.getChildren().addAll(dd,taboglas,nazivBox1,opisBox1,cijenaBox1,dodaj,vratiSe);
    			
    			vratiSe.setOnAction(e6->{
 				   primaryStage.setScene(scene5);
 				   primaryStage.show();});
 				   
    			//dodaj proizvod
 				  dodaj.setOnAction(e6->{
 					  
 					 if(unosNaziva.getText().isEmpty() || unosCijene.getText().isEmpty()) 
	    					taboglas.setText("Nisu popunjena bitna polja (nije obavezan unos opisa)");
 					 else
 					 {
	    				
	    				String nazivProizvoda=unosNaziva.getText();
	    				String opisProizvoda=unosOpisa.getText();
	    				String cijenaP=unosCijene.getText();
	    				float cijenaProizvoda=0;
	    				try{cijenaProizvoda=Float.parseFloat(cijenaP);}
	    				catch(Exception a){
	    					taboglas.setText("Nije dobar format cijene");
	    				}
	    				

		    			
		    			PovezivanjeSaBazom.registracijaProizvoda(nazivProizvoda,opisProizvoda,cijenaProizvoda);
	    			
		    			taboglas.setText("");
		    			taboglas.setText("Uspjesno ste se registrovali novi proizvod");
		    			
		    			unosNaziva.setText("");
		    			unosOpisa.setText("");
		    			unosCijene.setText("");
		    			}
		    			
		    			});   
 				   
 				   
 				   
 			  
    			Scene scene7=new Scene(NoviProizvod,400,500);
 			   primaryStage.setScene(scene7);
		    	
		    }); 

//azuriranjeProizvoda-----zavrseno
d6.setOnAction(e5->{
	VBox azuriranje=new VBox(20);
	azuriranje.setBackground(new Background(new BackgroundFill(Color.rgb(0,193, 233),null, null)));
	Label pocetak=new Label("***AZURIRANJE PROIZVODA***");
	Label oglasi=new Label();
	Label poc=new Label("Izaberite proizvod:");
	 TableView tabela5=new TableView();
	   
	   TableColumn <Map,String > kol1 = new TableColumn<>("NAZIV");
	   kol1.setCellValueFactory(new MapValueFactory<>("naziv"));
      TableColumn<Map,String>  kol2=new TableColumn<>("OPIS");
      kol2.setCellValueFactory(new MapValueFactory<>("opis_artikla"));
      TableColumn<Map,String>  kol3=new TableColumn<>("CIJENA");
      kol3.setCellValueFactory(new MapValueFactory<>("cijena_artikla"));
      
     
	   tabela5.getColumns().addAll(kol1,kol2,kol3);
	   //****
	   PovezivanjeSaBazom.bazaProizvod();
	   TreeMap<Integer,Proizvod> proizvodi=Proizvod.getProizvodi();
	   
	   ObservableList<Map<String,Object>> lista5=FXCollections.<Map<String,Object>> observableArrayList();
		for(Proizvod pr: proizvodi.values()) {
				Map<String,Object>item=new HashMap<>();
				item.put("naziv",pr.getNaziv());
				item.put("opis_artikla",pr.getOpis());
				item.put("cijena_artikla",pr.getCijena());
				item.put("id",pr.getID());
				lista5.add(item);}
				tabela5.getItems().addAll(lista5);
				

    	Label pNaziv=new Label("Promijenite naziv");
		TextField unosNazivaNovog=new TextField();
		unosNazivaNovog.setMaxWidth(170);
		HBox nazivNoviBox1=new HBox(10);
		nazivNoviBox1.getChildren().addAll(pNaziv,unosNazivaNovog);
		
		Label pOpis=new Label("Promijenite opis");
		TextField unosOpisaNovog=new TextField();
		unosOpisaNovog.setMaxWidth(170);
		HBox opisNoviBox1=new HBox(10);
		opisNoviBox1.getChildren().addAll(pOpis,unosOpisaNovog);
		
		
		Label pCijena=new Label("Promijenite cijenu");
		TextField unosCijeneNove=new TextField();
		unosCijeneNove.setMaxWidth(170);
		HBox cijenaNoviBox1=new HBox(10);
		cijenaNoviBox1.getChildren().addAll(pCijena,unosCijeneNove);
		
		Button azuriraj=new Button("Azurirajte/Sacuvajte izmjene");
		Button vracanje=new Button("<-NAZAD");
		
		
		
		
				azuriranje.getChildren().addAll(pocetak,poc,tabela5,nazivNoviBox1,opisNoviBox1,cijenaNoviBox1,azuriraj,vracanje,oglasi);
				Scene scene8=new Scene(azuriranje,600,800);
				primaryStage.setScene(scene8);
				primaryStage.show();
			
				vracanje.setOnAction(e8->{
	 				   primaryStage.setScene(scene5);
	 				   primaryStage.show();});
				
				azuriraj.setOnAction(e9->{
					oglasi.setText("");
					Map<String,Object> oznaceni=(HashMap<String,Object>)tabela5.getSelectionModel().getSelectedItem();
					
					if(oznaceni==null) {
						oglas.setText("Niste oznacili proizvod koji zelite azurirati!");
					}
					
					
					if(unosNazivaNovog.getText().isEmpty() && unosOpisaNovog.getText().isEmpty() && unosCijeneNove.getText().isEmpty()) {
						
						oglas.setText("Niste nista unijeli kao promjenu!");
						return;
					}
					int prodID=(int)oznaceni.get("id");
					Proizvod p=proizvodi.get(prodID);
					
					//String nazivv=unosNazivaNovog.getText();
					//String opiss=unosOpisaNovog.getText();
					//String cijenaa=unosCijeneNove.getText();
					/*float cijena=0;
					try{
						cijena=Float.parseFloat(cijenaa);
					}catch(Exception f){
						oglasi.setText("Cijena nije u odgovarajucem formatu");
					}*/
					//PovezivanjeSaBazom.azuriranjeProizvoda(nazivv, opiss, cijena);
					String naziv1=""; String opis1=""; float cijena1=0;
					if(!unosNazivaNovog.getText().isEmpty()) {
						naziv1=unosNazivaNovog.getText();
						PovezivanjeSaBazom.updateProizvod(p, naziv1, "naziv");
					}
					if(!unosOpisaNovog.getText().isEmpty()) {
						opis1=unosOpisaNovog.getText();
						PovezivanjeSaBazom.updateProizvod(p, opis1, "opis");
					}
					if(!unosCijeneNove.getText().isEmpty()) {
						try {
						cijena1=Float.parseFloat(unosCijeneNove.getText());
						}catch(Exception x) {
							oglasi.setManaged(true);
							oglasi.setVisible(true);
							oglasi.setText("Cijena nije validna!");
							return;
						}
						PovezivanjeSaBazom.updateProizvod(p, cijena1, "cijena");
					}
					
					
					oglas.setText("Proizvod je azuriran");
					unosNazivaNovog.setText(" ");
					unosOpisaNovog.setText(" ");
					unosCijeneNove.setText(" ");
					});
				
	
});
    
	}   }); }
	public static void main(String []args){
		launch(args);
	}
	
}
