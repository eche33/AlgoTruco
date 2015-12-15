package Vista;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;




public class Pantalla1vs1Controller implements Initializable , ControlledScreen {

    ScreensController myController;
    
    @FXML
    Label nombre1;
    
    @FXML
    Label nombre2;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        nombre1.setText(MainApp.partida.obtenerNombreJugador1());
//        nombre2.setText(MainApp.partida.obtenerNombreJugador2();

    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void volverAPantallaInicial(ActionEvent event){
    	
       myController.setScreen(MainApp.pantallaInicial);
    }
    
   

    
}
