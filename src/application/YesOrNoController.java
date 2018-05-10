package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class YesOrNoController {
	@FXML
	private HBox list_hb;
	
	private RandomNumber rn;
	
	private File file;
	private Image image;
	private ImageView imageview;
	
	public void initialize() {
		file = new File("assets/yesno/yesno.png");
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);
		
		list_hb.getChildren().add(imageview);
	}
	
	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}
	
	public void handleTry(ActionEvent event) {
		list_hb.getChildren().clear();
		
		if (rn.getRandomed() == 1) {
			file = new File("assets/yesno/yes.png");
		} else {
			file = new File("assets/yesno/no.png");
		}
		
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);
		
		list_hb.getChildren().add(imageview);
	}
	
	public void handleBack(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("RandomizeUI.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}

	public void handleRecent(ActionEvent event) throws IOException {
		RecentView view = new RecentView(rn);
		rn.addObserver(view);
		view.run();
	}
}
