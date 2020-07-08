package model;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Mastermind {

	private static boolean isDuplicateColorsAllowed;
	
	static int[] guess= {-3,-3,-3,-3};
	static int[] targetCode= {-3,-3,-3,-3};
	
	public static final int[] ERROR_CODE= {-3,-3,-3,-3};
	public static final int COLORS_TO_GUESS = 4;
	static final int CHECKED_TARGET =-2;
	static final int CHECKED_CODE =-1;
	static final int[] EMPTY_SET = {};
	
	//color declaration
	enum Color{
		BLUE,
		RED,
		GREEN,
		YELLOW,
		PINK,
		WHITE
	}
	public Mastermind() {
		isDuplicateColorsAllowed=false;
		targetCode=randomTargetGen();
	}
	public boolean judge() {
		return checkCode().equals("CCCC");
	}
	private static int[] randomTargetGen() {
		int[] result= {0,0,0,0};
		if(isDuplicateColorsAllowed) {
			for(int i =0;i<COLORS_TO_GUESS;i++) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, Color.values().length + 1);
				result[i]=randomNum;
			}
		}
		else {
			int[] indexCandidates = {0,1,2,3,4,5}; 
			ArrayList<Integer> candidates= new ArrayList<Integer>();
			for(int i : indexCandidates) {
				candidates.add(i);
			}
			for(int i =0;i<COLORS_TO_GUESS;i++) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, candidates.size());
				result[i]=candidates.get(randomNum);
				candidates.remove(randomNum);
			}
		}
		return result;
	}
	public void setMode(boolean mode) {
		isDuplicateColorsAllowed=mode;
	}
	public void setGuess(int[] code) {
		//check value is valid, if found empty set or invalid code then return error.
		for(int i=0;i<code.length;i++) {
			if(code[i]>Color.values().length-1||code[i]<0||Arrays.equals(code,EMPTY_SET)) {
				guess = ERROR_CODE;
				return;
			}
		}
		//check array size, if not right then return error.
		if(code.length==COLORS_TO_GUESS)
			guess = code;
		else
			guess = ERROR_CODE;
	}
	public int[] getGuess() {
		return guess;
	}
	public void setTarget(int[] target) {
		for(int i=0;i<target.length;i++) {
			if(target[i]>Color.values().length-1||target[i]<0||Arrays.equals(target,EMPTY_SET)) {
				target = ERROR_CODE;
				return;
			}
		}
		if(target.length==COLORS_TO_GUESS)
			targetCode = target;
		else
			targetCode = ERROR_CODE;
	}
	public String getTarget() {
		String message = new String(Arrays.toString(targetCode));
		return message;
	}
	
	public String checkCode() {
		if(guess!=null&&targetCode!=null) {
			if(!Arrays.equals(guess, EMPTY_SET)||!Arrays.equals(targetCode, EMPTY_SET))
				return checkCode(guess,targetCode);
		}
		return "";
	}
	public String checkCode(int[] code,int[] target) {
		String result = new String("");
		if(code.length!=target.length) {
			return result;
		}
		if(Arrays.equals(code, ERROR_CODE)||Arrays.equals(target, ERROR_CODE)) {
			return result;
		}
		//create array copies that don't affect the origin
		int[] localCode = code.clone();
		int[] localTarget = target.clone();
		//check if there is colored peg
		for(int i=0;i<localTarget.length;i++) {
			if(localCode[i]==localTarget[i]) {
				result+="C";
				localCode[i]=CHECKED_CODE;
				localTarget[i]=CHECKED_TARGET;
			}
		}
		//then, check if there is white peg 
		for(int i =0; i < localTarget.length;i++) {
			for(int j=0; j<localCode.length;j++) {
				if(localCode[i]==localTarget[j]) {
					result+="W";
					localCode[i]=CHECKED_CODE;
					localTarget[j]=CHECKED_TARGET;
				}
			}
		}
		return result;
	}
}
