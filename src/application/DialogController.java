package application;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class DialogController {
	
	public void handleClose(ActionEvent event){
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.close();
	}
}

