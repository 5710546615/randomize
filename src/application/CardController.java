package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CardController extends Controller {
	@FXML
	private HBox list_hb;
	
	public void handleRandom(ActionEvent event) {
		File file;
		Image image;
		ImageView imageview;
		
		list_hb.getChildren().clear();
		
		file = new File("assets/card/" + rn.getRandomed() + ".png");
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);
		imageview.setFitHeight(250);
		imageview.setFitWidth(200);

		list_hb.getChildren().add(imageview);
	}
	
	public void handleClear(ActionEvent event) {
		
	}
}
