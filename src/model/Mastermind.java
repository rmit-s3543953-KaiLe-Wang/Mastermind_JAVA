package model;
import java.util.*;
public class Mastermind {

	private static Map<Integer,Color> indexToColor;
	private static List<int[]> combinations;
	private static List<int[]> candidateSolutions;
	
	static int[] guess= {-3,-3,-3,-3};
	static int[] targetCode= {-3,-3,-3,-3};
	
	private static final int[] ERROR_CODE= {-3,-3,-3,-3};
	public static final int COLORS_TO_GUESS = 4;
	static final int CHECKED_TARGET =-2;
	static final int CHECKED_CODE =-1;
	
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
		init();
	}
	public void setGuess(int[] code) {
		if(code.length==COLORS_TO_GUESS)
			guess = code;
	}
	public String getGuess() {
		String message = new String(guess.toString());
		return message;
	}
	public void setTarget(int[] target) {
		if(target.length==COLORS_TO_GUESS)
			targetCode = target;
	}
	public String getTarget() {
		String message = new String(targetCode.toString());
		return message;
	}
	public static void init() {
		indexToColor = new HashMap<>();
		for(int i =0; i <Color.values().length;i++) {
			indexToColor.put(i,Color.values()[i]);
		}	
		combinations = new ArrayList<>();
		//Set<Integer> keys = indexToColor.keySet();
		combinations=createCombinations(new int[COLORS_TO_GUESS],indexToColor.size());
		candidateSolutions=createCombinations(new int[COLORS_TO_GUESS],indexToColor.size());
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
	public String checkCode() {
		if(guess!=null&&targetCode!=null)
			return checkCode(guess,targetCode);
		else
			return "ERROR- EMPTY DATA";
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
	public static void main(String[] args) {
		//create sets
		init();
		//get response from first guess
		//if won, terminate program with winning message
		/*TODO
		 * guess code function()
		 *     
		 * judge code that decides game end
		 * 
		 * remove from S any code that would not give the same response if the current guess were the code.
		 * 
		 * vector<vector<int>> minmax() {

    map<string, int> scoreCount;
    map<vector<int>, int> score;
    vector<vector<int>> nextGuesses;
    int max, min;

    for (int i = 0; i < combinations.size(); ++i) {

        for (int j = 0; j < candidateSolutions.size(); ++j) {

            string pegScore = checkCode(combinations[i], candidateSolutions[j]);
            if (scoreCount.count(pegScore) > 0) {
                scoreCount.at(pegScore)++;
            }
            else {
                scoreCount.emplace(pegScore, 1);
            }
        }

        max = getMaxScore(scoreCount);
        score.emplace(combinations[i], max);
        scoreCount.clear();
    }

    min = getMinScore(score);

    for (auto elem : score) {
        if (elem.second == min) {
            nextGuesses.push_back(elem.first);
        }
    }

    return nextGuesses;
}
		*/
	}
	public static void printCombinationsInColor(List<int[]> combinations,Map<Integer,Color> indexToColor) {
		for (int[] combination : combinations) {
		    for(int colorIndex : combination) {
			System.out.print(indexToColor.get(colorIndex)+" ");
		    }
		    System.out.println();
		}
		System.out.println("total combinations: "+combinations.size());
	}

}
