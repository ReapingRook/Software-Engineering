package source;

// This class is used by the MonopolyTestSuite whenever a choice must be made inside a function.

public class ChoiceEngine {
	static int[] choices = new int[255];
	static int counter;
	
	public ChoiceEngine() {
		counter = 0;
		for(int i = 0; i < 255; i++) { choices[i] = 0; }
	}
	
	public static int getSpecificChoice(int index) {
		return choices[index];
	}
	
	public static int getNextNumber() {
		int out = choices[counter];
		System.out.println("Next number: " + out + " (counter: " + counter + ")");
		counter++;
		return out;
	}
	
	public static void changeChoice(int choice, int input) {
		choices[choice] = input;
	}
}
