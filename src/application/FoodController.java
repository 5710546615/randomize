package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FoodController {
	@FXML
	private Label randomed_lb;
	
	private RandomNumber rn;
	
	private static final String TYPE = "assets/food/type.txt";
	private static final String SAUCE = "assets/food/sauce.txt";
	private static final String MATERIAL = "assets/food/material.txt";
	
	public RandomNumber getRandomNumber() {
		return rn;
	}

	public void setRandomNumber(RandomNumber rn) {
		this.rn = rn;
	}
	
	public void handleRandom(ActionEvent event) throws IOException {
		BufferedReader br;
		List<String> types = new ArrayList<String>();
		List<String> sauces = new ArrayList<String>();
		List<String> materials = new ArrayList<String>();
		String line;
		String randomed;
		
		br = new BufferedReader(new FileReader(TYPE));
		while((line = br.readLine()) != null) {
			types.add(line);
		}
		br.close();
		
		br = new BufferedReader(new FileReader(SAUCE));
		while((line = br.readLine()) != null) {
			sauces.add(line);
		}
		br.close();
		
		br = new BufferedReader(new FileReader(MATERIAL));
		while((line = br.readLine()) != null) {
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
