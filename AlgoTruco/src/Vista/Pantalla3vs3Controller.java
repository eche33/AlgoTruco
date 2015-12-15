
package Vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class Pantalla3vs3Controller implements Initializable, ControlledScreen {

    ScreensController myController;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void volverAPantallaInicial(ActionEvent event){
       myController.setScreen(MainApp.pantallaInicial);
    }
    
}
