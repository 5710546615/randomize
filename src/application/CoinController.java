package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CoinController extends Controller {
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private HBox list_hb;

	File file;
	Image image;
	@FXML
	ImageView header_iv;

	public void initialize() {
		file = new File("assets/header/coin.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

	public void handleRandom(ActionEvent event) {
		default_lb.setVisible(false);

		int n = 1;

		try {
			n = Integer.parseInt(num_tf.getText().trim());
			if (n < 1 || n > 4) {
				n = 1;
			}
		} catch (Exception e) {

		}
		num_tf.setText(String.valueOf(n));
		File file;
		Image image;
		ImageView imageview;

		list_hb.getChildren().clear();

		for (int i = 0; i < n; i++) {
			if (n == 1) {
				file = new File("assets/coin/" + rn.getRandomed() + ".png");
			} else {
				file = new File("assets/coin/" + rn.getRandomed() + ".png");
			}

			image = new Image(file.toURI().toString());
			imageview = new ImageView(image);
			imageview.setFitHeight(125);
			imageview.setFitWidth(125);

			list_hb.getChildren().add(imageview);
		}
	}

	public void handleClear(ActionEvent event) {
		num_tf.clear();
		default_lb.setVisible(true);
		list_hb.getChildren().clear();
	}
}
