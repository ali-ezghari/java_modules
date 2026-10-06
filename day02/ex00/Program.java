package ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.io.File;

public class Program {
	public static void main(String[] args) {
		// Debug line: Prints exactly where your program expects files to be
		// System.out.println("Current Working Directory: " + new
		// File(".").getAbsolutePath());

		Map<String, String> signatures = new TreeMap<>();

		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/ex00/signature.txt");
			FileOutputStream outputFile = new FileOutputStream(System.getProperty("user.dir") + "/ex00/result.txt",
					true);
			StringBuilder tempStr = new StringBuilder();
			int byteData;

			while ((byteData = file.read()) != -1) {
				if ((char) byteData == '\n' || file.available() == 0) {
					String[] line = tempStr.toString().split(",");
					signatures.put(line[1].trim(), line[0]);
					tempStr.setLength(0);
					continue;
				}
				tempStr.append((char) byteData);
			}

			for (Map.Entry<String, String> entry : signatures.entrySet()) {
				outputFile.write((entry.getKey() + ", " + entry.getValue()).getBytes());
				outputFile.write('\n');
				System.out.println((entry.getKey() + " = " + entry.getValue()));
			}
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("42 encountered");
	}

}

// Scanner scanner = new Scanner(System.in);
// String str;

// while (!(str = scanner.nextLine()).equals("42")) {
// System.out.println("Attempting to open: " + str);

// try (FileInputStream fis = new FileInputStream(str)) {
// int byteData;
// while ((byteData = fis.read()) != -1) {
// System.out.println("Byte: read: " + byteData);

// }
// } catch (IOException e) {
// e.printStackTrace();
// }

// }
