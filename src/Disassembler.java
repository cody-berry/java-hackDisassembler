import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Disassembler {
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\winry\\Dropbox\\code\\java" +
					"\\cody\\java-hackDisassembler\\asm\\Add.hack");
			Scanner machineCode = new Scanner(file);

			int counter = 0;
			String translation;
			while (machineCode.hasNextLine()) {
				String code = machineCode.nextLine();

				if (code.charAt(0) == '0') {
					translation = "@" + binToDec(code.substring(1, 16));
				} else {
					translation = "C";
				}

				System.out.println(String.format("%d: %s (%s)", counter, code
						, translation));

				counter++;
			}
			machineCode.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	public static void printFile() {
//		try {
//			File myObj = new File("C:\\Users\\winry\\Dropbox\\code\\java" +
//					"\\cody\\java-hackDisassembler\\asm\\Add.hack");
//			Scanner myReader = new Scanner(myObj);
//			while (myReader.hasNextLine()) {
//				String data = myReader.nextLine();
//				System.out.println(data);
//			}
//			myReader.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("An error occurred.");
//			e.printStackTrace();
//		}
	}

	public static int binToDec(String binary) {
		// our result of the decimal conversion
		int result = 0;

		for (int i = 0; i < binary.length(); i++) {
			result += Math.pow(2, i)*parseInt(String.valueOf(binary.charAt(binary.length()-1-i)));
		}

		// now let's return the fruit of our hard work: the result!
		return result;
	}
}
