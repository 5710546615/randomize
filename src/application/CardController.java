package application;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CardController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private HBox list_hb;
	@FXML
	private Label numcard;

	private File file;
	private Image image;
	private ImageView imageview;

	public void initialize() {
		file = new File("assets/header/card.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

	public void handleRandom(ActionEvent event) {
		if (rn.getRands() == null) {
			rn.setRands(new ArrayList<Integer>());
		}
		
		list_hb.getChildren().clear();

		file = new File("assets/card/" + rn.getRandomed() + ".png");
		image = new Image(file.toURI().toString());
		imageview = new ImageView(image);
		imageview.setFitHeight(175);
		imageview.setFitWidth(115);

		list_hb.getChildren().add(imageview);
		numcard.setText("Cards : " + (52 - rn.getRands().size()));
	}

	public void handleClear(ActionEvent event) {
		list_hb.getChildren().clear();
		rn.clearAll();
		numcard.setText("Cards : 52");
	}
}
