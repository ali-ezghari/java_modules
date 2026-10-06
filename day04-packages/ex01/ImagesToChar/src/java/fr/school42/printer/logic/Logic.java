package fr.school42.printer.logic;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.IOException;

public class Logic {

	public static void run(char whiteChar, char blackChar) {
		// 1. Ask the ClassLoader to open an InputStream to the resource inside the JAR
		// The leading "/" means "start looking from the root of the classpath/JAR"
		try (InputStream inputStream = Logic.class.getResourceAsStream("/resources/it.bmp")) {

			// 2. If the file wasn't bundled properly in the target folder, inputStream will
			// be null
			if (inputStream == null) {
				System.err.println("Error: Could not find image.bmp inside the JAR/classpath!");
				return;
			}

			// 3. ImageIO can read directly from an InputStream
			BufferedImage image = ImageIO.read(inputStream);

			for (int y = 0; y < image.getHeight(); y++) {
				for (int x = 0; x < image.getWidth(); x++) {
					int pixelColor = image.getRGB(x, y);

					if (pixelColor == Color.BLACK.getRGB())
						System.out.print(blackChar);
					else
						System.out.print(whiteChar);
				}
				System.out.println();
			}

		} catch (IOException e) {
			System.err.println("Failed to load image: " + e.getMessage());
		}
	}
}