import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Disassembler {
	public static void main(String[] args) {
		// before doing any work with files, we should define our dictionaries

		// computation
		Hashtable<String, String> comp = new Hashtable();
		comp.put("0101010", "0");
		comp.put("0111111", "1");
		comp.put("0111010", "-1");
		comp.put("0001100", "D");
		comp.put("0110000", "A");
		comp.put("1110000", "M");
		comp.put("0001101", "!D");
		comp.put("0110001", "!A");
		comp.put("1110001", "!M");
		comp.put("0001111", "-D");
		comp.put("0110011", "-A");
		comp.put("1110011", "-M");
		comp.put("0011111", "D+1");
		comp.put("0110111", "A+1");
		comp.put("1110111", "M+1");
		comp.put("0001110", "D-1");
		comp.put("0110010", "A-1");
		comp.put("1110010", "M-1");
		comp.put("0000010", "D+A");
		comp.put("1000010", "D+M");
		comp.put("0010011", "D-A");
		comp.put("1010011", "D-M");
		comp.put("0000111", "A-D");
		comp.put("1000111", "M-D");
		comp.put("0000000", "D&A");
		comp.put("1000000", "D&M");
		comp.put("0010101", "D|A");
		comp.put("1010101", "D|M");


		// destination
		Hashtable<String, String> dest = new Hashtable();
		dest.put("000", "null");
		dest.put("001", "M");
		dest.put("010", "D");
		dest.put("011", "MD");
		dest.put("100", "A");
		dest.put("101", "AM");
		dest.put("110", "AD");
		dest.put("111", "AMD");

		// jump
		Hashtable<String, String> jump = new Hashtable();
		jump.put("000", "null");
		jump.put("001", "JGT");
		jump.put("010", "JEQ");
		jump.put("011", "JGE");
		jump.put("100", "JLT");
		jump.put("101", "JNE");
		jump.put("110", "JLE");
		jump.put("111", "JMP");

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
					String computation = comp.get(code.substring(3, 10));
					String destination = dest.get(code.substring(10, 13));
					String jmp = jump.get(code.substring(13, 16));

					if (!destination.equals("null")) {
						translation = destination + "=";
						translation += computation;
					} else {
						translation = computation;
					}
					if (!jmp.equals("null")) {
						translation += "; " + jump;
					}
				}

				System.out.println(String.format("%d: %s %s", counter, code
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
