package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class RPSController extends Controller {
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private FlowPane list_fp;

	private File file;
	private Image image;
	private ImageView imageview;
	private int n;

	@FXML
	ImageView header_iv;

	public void initialize() {
		file = new File("assets/header/rps.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

	public void handleRandom(ActionEvent event) {
		default_lb.setVisible(false);

		n = 1;

		try {
			n = Integer.parseInt(num_tf.getText().trim());
		} catch (Exception e) {
			num_tf.setText(String.valueOf(n));
		}

		list_fp.getChildren().clear();

		if (imageview == null) {
			if (n > 0 && n < 5) {
				for (int i = 0; i < n; i++) {
					file = new File("assets/rps/question.png");
					image = new Image(file.toURI().toString());
					imageview = new ImageView(image);
					imageview.setFitHeight(125);
					imageview.setFitHeight(125);

					list_fp.getChildren().add(imageview);
				}
			}
		} else {
			if (n > 0 && n < 5) {
				for (int i = 0; i < n; i++) {
					file = new File("assets/rps/" + rn.getRandomed() + ".png");
					image = new Image(file.toURI().toString());
					imageview = new ImageView(image);
					imageview.setFitHeight(125);
					imageview.setFitHeight(125);

					list_fp.getChildren().add(imageview);

					imageview = null;
				}
			}
		}
	}

	public void handleClear(ActionEvent event) {
		default_lb.setVisible(true);
		num_tf.clear();
		list_fp.getChildren().clear();

	}
}
