package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RPSController {
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private FlowPane list_fp;

	private RandomNumber rn;

	private File file;
	private Image image;
	private ImageView imageview;
	private int n;

	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
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
