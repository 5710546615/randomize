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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CoinController {
	@FXML
	private TextField num_tf;
	@FXML
	private Label default_lb;
	@FXML
	private HBox list_hb;
	
	private RandomNumber rn;
	
	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}
	
	public void handleFlip(ActionEvent event) {
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
				if (n == 1) {
					file = new File("images/coin/" + rn.getRandomed() + ".png");
				} else {
					file = new File("images/coin/" + rn.getRandomed() + ".png");
				}
				
				image = new Image(file.toURI().toString());
				imageview = new ImageView(image);
				imageview.setFitHeight(150);
				imageview.setFitWidth(150);

				list_hb.getChildren().add(imageview);
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
