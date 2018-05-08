package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
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
		 
		 FlowPane root = new FlowPane();
		 root.setPrefWidth(300);
		 root.setPrefHeight(400);
		 root.setHgap(10);
		 root.setVgap(10);
		 root.setPadding(new Insets(10, 10, 10, 10));
		 
		 Label recent_lb = new Label("Recent");
		 recent_lb.setPrefWidth(300);
		 recent_lb.setAlignment(Pos.CENTER);
		 
		 list_lv = new ListView<String>();
		 list_lv.setPrefHeight(300);
		 list_lv.setPrefWidth(300);
		 
		 Label tmp = new Label();
		 tmp.setPrefWidth(125);
		 
		 Button reset_btn = new Button("Reset");
		 
		 reset_btn.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			        list_lv.getItems().clear();
			        rn.clearAll();
			    }
			});
		 
		 root.getChildren().add(recent_lb);
		 root.getChildren().add(list_lv);
		 root.getChildren().add(tmp);
		 root.getChildren().add(reset_btn);
		 
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
