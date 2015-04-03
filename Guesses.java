import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Guesses {

	public static void main(String[] args) {
		String result = "";
		String[] array = { "G", "R", "B" };
		List<String> choices = new ArrayList<String>();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					result += array[i] + array[j] + array[k];
					choices.add(result);
					result = "";
				}
			}
		}

		
                Scanner scan = new Scanner(System.in);
		String guessString = scan.next();
		String guess1 = guessString.substring(0, guessString.indexOf('-'));
		String guess2 = guessString.substring(guessString.indexOf('-') + 1);

		for (int i = 0; i < choices.size(); i++) {
			if (!positionMatch(choices.get(i),
					Integer.parseInt(guess1.substring(3, 4)), guess1)) {
				choices.set(i, "");
				continue;

			}

		        if (!positionMatch(choices.get(i),
					Integer.parseInt(guess2.substring(3, 4)), guess2)) {
				choices.set(i, "");
				continue;
			}

			if (Integer.parseInt(guess1.substring(4, 5)) >= 1) {

				if (!ColorMatch(choices.get(i),
						Integer.parseInt(guess1.substring(4,5)), guess1)) {
                                       choices.set(i, "");
				       continue;
				}

			}

			if (Integer.parseInt(guess1.substring(4, 5)) >= 1) {

				if (!ColorMatch(choices.get(i),
						Integer.parseInt(guess2.substring(4, 5)), guess2)) {
                                        choices.set(i, "");
                                       continue;
				}
			}

		}

                System.out.println(choices);
		choices.removeAll(Collections.singleton(""));

		if (choices.size() == 0) {
			System.out.println("Blue Screen");
		}

		else if (choices.size() > 1)
			System.out.println("Download and install updates");
		else
			System.out.println(choices.get(0));

	}

	private static boolean positionMatch(String str, int count, String guess) {

		int matches = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == guess.charAt(i))
				matches++;
		}

		if (matches == count)
			return true;
		else
			return false;
	}

	private static boolean ColorMatch(String str, int count, String guess) {
		int matches = 0;

		if (str.charAt(0) == guess.charAt(1)
				|| str.charAt(0) == guess.charAt(2))
			matches++;
		if (str.charAt(1) == guess.charAt(0)
				|| str.charAt(1) == guess.charAt(2))
			matches++;
		if (str.charAt(2) == guess.charAt(1)
				|| str.charAt(2) == guess.charAt(0))
			matches++;

		if (matches >= count)
			return true;
		else
			return false;

	}

}

