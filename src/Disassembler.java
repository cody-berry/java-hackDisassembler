import java.io.File;
import java.util.Arrays;

import static processing.core.PApplet.loadStrings;

/**
 * @author cody
 * @date 2022.03.11
 *
 * coding plan
 * read a machine code file and format strings
 * translate A-instructions, binary_to_decimal
 * 		for each binary bit (in a list) with a counter from right-to-left,
 * 		take the bit at that digit times 2 to the power of the counter.
 * translate C-instructions using the table
 *
 */

public class Disassembler {
	public static void main(String[] args) {
		String[] assemblyFile = loadStrings(new File("C:\\Users\\winry" +
				"\\Dropbox\\code\\java\\cody\\java-hackDisassembler\\src/Add.hack"));
		int counter = 0;
		for (String code : assemblyFile) {
			System.out.println(String.format("%d: %s", counter, code));
			counter++;
		}
	}

}