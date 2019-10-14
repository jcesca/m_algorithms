package AlgorithmsLogicalMethodsAssignment;

import java.util.Scanner;

public class Question4Exponentiation {

	static Scanner input = new Scanner(System.in);

	// main method
	public static void main(String[] args) {

		while (true) {
			int x = readFromConsole("Enter the base (x) value:");
			int n = readFromConsole("Enter the power (n) value:");

			System.out.println("Result: " + expBySquaring(x, n) + "\n");			
		}

	} // end of main method

	// Method to read from Console
	public static int readFromConsole(String message) {
		System.out.print(message + " ");
		int rst = input.nextInt();
		return rst;
	} // end of readFromConsole method

	// Method to calculate exponentiation by squaring
	public static double expBySquaring(double x, double n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		} else if (n < 0) {
			return expBySquaring(1 / x, n * -1);
		} else if (n % 2 == 0) {
			return expBySquaring(x * x, n / 2);
		} else {
			return (x * expBySquaring(x * x, (n - 1) / 2));
		}
	}// end of expBySquaring

} // end of class
