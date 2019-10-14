package AlgorithmsLogicalMethodsAssignment;

import java.util.Scanner;

public class Question3Fibonacci {

	public static void main(String[] args) {
		int n = readFromConsole();
		
		System.out.println("\nFibonacci Recursive");
		fibonacciRecursive(0, 1, n);
		
		System.out.println("\n\nFibonacci Non Recursive");
		fibonacciNonRecursive(n);
	} // end of main method
	
	// Method to read from Console
	public static int readFromConsole() {
		Scanner input = new Scanner(System.in);
		System.out.print("How many numbers of the Fibonacci sequence? ");
		int rst = input.nextInt();
		input.nextLine();
		input.close();
		return rst;
	} // end of readFromConsole method
	
	// Method to recursively calculate Fibonacci sequence
	public static void fibonacciRecursive(long beforeLastElement, long lastElement, int remaining) {
		if (remaining > 0) { // recursion stopper
			
			// For the first two elements, print straight to console and decrease remaining counter
			if ( (beforeLastElement == 0) && (lastElement == 1) ) {
				System.out.print("0 1 ");
				remaining = remaining - 2;
			}
			
			// Calculate and print next element
			long nextElement = beforeLastElement + lastElement;
			System.out.print(nextElement + " ");
			
			// Call the function again, providing new elements
			fibonacciRecursive(lastElement, nextElement, remaining - 1);			
		}
	} // end of fibonacciRecursive
	
	// Method to calculate Fibonacci sequence without recursion
	public static void fibonacciNonRecursive(int amount) {
		// Set first elements, print and decrease the amount counter
		long beforeLastElement = 0;
		long lastElement = 1;
		System.out.print("0 1 ");
		amount = amount - 2;
		
		// For the other elements, keep calculating until it's over
		while (amount > 0) {
			long nextElement = beforeLastElement + lastElement;
			System.out.print(nextElement + " ");
			beforeLastElement = lastElement;
			lastElement = nextElement;
			amount--;
		}
	} // end of fibonacciNonRecursive

} // end of class
