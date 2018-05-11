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

/**
 * FoodController represents UI controller in Food scene.
 * 
 * @author Visurt Anuttivong
 */
public class FoodController extends Controller {
	@FXML
	private ImageView header_iv;
	@FXML
	private Label randomed_lb;

	/** the source file */
	private File file;
	/** the image from file */
	private Image image;
	/** source file of types of food */
	private static final String TYPE = "assets/food/type.txt";
	/** source file of sauces of food */
	private static final String SAUCE = "assets/food/sauce.txt";
	/** source file of materials of food */
	private static final String MATERIAL = "assets/food/material.txt";
	/** List of each random */
	private List<String> types, sauces, materials;
	/** List of all list of each random */
	private List<List<String>> list;

	/**
	 * Initialize a new FoodController when creates the UI form.
	 */
	public void initialize() {
		file = new File("assets/header/food.png");
		image = new Image(file.toURI().toString());
		header_iv.setImage(image);

		types = reader(TYPE);
		sauces = reader(SAUCE);
		materials = reader(MATERIAL);

		list = new ArrayList<List<String>>();
		list.add(types);
		list.add(sauces);
		list.add(materials);
	}

	/**
	 * Random handler is to random types, sauces, materials of food.
	 * 
	 * @param event the event when select
	 */
	public void handleRandom(ActionEvent event) throws IOException {
		String randomed = "";

		for (int i = 0; i < list.size(); i++) {
			rn.setMax(list.get(i).size() - 1);
			randomed += "" + list.get(i).get(rn.getRandomed());
		}

		randomed_lb.setText(randomed);
	}

	/**
	 * Clear handler is to clear all components to default.
	 * 
	 * @param event the event when select
	 */
	public void handleClear(ActionEvent event) {
		randomed_lb.setText("?");
	}

	/**
	 * Read string from source file and write to list.
	 * 
	 * @param str the source file in form of String
	 * @return list of all things that read from file
	 */
	public List<String> reader(String str) {
		List<String> tmp = new ArrayList<String>();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(str));
			while ((line = br.readLine()) != null) {
				tmp.add(line);
			}
			br.close();
		} catch (IOException e) {

		}
		return tmp;
	}
}
