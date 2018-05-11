package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FoodController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private Label randomed_lb;

	private static final String TYPE = "assets/food/type.txt";
	private static final String SAUCE = "assets/food/sauce.txt";
	private static final String MATERIAL = "assets/food/material.txt";

	private File file;
	private Image image;


	public void initialize() {
		file = new File("assets/header/food.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);
	}

	public void handleRandom(ActionEvent event) throws IOException {
		BufferedReader br;
		List<String> types = new ArrayList<String>();
		List<String> sauces = new ArrayList<String>();
		List<String> materials = new ArrayList<String>();
		String line;
		String randomed;

		br = new BufferedReader(new FileReader(TYPE));
		while ((line = br.readLine()) != null) {
			types.add(line);
		}
		br.close();

		br = new BufferedReader(new FileReader(SAUCE));
		while ((line = br.readLine()) != null) {
			sauces.add(line);
		}
		br.close();

		br = new BufferedReader(new FileReader(MATERIAL));
		while ((line = br.readLine()) != null) {
			materials.add(line);
		}
		br.close();

		rn.setMax(types.size() - 1);
		randomed = "" + types.get(rn.getRandomed());

		rn.setMax(sauces.size() - 1);
		randomed += "" + sauces.get(rn.getRandomed());

		rn.setMax(materials.size() - 1);
		randomed += "" + materials.get(rn.getRandomed());

		randomed_lb.setText(randomed);
	}

	public void handleClear(ActionEvent event) {
		randomed_lb.setText("?");
	}
}
