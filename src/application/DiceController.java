package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DiceController extends Controller {
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private HBox list_hb;

	public void handleRandom(ActionEvent event) {
		default_lb.setVisible(false);

		int n = 1;
		try {
			n = Integer.parseInt(num_tf.getText().trim());
		} catch (Exception e) {
			num_tf.setText(String.valueOf(n));
		}

		File file;
		Image image;
		ImageView imageview;

		list_hb.getChildren().clear();

		if (n > 0 && n < 4) {
			for (int i = 0; i < n; i++) {

				file = new File("assets/dice/" + rn.getRandomed() + ".png");
				image = new Image(file.toURI().toString());
				imageview = new ImageView(image);
				imageview.setFitHeight(150);
				imageview.setFitWidth(150);

				list_hb.getChildren().add(imageview);
			}
		}
	}
	
	public void handleClear(ActionEvent event) {
		
	}
}
