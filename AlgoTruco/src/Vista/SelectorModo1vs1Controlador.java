package Vista;

import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SelectorModo1vs1Controlador {
	
	private Stage dialogStage;
//  private Partida partdia;
	
	String modo;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	@FXML
	private void seleccionar1vs1() {
		modo = "1VS1";
		dialogStage.close();
	}
	@FXML
	private void seleccionar1vsPC() {
		modo = "1VSPC";
		dialogStage.close();
	}


	public String modoSeleccionado() {
		return modo;
	}
    

}