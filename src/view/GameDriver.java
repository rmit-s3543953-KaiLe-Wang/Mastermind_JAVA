package view;

import java.util.Scanner;

import model.Mastermind;

public class GameDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mastermind m = new Mastermind();
		Scanner s = new Scanner(System.in);
		System.out.print("please input target code: ");
		String rawTargetInput = s.nextLine();
		System.out.println("");
		System.out.print("please input guess code: ");
		String rawCodeInput = s.nextLine();
		System.out.println("");
		int[] target= {-1,-1,-1,-1};
		int[] code = {-1,-1,-1,-1};
		for(int i=0; i < Mastermind.COLORS_TO_GUESS;i++) {
			target[i]=Character.getNumericValue(rawTargetInput.charAt(i));
			code[i]=Character.getNumericValue(rawCodeInput.charAt(i));
		}
		m.setTarget(target);
		m.setGuess(code);
		s.close();
		System.out.println(m.checkCode());
	}

}
