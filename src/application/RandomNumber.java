package application;

import java.util.List;
import java.util.Random;

public class RandomNumber {
	private int min;
	private int max;
	private int randomed;
	private List<Integer> rands;

	public RandomNumber(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public List<Integer> getRands() {
		return rands;
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
		return randomed;
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

	public void clearAll() {
		rands = null;
	}
}
