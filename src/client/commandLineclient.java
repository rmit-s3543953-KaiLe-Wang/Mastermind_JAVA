package client;

import model.Mastermind;
import view.MastermindCallBack;

public class commandLineclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mastermind m = new Mastermind();
		MastermindCallBack cb = new MastermindCallBack(m);
		System.out.println("Welcome!");
		cb.commandLinePlay();
	}

}
