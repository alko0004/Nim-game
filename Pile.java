import java.util.Random;
import java.util.Scanner;

public class Pile {

	private int size; // The current size of pile
	private Random rnd = new Random();
	
	public Pile() { // Default constructor (Non-bonus version)

		size = rnd.nextInt(10)+11;

	}

	public Pile(int S) { // Initial constructor (Bonus version)

		size = S;
	}

	public int getSize() { // get current size of pile

		return this.size;
	}

	public void remove(int num) { // remove the amount from pile

		size -= num;
		;
	}

}
