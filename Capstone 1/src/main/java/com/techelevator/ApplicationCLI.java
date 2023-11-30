package com.techelevator;
import com.techelevator.view.Menu;

public class ApplicationCLI {
	public static void main(String[] args) {
		ApplicationCLI cli = new ApplicationCLI();
		cli.run();
	}
	public void run() {
		Menu menu = new Menu();

		menu.printGreeting();
		while(true) {
			menu.getMainMenu();
		}
	}
}

// probably should leave this method alone... and go do stuff in the run method....
/**
 * This is the main method that controls the flow of the program.. Probably could look at the review code for ideas of what to put here...
 */
// Good place to create references for UserInterface, Inventory class, and Register class.... (There should NEVER be more than one instance of these)
//probably a great place to create a loop that manages the main menu and delegates all work to the other classes....
// Hint: for the submenu, maybe a loop inside this main loop? If you break out of the sub-loop(sub-menu), you would reach the
//outer loop....
//feel free to create private methods here if you are feeling up to it, so run() doesn't get so long...
