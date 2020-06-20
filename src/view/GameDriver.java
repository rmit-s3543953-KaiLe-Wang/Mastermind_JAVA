package view;

import java.util.Arrays;
import java.util.Scanner;

import model.Mastermind;

public class GameDriver {

	public final static int ALLOWED_RETRY = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		commandLinePlay();
	}

	public static void commandLinePlay() {
		Scanner s = new Scanner(System.in);
		System.out.print("Would you like duplicate color pegs? ");
		String rawModeInput = s.nextLine();
		boolean mode = false;
		if (rawModeInput.equals("Y")) {
			mode = true;
		} else if (rawModeInput.equals("N")) {
			mode = false;
		}
		Mastermind m = new Mastermind(mode);
		/*
		 * System.out.print("please input target code: "); String rawTargetInput =
		 * s.nextLine(); System.out.println("");
		 */
		int[] code = { -1, -1, -1, -1 };
		int roundCount = 0;
		while (m.judge() == false && roundCount < ALLOWED_RETRY) {
			System.out.println("Round: " + (roundCount + 1));
			do {
				System.out.println("please input guess code: ");
				String rawCodeInput = s.nextLine();
				// int[] target= {-1,-1,-1,-1};
				for (int i = 0; i < Mastermind.COLORS_TO_GUESS; i++) {
					// target[i]=Character.getNumericValue(rawTargetInput.charAt(i));
					code[i] = Character.getNumericValue(rawCodeInput.charAt(i));
				}
				m.setGuess(code);
				if (Arrays.equals(m.getGuess(), Mastermind.ERROR_CODE))
					System.out.println("ERROR - invalid input");
			} while (Arrays.equals(m.getGuess(), Mastermind.ERROR_CODE));
			System.out.println("Responds: " + m.checkCode());
			roundCount++;
		}
		end(m);
		s.close();
	}

	public static void end(Mastermind m) {
		System.out.println("Rounds end!");
		System.out.println(m.judge() == true ? "Congrats, you win!" : "you lose!");
		System.out.println("Correct answer: " + m.getTarget());
	}
}
