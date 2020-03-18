import static java.lang.System.*;
import java.util.*;
import java.io.*;

class EnglishSources {
	static Scanner scan = new Scanner(in);

	static void displaySources(ArrayList<String> sources) {
		Collections.sort(sources); // put sources in ABC order
		for(int i = 0; i < sources.size(); i++) { // display sources in MLA format
			out.println(sources.get(i) + "\n");
			sources.remove(i+1);
		}
		out.print("Coded by DeveloperJ.\nSpeical thanks to BCPS english teacher Ms. Ehmann & programmer Brin O.");
	}

	static void organizeSources(int sourceNum) {
		ArrayList<String> sources = new ArrayList<String>();
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
		displaySources(sources);
	}

	public static void directions() {
		int num = 0;

		out.println("DIRECTIONS: Your font MUST be Calibri Body with a font size of 12.");
		out.print("How many sources do you have? You MUST type a number! ");
		try { // if user enters text handles error
			num = scan.nextInt();
		} catch(Exception e) {
			out.println("\nERROR: Please only type numbers!\n");
			directions();
		}

		if(num > 1) {
			out.print("\nPlease enter you sources ONE at a time!\n");
			organizeSources(num);
		} else {
			organizeSources(num);
		}
	}

	public static void main(String[] args) {
		directions();
	}
}
