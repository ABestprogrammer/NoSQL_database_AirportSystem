package application;

import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoDatabase;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Btn_go_;

    @FXML
    private Button Btn_exit;

    @FXML
    void action_exit_application(ActionEvent event) {
    	Platform.exit();
    	//Btn_exit.setOnAction(e -> Platform.exit());
    }

    @FXML
    void action_go_to_search_stage(ActionEvent event) {
    	Main.setRoot("WyszukiwarkaLotow.fxml");
//    	
////		//Connecting With Server Please add the external jar file first
//		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
////		System.out.println("server connection successfully done");
////		
////		DB database = mongoClient.getDB("baza_danych_lotniska");
//		
//        //MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase database = mongoClient.getDatabase("baza_danych_lotniska");
//        
//        System.out.println(database.getName());
//        
//        MongoCollection<Document> Lotnisko = database.getCollection("Lotnisko");
//        
//        MongoCursor<Document> cursor = Lotnisko.find().cursor();
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//        
        
        
    }

    @FXML
    void initialize() {
    }
}

