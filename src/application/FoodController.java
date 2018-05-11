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

	private File file;
	private Image image;
	private static final String TYPE = "assets/food/type.txt";
	private static final String SAUCE = "assets/food/sauce.txt";
	private static final String MATERIAL = "assets/food/material.txt";
	private List<String> types, sauces, materials;
	private List<List<String>> list;

	public void initialize() {
		file = new File("assets/header/food.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);

		try {
			types = reader(TYPE);
			sauces = reader(SAUCE);
			materials = reader(MATERIAL);

			list = new ArrayList<List<String>>();
			list.add(types);
			list.add(sauces);
			list.add(materials);
		} catch (IOException e) {

		}
	}

	public void handleRandom(ActionEvent event) throws IOException {
		String randomed = "";

		for (int i = 0; i < list.size(); i++) {
			rn.setMax(list.get(i).size() - 1);
			randomed += "" + list.get(i).get(rn.getRandomed());
		}

		randomed_lb.setText(randomed);
	}

	public void handleClear(ActionEvent event) {
		randomed_lb.setText("?");
	}

	public List<String> reader(String str) throws IOException {
		List<String> tmp = new ArrayList<String>();
		String line;

		BufferedReader br = new BufferedReader(new FileReader(str));
		while ((line = br.readLine()) != null) {
			tmp.add(line);
		}
		br.close();
		return tmp;
	}
}
