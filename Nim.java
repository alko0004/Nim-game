import java.util.Random;
import java.util.Scanner;

public class Nim {

	private Pile pileA = new Pile(); // First pile
	private Pile pileB = new Pile(); // Second pile
	private Pile pileC = new Pile(); // Third pile
	private Random rnd = new Random(); // Random number generator

	String pile;
	int amount;

	Scanner input = new Scanner(System.in); // Scanner for all user input

	public Nim() { // Default constructor, constructs the three piles

	}

	public Nim(Pile a, Pile b, Pile c) { // initial constructor

		pileA = a;
		pileB = b;
		pileC = c;

	}

	public boolean playerMove() { // All the rules to handle user input

		boolean move = false;

		// Select a pile
		while (true) {
			System.out.print("\nSelect a pile: ");
			pile = input.next();
			pile = pile.toUpperCase();

			if (pile.equals("A") || pile.equals("B") || pile.equals("C")) {

				// Invalid pile
				if ((pile.equals("A") && pileA.getSize() == 0) || (pile.equals("B") && pileB.getSize() == 0)
						|| (pile.equals("C") && pileC.getSize() == 0)) {
					System.out.println("Pile " + pile + " is empty, pick another");
					printPiles();
				} else {
					break;
				}
			} else {
				System.out.println("Invalid pile letter. Select a, b or c");
				printPiles();
			}
		}

		// How many to remove from pile
		while (true) {
			System.out.print("How many do you want to remove? ");
			amount = input.nextInt();

			if (pile.equals("A") || pile.equals("B") || pile.equals("C")) {

				// Invalid pile amount
				if ((pile.equals("A") && amount > pileA.getSize()) || amount < 1) {
					System.out.println("Pick a number between 1 and " + pileA.getSize() + ": ");
					printPiles();
					System.out.print("\nSelect a pile: ");
					pile = input.next();
					pile = pile.toUpperCase();
				}

				else if ((pile.equals("B") && amount > pileB.getSize()) || amount < 1) {
					System.out.println("Pick a number between 1 and " + pileB.getSize() + ": ");
					printPiles();
					System.out.print("\nSelect a pile: ");
					pile = input.next();
					pile = pile.toUpperCase();
				}

				else if ((pile.equals("C") && amount > pileC.getSize()) || amount < 1) {
					System.out.println("Pick a number between 1 and " + pileC.getSize() + ": ");
					printPiles();
					System.out.print("\nSelect a pile: ");
					pile = input.next();
					pile = pile.toUpperCase();
				} else {
					break;
				}

			}
		} // end while

		// Remove from pile
		if (pile.equals("A")) {
			pileA.remove(amount);
		} else if (pile.equals("B")) {
			pileB.remove(amount);
		} else if (pile.equals("C")) {
			pileC.remove(amount);
		}
		if (pileA.getSize() + pileB.getSize() + pileC.getSize() == 0)
			move = true;
		return move;
	} // end player move

	private void computerRandomMove() { // Computer move if done randomly, is computerMove() in non-bonus version

	}

	public void computerMove() { // All the rules to handle computer move

		String[] rPile = { "A", "B", "C" };
		int select = rnd.nextInt(rPile.length);

		// Computer random pile select
		if (pileA.getSize() + pileB.getSize() + pileC.getSize() == 0);
		else {
			printPiles();
			//Random again if empty pile
			while (select == 0 && pileA.getSize() == 0 || select == 1 && pileB.getSize() == 0
					|| select == 2 && pileC.getSize() == 0) {
				select = rnd.nextInt(rPile.length);
			}

			// Computer randomly removes from pile
			if (rPile[select].equals("A")) {
				amount = rnd.nextInt(pileA.getSize()) + 1;
				pileA.remove(amount);
			}

			else if (rPile[select].equals("B")) {
				amount = rnd.nextInt(pileB.getSize()) + 1;
				pileB.remove(amount);
			}

			else if (rPile[select].equals("C")) {
				amount = rnd.nextInt(pileC.getSize()) + 1;
				pileC.remove(amount);
			}

			System.out.println("Computer takes " + amount + " from pile " + rPile[select]);

			if (pileA.getSize() + pileB.getSize() + pileC.getSize() != 0) {
				printPiles();
			}
		}
	}// end computer move

	public boolean done() { // Is the game done?

		boolean gameover = false, pcover = false;

		while (gameover == false) {
			gameover = playerMove();

			if (pileA.getSize() + pileB.getSize() + pileC.getSize() > 0 && gameover == false)
				computerMove();

			if (pileA.getSize() + pileB.getSize() + pileC.getSize() == 0 && gameover == false) {
				gameover = true;
				pcover = true;
			}
		}

		if (pcover == true)
			gameover = false;

		return gameover;

	}

	public void printPiles() { // Print the current state of the piles

		System.out.println("	A	B	C	");
		System.out.println("	" + pileA.getSize() + "	" + pileB.getSize() + "	" + pileC.getSize());

	}

}
