package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

	/** the image from file */
	private Image image;
	/** source file of types of food */
	private static final String TYPE = "food/type.txt";
	/** source file of sauces of food */
	private static final String SAUCE = "food/sauce.txt";
	/** source file of materials of food */
	private static final String MATERIAL = "food/material.txt";
	/** List of each random */
	private List<String> types, sauces, materials;
	/** List of all list of each random */
	private List<List<String>> list;

	/**
	 * Initialize a new FoodController when creates the UI form.
	 */
	public void initialize() {
		image = new Image(ResourceLoader.load("header/food.png"));
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
			randomed += "" + list.get(i).get(rn.getRandomed()).trim();
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
	 * @return list that contains string from read file
	 */
	public List<String> reader(String str) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(ResourceLoader.load(str)).useDelimiter("\\A");
		String s = scan.hasNext() ? scan.next() : "";

		List<String> list = new ArrayList<String>(Arrays.asList(s.trim().split("\n")));
		return list;
	}
}
