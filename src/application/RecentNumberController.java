package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class RecentNumberController {
	@FXML
	private ListView list;
	
	public void setArr(int[] arr) {
		for (int i : arr) {
			list.getItems().add(i);
		}
	}

}
