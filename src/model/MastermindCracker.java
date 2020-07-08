package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Mastermind.Color;

public class MastermindCracker {
	Mastermind m;
	private static List<int[]> combinations;
	private static List<int[]> candidateSolutions;
	private static Map<Integer,Color> indexToColor;
	
	public MastermindCracker(Mastermind m) {
		this.m=m;
		init();
	}
	public void init() {
		indexToColor = new HashMap<>();
		for(int i =0; i <Color.values().length;i++) {
			indexToColor.put(i,Color.values()[i]);
		}	
		combinations = new ArrayList<>();
		//Set<Integer> keys = indexToColor.keySet();
		combinations=createCombinations(new int[Mastermind.COLORS_TO_GUESS],indexToColor.size());
		candidateSolutions=createCombinations(new int[Mastermind.COLORS_TO_GUESS],indexToColor.size());
		printCombinationsInColor();
	}
	private static List<int[]> createCombinations(int data[],int max){
		List<int[]> results = new ArrayList<>();
		for (int i =0 ; i<max;i++) {
			for (int j=0; j<max;j++) {
				for(int k=0;k<max;k++) {
					for(int l=0;l<max;l++) {
						int[] temp = {i,j,k,l};
						results.add(temp);
					}
				}
			}
		}
		return results;
	}
	public static void printCombinationsInColor() {
		for (int[] combination : combinations) {
		    for(int colorIndex : combination) {
			System.out.print(indexToColor.get(colorIndex)+" ");
		    }
		    System.out.println();
		}
		System.out.println("total combinations: "+combinations.size());
	}
}
