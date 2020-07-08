package view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Mastermind;

public class MastermindCallBack {

	public final static int ALLOWED_RETRY = 5;
	private static final Logger logger = Logger.getLogger(MastermindCallBack.class.getName());
	static Mastermind m;
	public MastermindCallBack(Mastermind engine) {
		 logger.setLevel(Level.FINE);
		 m=engine;
	}
	public void commandLinePlay() {
		Scanner s = new Scanner(System.in);
		System.out.print("Would you like duplicate color pegs? ");
		String rawModeInput = s.nextLine();
		boolean mode = false;
		if (rawModeInput.equals("Y")) {
			mode = true;
		} else if (rawModeInput.equals("N")) {
			mode = false;
		}
		m.setMode(mode);
		int[] code = { -1, -1, -1, -1 };
		int roundCount = 0;
		while (m.judge() == false && roundCount < ALLOWED_RETRY) {
			System.out.println("Round: " + (roundCount + 1));
			logger.fine("Round: " + (roundCount + 1));
			do {
				System.out.println("please input guess code: ");
				String rawCodeInput = s.nextLine();
				logger.fine("GOT input:"+rawCodeInput);
				for (int i = 0; i < Mastermind.COLORS_TO_GUESS; i++) {
					code[i] = Character.getNumericValue(rawCodeInput.charAt(i));
				}
				m.setGuess(code);
				if (Arrays.equals(m.getGuess(), Mastermind.ERROR_CODE))
					System.out.println("ERROR - invalid input");
			} while (Arrays.equals(m.getGuess(), Mastermind.ERROR_CODE));
			System.out.println("Responds: " + m.checkCode());
			logger.fine("GOT RESPONDS: "+ m.checkCode());
			roundCount++;
		}
		result();
		s.close();
	}

	public static void result() {
		System.out.println("Rounds end!");
		System.out.println(m.judge() == true ? "Congrats, you win!" : "you lose! "+"Correct answer: " + m.getTarget());
	}
}
