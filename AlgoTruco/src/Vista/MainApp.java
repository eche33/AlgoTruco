package Vista;

import java.io.IOException;

import AlgoTrucoClases.Partida;
import application.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    /**
     *
     */
    public static Partida partida;
    public static Stage primaryStage;
    public static String pantallaInicial = "PantallaInicial";
    public static String pantallaInicialFile = "PantallaInicial.fxml";
    public static String pantalla1vs1 = "Pantalla1vs1";
    public static String pantalla1vs1File = "Pantalla1vs1.fxml";
    public static String pantalla1vsPC = "Pantalla1vsPC";
    public static String pantalla1vsPCFile = "Pantalla1vsPC.fxml";
    public static String pantalla2vs2 = "pantalla2vs2";
    public static String pantalla2vs2File = "Pantalla2vs2.fxml";
    public static String pantalla3vs3 = "pantalla3vs3";
    public static String pantalla3vs3File = "Pantalla3vs3.fxml";
    

    
    
    @Override
    public void start(Stage primaryStage) {
        
        MainApp.primaryStage = primaryStage;
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(MainApp.pantallaInicial, MainApp.pantallaInicialFile);
        mainContainer.loadScreen(MainApp.pantalla1vs1, MainApp.pantalla1vs1File);
        mainContainer.loadScreen(MainApp.pantalla1vsPC, MainApp.pantalla1vsPCFile);
        mainContainer.loadScreen(MainApp.pantalla2vs2, MainApp.pantalla2vs2File);
        mainContainer.loadScreen(MainApp.pantalla3vs3, MainApp.pantalla3vs3File);
        mainContainer.setScreen(MainApp.pantallaInicial);
        
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ALGOTRUCO");        
        primaryStage.show();
        
        showConOSinFlorSelector();
        
        
    }

    @FXML
    public void showConOSinFlorSelector() {

        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("SelectorConOSinFlor.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // CREO EL DIALOG STAGE
            Stage dialogStage = new Stage();
            dialogStage.setTitle("FLOR");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            SelectorConOSinFlorControlador controller = loader.getController();
            controller.setDialogStage(dialogStage);
            

           
            dialogStage.showAndWait();

            if ((controller.conFlor())){
                //MainApp.algotruco.Conflor();
            }
            
            else if(! controller.conFlor()){
                //MainApp.algotruco.Sinflor();
                
            }
                
        } catch (IOException e) {
            e.printStackTrace();
            
        }
   }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
