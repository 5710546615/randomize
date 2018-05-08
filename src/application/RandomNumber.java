package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Observable;

public class RandomNumber extends Observable {
	private int min;
	private int max;
	private int randomed;
	private List<Integer> rands;
	private List<Integer> allNumbers;

	public RandomNumber(int min, int max) {
		this.min = min;
		this.max = max;
		allNumbers = new ArrayList<Integer>();
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getRandomed() {
		Random rand = new Random();
		int range = max - min + 1;
		randomed = rand.nextInt(range) + min;

		if (rands != null) {
			if (!rands.contains(randomed)) {
				rands.add(randomed);
			} else if (rands.size() < range) {
				do {
					randomed = rand.nextInt(range) + min;
				} while (rands.contains(randomed));

				rands.add(randomed);
			} else {
				randomed = Integer.MIN_VALUE;
			}
		}
		
		allNumbers.add(randomed);
		
		setChanged();
		notifyObservers();
		return randomed;
	}

	public List<Integer> getRands() {
		return rands;
	}
	
	public List<Integer> getAllNumbers(){
		return allNumbers;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setRands(List<Integer> rands) {
		this.rands = rands;
	}

}
