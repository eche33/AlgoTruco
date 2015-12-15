package Vista;

import javafx.fxml.FXML;

import javafx.stage.Stage;

public class SelectorConOSinFlorControlador {
	
	private Stage dialogStage;

	
	Boolean modo;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	@FXML
	private void seleccionarConFlor() {
		modo = true;
		dialogStage.close();
	}
	@FXML
	private void seleccionarSinFlor() {
		modo = false;
		dialogStage.close();
	}




	public boolean conFlor() {
		return modo;
	}
    

}