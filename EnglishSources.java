import static java.lang.System.out;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class EnglishSources {
	private LinkedList<String> sources = new LinkedList<String>();
	private Scanner scan = new Scanner(System.in);

	private EnglishSources() {}

	private void displaySources() {
		Collections.sort(sources); // put sources in ABC order
		for(int i = 0; i < sources.size(); i++) { // display sources in MLA format
			out.println(sources.get(i) + "\n");
			i++;
		}
	}

	private void organizeSources(int sourceNum) {
		int letterCnt = 93;
		String temp, copy = "";
		String txt = "";

		for(int i = 0; i <= sourceNum; i++) {
			if(i == 0) {
				i++;
				i--;
			} else {
				out.print("What is source number " + i + "? ");
			}
			txt = scan.nextLine();

			sources.add(txt);
			if(txt.length() > letterCnt) {
				temp = txt.substring(0, letterCnt); // get letters between txt.substring(0, letterCnt) and txt.substring(letterCnt)
				
				if(temp.substring(letterCnt).equals(" ")) {
					sources.add(temp);
				} else if(temp.length() == letterCnt) { // cut off word at " " instead of at a letter
					
					for(int j = letterCnt; j < txt.length(); j--) {
						if(txt.substring(letterCnt-1, letterCnt).equals(" ")) {
							temp = txt.substring(letterCnt);
							copy = txt.substring(0, letterCnt) + "\n" + "\t" + temp;
							sources.add(copy);
							letterCnt = 93;
							break;
						} else {
							letterCnt--;
						}
					}
				}
			} else { // if txt.length() < letterCnt add txt to ArrayList
				sources.add(txt);
			}
		}
		displaySources();
	}

	private boolean isNum(String strNum) {
		try {
			Integer.parseInt(strNum);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private void directions() {
		out.println("DIRECTIONS: Your font MUST be Calibri Body with a font size of 12.");
		out.print("How many sources do you have? You MUST type a number! ");

		String strNum = scan.nextLine();
		while(isNum(strNum) == false) {
			out.print("Please only type numbers ");
			strNum = scan.nextLine();
		}

		int num = Integer.parseInt(strNum);

		if(num >= 1) {
			out.print("\nPlease enter you sources ONE at a time!\n");
			organizeSources(num);
		}
	}

	public static void main(String[] args) {
		EnglishSources eng = new EnglishSources();
		eng.directions();
	}
}
