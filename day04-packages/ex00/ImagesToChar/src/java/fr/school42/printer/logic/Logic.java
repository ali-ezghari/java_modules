package fr.school42.printer.logic;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Logic {
	private char wChar;
	private char bChar;
	private String path;

	public Logic(char a1, char a2, String path) {
		this.wChar = a1;
		this.bChar = a2;
		this.path = path;
	}

	public void run() {
		File f = new File(path); // File class: gets all the information about that file with "path"

		if (!f.exists()) { // checking if the file exists
			System.err.println("File now found");
			System.exit(-1);
		}
		try {
			BufferedImage img = ImageIO.read(f); // opening the file as a buffer for io operations
			for (int y = 0; y < img.getHeight(); y++) {
				for (int x = 0; x < img.getWidth(); x++) {
					int color = img.getRGB(x, y);
					System.out.println("\n");
					System.out.println(color);
					System.out.println("\n");
					if (color == Color.BLACK.getRGB())
						System.out.print(bChar);
					else
						System.out.print(wChar);
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
