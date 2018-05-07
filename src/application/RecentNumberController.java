package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RecentNumberController {
	@FXML
	private ListView list;

	private boolean isReset = false;
	
	private int[] array;

	public void setArr(int[] arr) {
		array = arr;
		for (int i : arr) {
			list.getItems().add(i);
		}
	}

	public void changeSceneToNumber(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NumberUI.fxml"));
		Parent root = (Parent) loader.load();
		NumberController secController = loader.getController();
		
		if (!isReset) {
			secController.setList(array);
		} else {
			secController.setList(new int[0]);
		}
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}

	public void handleReset(ActionEvent event) {
		list.getItems().clear();
		isReset = true;
	}

}
