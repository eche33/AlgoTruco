package application;
	
import Vista.MainApp;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setResizable(false);
		MainApp main = new MainApp();
		main.start(primaryStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
