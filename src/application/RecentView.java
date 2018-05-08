package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RecentView extends Stage implements Observer {

	private Stage stage;
	private RandomNumber rn;
	private ListView<String> list_lv;

	public RecentView(RandomNumber rn) throws IOException {
		this.rn = rn;
		initComponents();
	}

	private void initComponents() throws IOException {
		 stage = this;
		 HBox root = new HBox();
		 root.setPadding(new Insets(10));
		 root.setAlignment(Pos.CENTER);
		 
		 list_lv = new ListView<String>();
		 list_lv.setPrefWidth(196);
		 root.getChildren().add(list_lv);
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.setTitle("Recent");
		 stage.sizeToScene();
	}

	public void run() {
		stage.show();
		displayRandomed();
	}

	public void displayRandomed() {
		list_lv.getItems().clear();
		List<Integer> list = rn.getAllNumbers();
		
		int count = 1;
		
		for (int i = list.size() - 1; i>= 0;i--) {
			list_lv.getItems().add(count + ") " +list.get(i));
			count++;
		}
	}

	public void update(Observable o, Object arg) {
		displayRandomed();
	}
}
