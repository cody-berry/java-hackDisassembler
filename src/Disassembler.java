import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * @author cody
 * @date 2022.03.11
 * <p>
 * coding plan read a machine code file and format strings translate
 * A-instructions, binary_to_decimal for each binary bit (in a list) with a
 * counter from right-to-left, take the bit at that digit times 2 to the power
 * of the counter. translate C-instructions using the table
 */

public class Disassembler {
	public static void main(String[] args) {
		try {
			File myObj = new File("C:\\Users\\winry\\Dropbox\\code\\java" +
					"\\cody\\java-hackDisassembler\\asm\\Add.hack");
			Scanner myReader = new Scanner(myObj);
			int counter = 0;
			while (myReader.hasNextLine()) {
				String translation;
				String code = myReader.nextLine();
				System.out.println(code);
				System.out.print(String.format("%d: %s (commonly referred to as "
						, counter, code));
				counter++;

				if (code.charAt(0) == '0') {
					translation =
							"@" + binaryToDecimal(code.substring(1, 16));
				} else {
					translation = "[Blank, it's a C]";
				}

				System.out.println(translation + ")");
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}


//		File myObj = new File("C:\\Users\\winry\\Dropbox\\code\\java" +
//				"\\cody\\java-hackDisassembler\\asm\\Add.asm");
//
//		Scanner machineCodeFile = new Scanner("C:\\Users\\winry\\Dropbox\\code\\java" +
//				"\\cody\\java-hackDisassembler\\asm\\Add.asm");
//		int counter = 0;
//		while (machineCodeFile.hasNextLine()) {
//			String translation;
//			String code = machineCodeFile.nextLine();
//			System.out.println(code);


//			System.out.print(String.format("%d: %s (commonly referred to as "
//					, counter, code));
//			counter++;
//			if (code.charAt(0) == '0') {
//				translation =
//						"@" + binaryToDecimal(code.substring(1, 16));
//			} else {
//				translation = "[Blank, it's a C]";
//
//			}
//			System.out.printlzn(translation + ")");
//	}
//		printFile();
	}


	public static void printFile() {
		try {
			File myObj = new File("C:\\Users\\winry\\Dropbox\\code\\java" +
				"\\cody\\java-hackDisassembler\\asm\\Add.hack");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);



			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	// translates a 15-bit binary number into an integer
	public static int binaryToDecimal(String binary) {
		// our result is just a number. For each bit from right-to-left, we
		// take 2 to the power of the index.
		int result = 0;
		for (int i = 0; i < binary.length(); i++) {
			result += Math.pow(2, i) * parseInt(String.valueOf(binary.charAt(14 - i)));
		}
		return result;
	}
}