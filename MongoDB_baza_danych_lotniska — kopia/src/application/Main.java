package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Scene scene;
	
	@Override
	public void start(Stage stage) throws IOException {
		try {
			scene = new Scene(loadFXML("App.fxml"));
			stage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Parent loadFXML(String fxml) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
		
		return fxmlLoader.load();
	}
	
	public static void setRoot(String fxml) {
		try {
			scene.setRoot(loadFXML(fxml));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
