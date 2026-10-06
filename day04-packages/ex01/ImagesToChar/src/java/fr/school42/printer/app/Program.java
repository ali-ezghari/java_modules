package fr.school42.printer.app;

import fr.school42.printer.logic.*;

public class Program {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java -jar images-to-chars-printer.jar <white_char> <black_char>");
			return;
		}

		char whiteChar = args[0].charAt(0);
		char blackChar = args[1].charAt(0);

		Logic.run(whiteChar, blackChar);
	}
}
