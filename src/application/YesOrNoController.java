package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class YesOrNoController extends Controller {
	@FXML
	private HBox list_hb;

	private File file;
	private Image image;
	private ImageView imageview;

	public void initialize() {
		file = new File("assets/yesno/yesno.png");
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);

		list_hb.getChildren().add(imageview);
	}

	public void handleRandom(ActionEvent event) {
		list_hb.getChildren().clear();

		file = new File("assets/yesno/" + rn.getRandomed() + ".png");

		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);

		list_hb.getChildren().add(imageview);
	}
}
