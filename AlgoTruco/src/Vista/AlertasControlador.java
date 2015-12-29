package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertasControlador {
	
	private Stage dialogStage;

	@FXML
	Label alerta;

    @FXML
    private void initialize() {
    }

    public void setearMensaje(String mensaje){
    	
    	alerta.setText(mensaje);
    	
    } 
    
    @FXML 
    public void close(){
    	dialogStage.close();
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	    
    

}