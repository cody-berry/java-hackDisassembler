import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
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
//		String[] machineCodeFile;
//		int counter = 0;
//		for (String code : machineCodeFile) {
//			String translation;
//
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
//			System.out.println(translation + ")");
//		}
		printFile();
	}


	public static void printFile() {
		try {
			File directory = new File("./");
			System.out.println(directory.getAbsolutePath());

			URL path = Disassembler.class.getResource("Add.asm");
			System.out.println(path);


			File myObj = new File("Add.asm");
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