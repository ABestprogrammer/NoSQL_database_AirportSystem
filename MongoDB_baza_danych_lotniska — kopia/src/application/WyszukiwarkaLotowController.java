package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.DatePicker;

import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.*;

//import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import java.util.List;
import org.bson.conversions.Bson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class WyszukiwarkaLotowController {
	MongoClient mongoClient;
	MongoDatabase database;
	
	private String S,S1,S2,S3;
	private String flagAction;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Tab tab_pracownik;
    
    @FXML
    private Tab tab_pasazer;
    
    @FXML
    private TextArea text1;
    
    @FXML
    private ImageView airplane_picture;

    @FXML
    private Button Btn_go_;

    @FXML
    private Button Btn_exit;

    @FXML
    private Label Label1;

    @FXML
    private MenuButton Btn_pracownik;

    @FXML
    private TextField Text2_pracownik;
    
    @FXML
    private TextField Text2_pasazer;

    @FXML
    private Button Btn2_pracownik;

    @FXML
    private DatePicker Data2_pracownik;

    @FXML
    private Label Label2_pracownik;

    @FXML
    private MenuButton Btn_wybierz2;

    @FXML
    private TextArea text2;
    
    @FXML
    private DatePicker Data2_pasazer;

    @FXML
    private Button Btn2_pasazer;

    @FXML
    private Label Label2;
    
    @FXML
    private Label Label2_pasazer;
    

    @FXML
    private Label Label22_pasazer;
    
    @FXML
    private Label Label_222_pasazer;

    @FXML
    private DatePicker Data22_pasazer;

    @FXML
    void Btn_pracownik_action(ActionEvent event) {

    }

    @FXML
    void Btn_wybierz2_action(ActionEvent event) {
    	
    }
    @FXML
    void Data2_pracownik_action(ActionEvent event) {

    }
    
    @FXML
    void Data2_pasazer_action(ActionEvent event) {

    }

    @FXML
    void Text2_pracownik_action(ActionEvent event) {

    }
  //-----------------------------------------------------------------------------    
    @FXML
    void Pracownik_wyszukaj_pracownika(ActionEvent event) {
    	flagAction="pracownik_wg_nazwiska";
    	Label2.setText("Wyszukiwanie danych o pracownikach wg. nazwiska");
    	Label2_pracownik.setVisible(true);
    	Label2_pracownik.setText("Podaj nazwisko");
    	Text2_pracownik.setVisible(true);
    	Text2_pracownik.setText("");
    	Btn2_pracownik.setVisible(true);
    	Data2_pracownik.setVisible(false);
    	text1.setText("");
    	
    }
    
    //-----------------------------------------------------------------------------
    @FXML
    void Pracownik_wyszukaj_prac_wg_stanowiska(ActionEvent event) {
    	flagAction="pracownik_wg_stanowiska";
    	Label2.setText("Wyszukiwanie danych o pracownikach wg. stanowiska");
    	Label2_pracownik.setVisible(true);
    	Label2_pracownik.setText("Podaj stanowisko");
    	Text2_pracownik.setVisible(true);
    	Text2_pracownik.setText("");
    	Btn2_pracownik.setVisible(true);
    	Data2_pracownik.setVisible(false);
    	text1.setText("");
    }
    //-----------------------------------------------------------------------------
    @FXML
    void Pracownik_wyszukaj_prac_wg_daty_zatr(ActionEvent event) {
    	flagAction="pracownik_wg_daty_zatr";
    	Label2.setText("Wyszukiwanie danych o pracownikach wg. daty zatrudnienia");
    	Label2_pracownik.setVisible(true);
    	Label2_pracownik.setText("Podaj datê");
    	Text2_pracownik.setVisible(false);
    	//Text2_pracownik.setText("");
    	Data2_pracownik.setVisible(true);
    	Btn2_pracownik.setVisible(true);
    	text1.setText("");

    }
    //-----------------------------------------------------------------------------    
    Calendar dateCal ( int year, String month, int day){
      
      Calendar cal = Calendar.getInstance();
      
      //ustawienie roku
      cal.set(Calendar.YEAR, year);
      
      //ustawienie miesiaca
      
      if(month.equals("JANUARY")) { cal.set(Calendar.MONTH, Calendar.JANUARY); }
      else if(month.equals("FEBRUARY")) { cal.set(Calendar.MONTH, Calendar.FEBRUARY); }
      else if(month.equals("MARCH")) { cal.set(Calendar.MONTH, Calendar.MARCH); }
      else if(month.equals("APRIL")) { cal.set(Calendar.MONTH, Calendar.APRIL); }
      else if(month.equals("MAY")) { cal.set(Calendar.MONTH, Calendar.MAY); }
      else if(month.equals("JUNE")) { cal.set(Calendar.MONTH, Calendar.JUNE); }
      else if(month.equals("JULY")) { cal.set(Calendar.MONTH, Calendar.JULY); }
      else if(month.equals("AUGUST")) { cal.set(Calendar.MONTH, Calendar.AUGUST); }
      else if(month.equals("SEPTEMBER")) { cal.set(Calendar.MONTH, Calendar.SEPTEMBER); }
      else if(month.equals("OCTOBER")) { cal.set(Calendar.MONTH, Calendar.OCTOBER); }      
      else if(month.equals("NOVEMBER")) { cal.set(Calendar.MONTH, Calendar.NOVEMBER); }
      else if(month.equals("DECEMBER")) { cal.set(Calendar.MONTH, Calendar.DECEMBER); }
      
      //ustawienie dnia
      cal.set(Calendar.DAY_OF_MONTH, day);
	
    return cal;
    }
    
    //-----------------------------------------------------------------------------    
    //PRACOWNIK OK BTN
    @FXML
    void Btn2_pracownik_action(ActionEvent event) {
    	
//    	//Connecting With Server
//		MongoClient mongoClient = new MongoClient("localhost",27017);
//	    MongoDatabase database = mongoClient.getDatabase("baza_danych_lotniska");
    	
    	S1="";
    	//-------------------------------------------------
    	if(flagAction.equals("pracownik_wg_nazwiska")) {
	    	S = Text2_pracownik.getText();
		    
		    MongoCollection<Document> Pracownik = database.getCollection("Pracownik");
		    FindIterable<Document> findIterable = Pracownik.find(
		                		eq("Nazwisko",S)
		        ).projection(
		                fields(
		                        include(
		                        		"Imie","Nazwisko","Stanowisko","Data_zatrudnienia"
		                        ),
		                        excludeId()
		                )
		    );
    	
		    MongoCursor<Document> cursor1 = findIterable.cursor();
    		S1="";
		    while (cursor1.hasNext()) {
		    	S1 += cursor1.next().toString() + "\n";
		    }
	    
		    if(S1.equals("")){ S1 = "brak pracownika o podanym nazwisku"; }
    		cursor1.close();
    	}
    	//-------------------------------------------------
    	else if(flagAction.equals("pracownik_wg_stanowiska")){
    		
    		// wyœwietl dane wszystkich pracowników o podanym stanowisku
    		//db.zaloga.find({funkcja: /^stewar/});
    			    
    		S="";
	    	S = Text2_pracownik.getText();      
    		MongoCollection<Document> Pracownik = database.getCollection("Pracownik");
    		FindIterable<Document> findIterable = Pracownik.find(
    		      		eq("Stanowisko",S)
    		).projection(
    		      fields(
    		              include(
    		              		"Stanowisko", "Imie", "Nazwisko", "Data_zatrudnienia"
    		              ),
    		              excludeId()
    		      )
    		);	        

		    MongoCursor<Document> cursor1 = findIterable.cursor();
    		S1="";
    		while (cursor1.hasNext()) {
    			    	S1 += cursor1.next().toString() + "\n";
    		}
    			    
    		if(S1.equals("")){ S1 = "brak pracownika o podanym stanowisku"; }
    		cursor1.close();
    	}
    	//-------------------------------------------------
    	else if(flagAction.equals("pracownik_wg_daty_zatr")){
    		String month = Data2_pracownik.getValue().getMonth().toString();
    		int day = Data2_pracownik.getValue().getDayOfMonth();
    		int year = Data2_pracownik.getValue().getYear();        
          
          S1=""; S="";
		  MongoCollection<Document> Pracownik = database.getCollection("Pracownik");
		  
	      FindIterable<Document> findIterable = Pracownik.find(
	      		gt("Data_zatrudnienia", dateCal(year,month,day).getTime())
	      ).projection(
	      fields(
	              include(
	                      //"id_lotniska_wylotu", "id_lotniska_przylotu", "czas_wylotu"
	              		//"id_lotniska_wylotu"
	              		"Stanowisko", "Imie", "Nazwisko", "Data_zatrudnienia"
	              ),
	              excludeId()
	      )
	);	        

	      
		    MongoCursor<Document> cursor1 = findIterable.cursor();
	  		S1="";
	  		while (cursor1.hasNext()) {
	  			    	S1 += cursor1.next().toString() + "\n";
	  		}
	  			    
	  		if(S1.equals("")){ S1 = "brak pracownika zatrudnionego po wybranej dacie"; }
	  		cursor1.close();  
    		
    		
    	}
		//-------------------------------------------------
    	
			text1.setText(S1);
    	
    }
    
    //-----------------------------------------------------------------------------    
    //PASAZER OK BTN
    
    @FXML
    void Btn2_pasazer_action(ActionEvent event) {
  	
    	S1="";
    	//-------------------------------------------------
    	if(flagAction.equals("pasazer_wyszukaj_lotnisk")) {
	    	S = Text2_pasazer.getText();
		    
		    MongoCollection<Document> Lotnisko = database.getCollection("Lotnisko");
		    FindIterable<Document> findIterable = Lotnisko.find(
		                		eq("kraj",S)
		        ).projection(
		                fields(
		                        include(
		                        		"Miasto","typ"
		                        ),
		                        excludeId()
		                )
		    );
    	
		    MongoCursor<Document> cursor2 = findIterable.cursor();
    		S1="";
		    while (cursor2.hasNext()) {
		    	S1 += cursor2.next().toString() + "\n";
		    }
	    
		    if(S1.equals("")){ S1 = "brak lotniska w podanym kraju"; }
    		cursor2.close();
    	}
//    	//-------------------------------------------------
    	else if(flagAction.equals("pasazer_wyszukaj_lot")){
			String month1 = Data2_pasazer.getValue().getMonth().toString();
			int day1 = Data2_pasazer.getValue().getDayOfMonth();
			int year1 = Data2_pasazer.getValue().getYear();        
	      
			String month2 = Data22_pasazer.getValue().getMonth().toString();
			int day2 = Data22_pasazer.getValue().getDayOfMonth();
			int year2 = Data22_pasazer.getValue().getYear();        
	
			S1="";S="";
		  MongoCollection<Document> Lot = database.getCollection("Lot");
		  
	      FindIterable<Document> findIterable = Lot.find(
	    		and(
	    				gt("czas_wylotu", dateCal(year1,month1,day1).getTime()),
	    				lt("czas_wylotu", dateCal(year2,month2,day2).getTime())
	      		)
	      ).projection(
	      fields(
	              include(
	              		"id_lotniska_przylotu", "id_lotniska_wylotu", "czas_wylotu", "czas_przylotu"
	              ),
	              excludeId()
	      )
	      );	        
	      
		    MongoCursor<Document> cursor2 = findIterable.cursor();
	  		S1="";
	  		while (cursor2.hasNext()) {
	  			    	S1 += cursor2.next().toString() + "\n";
	  		}
	  			    
	  		if(S1.equals("")){ S1 = "brak lotu o podanym zakresie czasowym"; }
	  		cursor2.close();  
    	}  		
		
  	//-------------------------------------------------
    	
    	else if(flagAction.equals("pasazer_wyszukaj_przywilejow")){
//    		
//    			    
//    		S=""; S1="";
//    	    	//S = Text2_pasazer.getText();
//    		    
//    		    MongoCollection<Document> Pasazer = database.getCollection("Pasazer");
//    		    FindIterable<Document> findIterable = Pasazer.find(
//    		                		//eq("kraj",S)
//    		        ).projection(
//    		                fields(
//    		                        include(
//    		                        		"Przywilej"
//    		                        ),
//    		                        excludeId()
//    		                )
//    		    );
//        	
//    		    MongoCursor<Document> cursor2 = findIterable.cursor();
//        		S1="";
//    		    while (cursor2.hasNext()) {
//    		    	S1 += cursor2.next().toString() + "\n";
//    		    }
//    	    
//    		    if(S1.equals("")){ S1 = "brak dostêpnych przywilejów"; }
//        		cursor2.close();
//        	}
    	   	
    	//zlicz ile pasazerow posiada poszczegolne przywileje
        MongoCollection<Document> collection = database.getCollection("Pasazer");
        AggregateIterable<Document> aggregate = collection.aggregate(
                Arrays.asList(
                        match(
                                exists("Przywilej", true)
                        ),
                        group(
                                "$Przywilej", Accumulators.sum("count", 1)
                        )
                )
        );

        
      MongoCursor<Document>cursor = aggregate.cursor();
      while (cursor.hasNext()) {
    	  S1 += cursor.next().toString() + "\n";
      }
      if(S1.equals("")){ S1 = "brak przywilejów"; }
      cursor.close(); 
 
        }
    	

    	//-------------------------------------------------
//    	else if(flagAction.equals("pracownik_wg_daty_zatr")){
//    		String month = Data2_pracownik.getValue().getMonth().toString();
//    		int day = Data2_pracownik.getValue().getDayOfMonth();
//    		int year = Data2_pracownik.getValue().getYear();        
//          
//          S1="";S="";
//		  MongoCollection<Document> Lot = database.getCollection("Lot");
//		  
//	      FindIterable<Document> findIterable = Lot.find(
//	      		gt("Data_zatrudnienia", dateCal(year,month,day).getTime())
//	      ).projection(
//	      fields(
//	              include(
//	                      //"id_lotniska_wylotu", "id_lotniska_przylotu", "czas_wylotu"
//	              		//"id_lotniska_wylotu"
//	              		"Stanowisko", "Imie", "Nazwisko", "Data_zatrudnienia"
//	              ),
//	              excludeId()
//	      )
//	);	        
//
//	      
//		    MongoCursor<Document> cursor1 = findIterable.cursor();
//	  		S1="";
//	  		while (cursor1.hasNext()) {
//	  			    	S1 += cursor1.next().toString() + "\n";
//	  		}
//	  			    
//	  		if(S1.equals("")){ S1 = "brak pracownika zatrudnionego po wybranej dacie"; }
//	  		cursor1.close();  
//    		
//    		
//    	}
		//-------------------------------------------------
    	
			text2.setText(S1);   	
    	
    }     
    
    
    
    
    //-----------------------------------------------------------------------------    
    
    @FXML
    void Pasazer_wyszukaj_lotnisk_action(ActionEvent event) {
    	flagAction="pasazer_wyszukaj_lotnisk";
    	Label2.setText("Wyszukiwanie nazw miast w jakich znajduj¹ siê lotniska w poszczególnych pañstwach ");
    	Label2_pasazer.setVisible(true);
    	Label2_pasazer.setText("nazwa pañstwa:");
    	Text2_pasazer.setVisible(true);
    	Text2_pasazer.setText("");
    	Data2_pasazer.setVisible(false);
    	Btn2_pasazer.setVisible(true);
    	text2.setText("");
    	Label_222_pasazer.setVisible(false);

    }
    //-----------------------------------------------------------------------------  


    @FXML
    void Pasazer_wyszukaj_lotu_action(ActionEvent event) {
    	flagAction="pasazer_wyszukaj_lot";
    	Label2.setText("Wyszukiwanie danych o lotach które odbêd¹ siê w ramach czasowych okreœlonych przez u¿ytkownika");
    	Label2_pasazer.setVisible(true);
    	Label2_pasazer.setText("od:");
    	Label22_pasazer.setText("do:");
    	Text2_pasazer.setVisible(false);
    	Label22_pasazer.setVisible(true);
    	//Text2_pracownik.setText("");
    	Data2_pasazer.setVisible(true);
    	Data22_pasazer.setVisible(true);
    	Btn2_pasazer.setVisible(true);
    	text2.setText("");
    	Label_222_pasazer.setVisible(false);

    }
    //-----------------------------------------------------------------------------    

    @FXML
    void Pasazer_wyszukaj_przywilejow_action(ActionEvent event) {
    	flagAction="pasazer_wyszukaj_przywilejow";
    	Label2.setText("Wyszukiwanie mo¿liwych przywilejów dla pasa¿erów oraz wyswietlenie liczby pasa¿erów, którzy je posiadaj¹ ");
    	Label2_pasazer.setVisible(false);
    	//Label2_pasazer.setText("nazwa pañstwa:");
    	Text2_pasazer.setVisible(false);
    	Text2_pasazer.setText("");
    	Data2_pasazer.setVisible(false);
    	Btn2_pasazer.setVisible(true);
    	text2.setText("");
    	Label22_pasazer.setVisible(false);
    	Data22_pasazer.setVisible(false);
    	Label_222_pasazer.setVisible(true);
    	Label_222_pasazer.setText("wyszukaj dostêpnych przywilejów dla pasazera");

    }    
    
    //-----------------------------------------------------------------------------    
    @FXML
    void action_exit_application(ActionEvent event) {
    	Main.setRoot("App.fxml");
    }

    //-----------------------------------------------------------------------------    
    @FXML
    void action_go_to_app_stage(MouseEvent event) {
    	Main.setRoot("App.fxml");
    }

  //-----------------------------------------------------------------------------    
    @FXML
    void action_go_to_search_stage(ActionEvent event) {

    }

  //-----------------------------------------------------------------------------    
    @FXML
    void wyszukaj_lotnisk(ActionEvent event) {

    }

  //-----------------------------------------------------------------------------    
    @FXML
    void initialize() {
    	
    	//Connecting With Server
		mongoClient = new MongoClient("localhost",27017);
	    database = mongoClient.getDatabase("baza_danych_lotniska");

    	
    	S=""; S1=""; S2=""; S3="";
    	flagAction="";
    	Label1.setText("Wyszukiwarka dla pracownika i pasa¿era");
    	Label2.setText("");
    	Label2_pracownik.setVisible(false);
    	Text2_pracownik.setVisible(false);
    	Btn2_pracownik.setVisible(false);
    	Data2_pracownik.setVisible(false);
    	
    	Data2_pasazer.setVisible(false);
    	Data22_pasazer.setVisible(false);
    	Btn2_pasazer.setVisible(false);
    	Text2_pasazer.setVisible(false);
    	Label2_pasazer.setVisible(false);
    	Label22_pasazer.setVisible(false);
    	Label_222_pasazer.setVisible(false);
    }
}
