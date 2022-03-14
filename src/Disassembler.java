import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Disassembler {
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\winry\\Dropbox\\code\\java" +
					"\\cody\\java-hackDisassembler\\asm\\Add.hack");
			Scanner machineCode = new Scanner(file);

			int counter = 0;
			while (machineCode.hasNextLine()) {
				String code = machineCode.nextLine();
				System.out.println(String.format("%d: %s", counter, code));

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
}
