/*
Mohamad Al Kodmani
section 311
Howard Rosenblum
Intro to Computer Programming
Assignment 3
July 20th 2018
*/
public class Assign3 {

	public static void main(String[] args) {

		Nim obj = new Nim();
		System.out.println("Welcome to the NIM game");
		System.out.println("We play by the misère rules");
		obj.printPiles();

		boolean gameover = obj.done();

		if (gameover == false)
			System.out.println("Congrats: you win");
		else
			System.out.println("Sorry: you lose");

	} // end main
}
