package Vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;



public class Pantalla1vsPCController implements Initializable , ControlledScreen {

    ScreensController myController;
    Label nombreJugador;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//    	nombreJugador.setText(MainApp.partida.obtenerNombreJugador());
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void volverAPantallaInicial(ActionEvent event){
       myController.setScreen(MainApp.pantallaInicial);
    }
    
   
    
}
