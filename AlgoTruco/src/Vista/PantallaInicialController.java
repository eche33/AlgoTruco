package Vista;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class PantallaInicialController implements Initializable, ControlledScreen {

    ScreensController myController;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    
    @FXML
    public void show1vs1Selector() {

        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("1vs1SelectorDeModo.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // CREO EL DIALOG STAGE
            Stage dialogStage = new Stage();
            dialogStage.setTitle("1 VS 1");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            SelectorModo1vs1Controlador controller = loader.getController();
            controller.setDialogStage(dialogStage);
            

           
            dialogStage.showAndWait();

            if ((controller.modoSeleccionado()) == "1VS1"){
                myController.setScreen(MainApp.pantalla1vs1);
                ingresoDeNombres1vs1();
            }
            
            else if((controller.modoSeleccionado()) == "1VSPC"){
                myController.setScreen(MainApp.pantalla1vsPC);
                ingresoDeNombre1vsPC();
                
            }
                
        } catch (IOException e) {
            e.printStackTrace();
             myController.setScreen(MainApp.pantallaInicial);
        }
   }

    @FXML
    public void ingresoDeNombres1vs1() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("nombres1vs1.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // CREO EL DIALOG STAGE
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ingrese nombres");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            registroDeNombres1vs1Controlador controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
         
            dialogStage.showAndWait();
            controller.crearPartida1vs1();
                
        } catch (IOException e) {
            e.printStackTrace();
             myController.setScreen(MainApp.pantallaInicial);
        }
   }
    
    @FXML
    public void ingresoDeNombre1vsPC() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("nombre1vsPC.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // CREO EL DIALOG STAGE
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ingrese nombres");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            registroDeNombre1vsPCControlador controller = loader.getController();
            controller.setDialogStage(dialogStage);
           
            dialogStage.showAndWait();
            controller.crearPartida1vsPC();
           
                
        } catch (IOException e) {
            e.printStackTrace();
             myController.setScreen(MainApp.pantallaInicial);
        }
   } 
   
    @FXML
    public void ingresoDeNombres2vs2() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("nombres2vs2.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // CREO EL DIALOG STAGE
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ingrese nombres");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            registroDeNombres2vs2Controlador controller = loader.getController();
            controller.setDialogStage(dialogStage);
           
            dialogStage.showAndWait();
            controller.crearPartida2vs2();
           
                
        } catch (IOException e) {
            e.printStackTrace();
             myController.setScreen(MainApp.pantallaInicial);
        }
   } 
     
    @FXML
    public void ingresoDeNombres3vs3() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("nombres3vs3.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // CREO EL DIALOG STAGE
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ingrese nombres");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            registroDeNombres3vs3Controlador controller = loader.getController();
            controller.setDialogStage(dialogStage);
           
            dialogStage.showAndWait();
            controller.crearPartida3vs3();
           
                
        } catch (IOException e) {
            e.printStackTrace();
             myController.setScreen(MainApp.pantallaInicial);
        }
   } 
    
    public void crearPartida2vs2(){
    	 myController.setScreen(MainApp.pantalla2vs2);
    	 ingresoDeNombres2vs2();
    }
 
    public void crearPartida3vs3(){
    	myController.setScreen(MainApp.pantalla3vs3);
    	ingresoDeNombres3vs3();
    	
    }
}
