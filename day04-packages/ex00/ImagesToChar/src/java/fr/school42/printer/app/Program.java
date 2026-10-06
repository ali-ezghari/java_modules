package fr.school42.printer.app;

import fr.school42.printer.logic.*;

public class Program {
	public static void main(String[] args) {
		char whiteChar = args[0].charAt(0);
		char blackChar = args[1].charAt(0);
		String imagePath = args[2];

		Logic prg = new Logic(whiteChar, blackChar, imagePath);
		prg.run();

	}
}
