package test;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Mastermind;

class MastermindTest {
	Mastermind m = new Mastermind();
	String messageBlock = "----------------------";
	//checkCode() test1: valid input pairs, suppose to get CW
	@Test
	void checkCodetest1() {
		System.out.println("checkCode() test1");
		int[] code = {1,2,3,4};
		int[] target= {1,3,1,1};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: CW");
		Assert.assertTrue(m.checkCode().equals("CW"));
	}
	//checkCode() test2: valid input pairs, suppose to get CCW
	@Test
	void checkCodetest2() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test2");
		int[] code = {1,2,3,4};
		int[] target= {1,2,4,1};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: CCW");
		Assert.assertTrue(m.checkCode().equals("CCW"));
	}
	//checkCode() test3: valid input pairs, suppose to get CCCW
	@Test
	void checkCodetest3() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test3");
		int[] code = {1,2,3,4};
		int[] target= {1,2,3,4};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: CCCW->not gonna happen");
		Assert.assertFalse(m.checkCode().equals("CCCW"));
	}
	//checkCode() test4: valid input pairs, suppose to get CCCC
	@Test
	void checkCodetest4() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test4");
		int[] code = {1,2,3,4};
		int[] target= {1,2,3,4};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: CCCC");
		Assert.assertTrue(m.checkCode().equals("CCCC"));
	}
	//checkCode() test5: valid input pairs, suppose to get W
	@Test
	void checkCodetest5() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test5");
		int[] code = {1,2,3,4};
		int[] target= {5,5,5,1};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: W");
		Assert.assertTrue(m.checkCode().equals("W"));
	}
	//checkCode() test6: valid input pairs, suppose to get WW
	@Test
	void checkCodetest6() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test6");
		int[] code = {1,2,3,4};
		int[] target= {2,1,1,1};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: WW");
		Assert.assertTrue(m.checkCode().equals("WW"));
	}	
	//checkCode() test7: valid input pairs, suppose to get WWW
	@Test
	void checkCodetest7() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test7");
		int[] code = {1,2,3,4};
		int[] target= {4,3,2,2};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: WWW");
		Assert.assertTrue(m.checkCode().equals("WWW"));
	}
	//checkCode() test8: valid input pairs, suppose to get WWWW
	@Test
	void checkCodetest8() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test8");
		int[] code = {1,2,3,4};
		int[] target= {4,3,1,2};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: WWWW");
		Assert.assertTrue(m.checkCode().equals("WWWW"));
	}
	//checkCode() test9: valid input pairs, suppose to get NOTHING
	@Test
	void checkCodetest9() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test9");
		int[] code = {5,5,5,5};
		int[] target= {1,2,3,4};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: ");
		Assert.assertTrue(m.checkCode().equals(""));
	}
	//checkCode() test10: invalid input pairs, suppose to get error message
	@Test
	void checkCodetest10() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test10");
		int[] code = {};
		int[] target= {};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: ");
		Assert.assertTrue(m.checkCode().equals(""));
	}
	//checkCode() test11: invalid input pairs, suppose to get error message
	@Test
	void checkCodetest11() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test11");
		int[] code = {1,1,1,1,1,1,1,1,1};
		int[] target= {1,1,1,1,1,1,1,1,1,2,3,4,5,6};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: ");
		Assert.assertTrue(m.checkCode().equals(""));
	}
	//checkCode() test12: invalid input pairs, suppose to get error message
	@Test
	void checkCodetest12() {
		System.out.println(messageBlock);
		System.out.println("checkCode() test12");
		int[] code = {-5,-6,-777,-245,-34534};
		int[] target= {-5,-6,-777,-245,-34534};
		m.setGuess(code);
		m.setTarget(target);
		System.out.println("got: "+m.checkCode()+", expected: ");
		Assert.assertTrue(m.checkCode().equals(""));
	}	
}
