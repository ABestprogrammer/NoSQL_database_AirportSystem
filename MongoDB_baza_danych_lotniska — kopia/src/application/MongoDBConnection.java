package application;

////import java.util.ArrayList;
////import java.util.Arrays;
////import java.util.Calendar;
////import java.util.Date;
//import java.util.*;
//import java.text.*;
//
//import org.bson.Document;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.Block;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//import com.mongodb.MongoClient;
//import com.mongodb.client.AggregateIterable;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Accumulators;
//import com.mongodb.client.model.Aggregates;
//import com.mongodb.client.model.BsonField;
//import com.mongodb.client.model.Filters;
import com.mongodb.*;
import com.mongodb.client.*;
//import com.mongodb.client.MongoClient;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.mongodb.client.model.Accumulators.first;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static java.util.Arrays.asList;

public class MongoDBConnection {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//    	//Connecting With Server Please add the external jar file first
//    	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//    	System.out.println("server connection successfully done");
//    	
////    	DB database = mongoClient.getDB("baza_danych_lotniska");
//    	
//        //MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase database = mongoClient.getDatabase("baza_danych_lotniska");
//        
//        System.out.println(database.getName());
//        
//        MongoCollection<Document> Lot = database.getCollection("Lot");
//        
//        AggregateIterable<Document> aggregate = Lot.aggregate(
//        		asList(
//        				Aggregates.lookup("miasto", "id_lotniska","czas_wylotu", "x")
//        				));
//        
//        String S="";
//        while (cursor.hasNext()) {
//    //DZIALA ALE ZLE    	
//        	Document d =cursor.next();
//        	S+=String.valueOf(d.get("kraj"))+"\n";
//        }
//        	text2.setText(S);		
		

		
		
		//Connecting With Server
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		System.out.println("server connection successfully done");
		
	    MongoDatabase database = mongoClient.getDatabase("baza_danych_lotniska");
	    
	    System.out.println(database.getName());
	    
	    
	    
	    
//	    MongoCollection<Document> collection = database.getCollection("Lotnisko");
	    
//	    MongoCursor<Document> cursor = Lotnisko.find().cursor();
//	    
//	    String S="";
//	    while (cursor.hasNext()) {
//	//DZIALA ALE ZLE    	
//	    	//Document d =cursor.next();
//	    	//S+=String.valueOf(d.get("kraj"))+"\n";
//	    	System.out.println(cursor.next());
//	    }


//--------------------------------------------------------------------------------------
	    //zlaczone tablice gzie imie uzytkownika jest 
//	    MongoCollection<Document> collection = database.getCollection("Uzytkownik");
//
//	    AggregateIterable<Document> aggregate = collection.aggregate(Arrays.asList(
//	    		Aggregates.lookup("Pracownik", "stanowisko": pilot,"Id_uzytkownika" ,"name")
//
//	            ));
//
//MongoCursor<Document> cursor = aggregate.cursor();

//while(cursor.hasNext()){System.out.println(cursor.next());}
//--------------------------------------------------------------------------------------
	    
//NW	    
//        MongoCollection<Document> Lot = database.getCollection("Lot");
//
//        AggregateIterable<Document> aggregate = Lot.aggregate(
//                Arrays.asList(
//                        Aggregates.lookup("miasto", "id_lotniska", "ObjectId", "m")
//                )
//        );
//
//        MongoCursor<Document> cursor = aggregate.cursor();
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//--------------------------------------------------------------------------------------	
	    //GOOD
	    String S1="",S2="",S3="",S4="";
//	    MongoCollection<Document> Lot = database.getCollection("Lot");
//
//	    MongoCursor<Document> cursor = Lot.find().cursor();
//        while (cursor.hasNext()) {
//        	S1="";
//        	//DBObject document = cursor.next();
//        	//S2=cursor.next().get("czas_przylotu").toString();
//        	S1=cursor.next().get("id_lotniska_wylotu").toString();
//        	//S2=cursor.next().get("czas_przylotu").toString();
//        	
//        	//S1=(String) cursor.next().get("id_lotniska_wylotu");
//        	System.out.println(S1);//+", "+S2);
//            //System.out.println(cursor.next());
//        }
//        cursor.close();
        
	    
	    
	    
//        S1=""; S2="";
//        
//	    MongoCollection<Document> Lot = database.getCollection("Lot");
//	    
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR, 2020);
//        cal.set(Calendar.MONTH, Calendar.MARCH);
//        cal.set(Calendar.DAY_OF_MONTH, 20);
//        Date from = cal.getTime();
//
//        cal.set(Calendar.YEAR, 2020);
//        cal.set(Calendar.MONTH, Calendar.DECEMBER);
//        cal.set(Calendar.DAY_OF_MONTH, 31);
//        Date to = cal.getTime();
//	    
//	    
//        FindIterable<Document> findIterable = Lot.find(
//                and(
//                        gt("czas_wylotu", from),
//                        lt("czas_przylotu", to)
//                )
//        ).projection(
//                fields(
//                        include(
//                                //"id_lotniska_wylotu", "id_lotniska_przylotu", "czas_wylotu"
//                        		"id_lotniska_wylotu"
//                        ),
//                        excludeId()
//                )
//        );
	    
	    
	    
	    
	    

//	    
//        S1=""; S2="";
//        
//	    MongoCollection<Document> Pracownik = database.getCollection("Pracownik");
	    
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR, 2020);
//        cal.set(Calendar.MONTH, Calendar.MARCH);
//        cal.set(Calendar.DAY_OF_MONTH, 20);
//        Date from = cal.getTime();
//
//        cal.set(Calendar.YEAR, 2020);
//        cal.set(Calendar.MONTH, Calendar.DECEMBER);
//        cal.set(Calendar.DAY_OF_MONTH, 31);
//        Date to = cal.getTime();
	    
//**************************************************************************************	    
//        FindIterable<Document> findIterable = Pracownik.find(
//                //and(
//                        //gt("czas_wylotu", from),
//                        //lt("czas_przylotu", to)
//                		eq("Stanowisko","pilot")//"Stanowisko"=="pilot"
//                //)
//        ).projection(
//                fields(
//                        include(
//                                //"id_lotniska_wylotu", "id_lotniska_przylotu", "czas_wylotu"
//                        		//"id_lotniska_wylotu"
//                        		"Stanowisko", "id_pracownika"
//                        ),
//                        excludeId()
//                )
//        );	    
//	    
//**************************************************************************************	    


//        MongoCollection<Document> collection = database.getCollection("Pracownik");
//        AggregateIterable<Document> aggregate = collection.aggregate(
//                Arrays.asList(
//                        match(
//                                exists("sprzataczka", true)
//                        ),
//                        group(
//                                "$liniaLotnicza", Accumulators.sum("count", 1)
//                        )
//                )
//        );


//        cursor = aggregate.cursor();
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());        
        
	    
	    
	    
	    
	    
	    //BasicDBObject query = new BasicDBObject("Miasto","Monachium");
	    //BasicDBObject query = new BasicDBObject();
	    //query.put("kraj","Niemcy");
	    //query.put("Miasto","Monachium");
	    
	    //MongoCursor<Document> cursor1 = Lotnisko.find(query).cursor();
	    
	    
	    //DBObject record = Lotnisko.findOne(new BasicDBObject("kraj","Polska"));
	    
	    //MongoCollection<Document> coll;
		//DBCursor cursor2 = coll.find(query);
	    //cursor1 = Lotnisko.find(query);
	    
	    //S1 = cursor1.next().get("kraj").toString();
	    //S2 = cursor1.next().get("Miasto").toString();
	    //System.out.println(S1+", "+S2);
	    //MongoCursor<Document> cursor2 = findIterable.iterator();
//**************************************************************************************	    
	    
//	    MongoCursor<Document> cursor1 = findIterable.cursor();
//	    
//	    while (cursor1.hasNext()) {
//	    	//S1 = cursor1.next().get("id_lotniska_wylotu").toString();
//            //System.out.println(S1);
//	    	System.out.println(cursor1.next());
//	    	
//        }
//	    cursor1.close();
        
//**************************************************************************************	    
	    
	    
//        while (cursor1.hasNext()) {
//        	S3=""; S4="";
//        	//DBObject document = cursor.next();
//        	S4=cursor1.next().get("id_lotniska").toString();
//        	S4=cursor.next().get("kraj").toString();
//        	//S2=cursor.next().get("czas_przylotu").toString();
//        	
//        	//S1=(String) cursor.next().get("id_lotniska_wylotu");
//        	System.out.println(S3+", "+S4);
//            //System.out.println(cursor.next());
//        }        
//        
        
        
       
//**************************************************************************************	    

 
////zlicz ile pasazerow posiada poszczegolne przywileje
//        MongoCollection<Document> collection = database.getCollection("Pasazer");
//        AggregateIterable<Document> aggregate = collection.aggregate(
//                Arrays.asList(
//                        match(
//                                exists("Przywilej", true)
//                        ),
//                        group(
//                                "$Przywilej", Accumulators.sum("count", 1)
//                        )
//                )
//        );
//
//
//        MongoCursor<Document>cursor = aggregate.cursor();
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
        
//**************************************************************************************	
//	    > wyœwietl dane wszystkich stewardess i stewardów z za³ogi
//
//	    db.zaloga.find({funkcja: /^stewar/});
	    
      S1=""; S2="";
      
	  MongoCollection<Document> Pracownik = database.getCollection("Pracownik");
	  
      FindIterable<Document> findIterable = Pracownik.find(
      or(
      		eq("Stanowisko","stewardessa"),eq("Stanowisko","steward")
      )
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
	    
	    while (cursor1.hasNext()) {
	    	//S1 = cursor1.next().get("id_lotniska_wylotu").toString();
            //System.out.println(S1);
	    	System.out.println(cursor1.next());
	    	
        }
	    cursor1.close();	    
//**************************************************************************************	
//NIE DZIALA
////> wyœwietl wszystkie dane pracowników, którzy zostali zatrudnieni po dacie: '2017-04-03'
//	      
//		  MongoCollection<Document> Pracownik = database.getCollection("Pracownik");
//		  
//	      FindIterable<Document> findIterable = Pracownik.find(
//	      or(
//	      		gt("Data_zatrudnienia","2017-04-03T22:00:00Z")
//	      )
//	).projection(
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
//		    MongoCursor<Document> cursor1 = findIterable.cursor();
//		    
//		    while (cursor1.hasNext()) {
//		    	//S1 = cursor1.next().get("id_lotniska_wylotu").toString();
//	            //System.out.println(S1);
//		    	System.out.println(cursor1.next());
//		    	
//	        }
//		    cursor1.close();	    
//**************************************************************************************	
	    
	    
}

}


