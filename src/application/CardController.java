package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * CardController represents UI controller in Card scene.
 * 
 * @author Visurt Anuttivong
 */
public class CardController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private HBox list_hb;
	@FXML
	private Label numcard;

	/** the image from file */
	private Image image;
	/** image view component */
	private ImageView imageview;

	/**
	 * Initialize a new CardController when creates the UI form.
	 */
	public void initialize() {
		image = new Image(ResourceLoader.load("header/card.png"));
		header_iv.setImage(image);
	}

	/**
	 * Random handler is to random a card from deck.
	 * 
	 * @param event the event when select
	 */
	public void handleRandom(ActionEvent event) {
		if (rn.getRands() == null) {
			rn.setRands(new ArrayList<Integer>());
		}

		list_hb.getChildren().clear();

		image = new Image(ResourceLoader.load("card/" + rn.getRandomed() + ".png"));
		imageview = new ImageView(image);
		imageview.setFitHeight(175);
		imageview.setFitWidth(115);

		list_hb.getChildren().add(imageview);
		numcard.setText("Cards : " + (52 - rn.getRands().size()));
	}

	/**
	 * Clear handler is to clear all components to default.
	 * 
	 * @param event the event when select
	 */
	public void handleClear(ActionEvent event) {
		list_hb.getChildren().clear();
		rn.clearAll();
		numcard.setText("Cards : 52");
	}
}
