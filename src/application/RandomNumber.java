package application;

import java.util.List;
import java.util.Random;

/**
 * RandomNumber is the class for random between min and max.
 * 
 * @author Visurt Anuttivong
 */
public class RandomNumber {
	/** the minimum possible of random */
	private int min;
	/** the maximum possible of random */
	private int max;
	/** the number between min and max */
	private int randomed;
	/** the store of random number */
	private List<Integer> rands;

	/**
	 * Initialize a new RandomNumber.
	 * 
	 * @param min the minimum possible
	 * @param max the maximum possible
	 */
	public RandomNumber(int min, int max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * Get the minimum of random number.
	 * 
	 * @return the number of minimum
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Get the maximum of random number.
	 * 
	 * @return the number of maximum
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Get the store list of random number.
	 * 
	 * @return the store list
	 */
	public List<Integer> getRands() {
		return rands;
	}

	/**
	 * Get the number that already random.
	 * 
	 * @return the random number
	 */
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

	/**
	 * Set the minimum of random number.
	 * 
	 * @param min the number of minimum
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * Set the maximum of random number.
	 * 
	 * @param max the number of maximum
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * Set the store list of random number.
	 * 
	 * @param rands the newer list to replace old one
	 */
	public void setRands(List<Integer> rands) {
		this.rands = rands;
	}

	/**
	 * Clear all store list not only the element inside but also it own list.
	 */
	public void clearAll() {
		rands = null;
	}
}
