package AlgorithmsLogicalMethodsAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Question1MergeSort {

	public static void main(String[] args) {

		// create Integer Array to store user input
		int nums[] = readArrayFromConsole();

		// 
		System.out.println("\nInitial Array: " + Arrays.toString(nums));
		nums = breakArray(nums);
		System.out.println("Sorted Array:  " + Arrays.toString(nums));
	} // end of main method

	// Method to read, store and display the Array
	public static int[] readArrayFromConsole() {
		Scanner input = new Scanner(System.in);

		// Getting the Array size from the user
		System.out.print("How many numbers do you want to enter? ");
		int arraySize = input.nextInt();

		int[] rstArray = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			System.out.print("Enter value for position [" + i + "]: ");
			rstArray[i] = input.nextInt();
		}

		// close the user input
		input.close();

		// Display the result(rst) Array
		return rstArray;
	} // end of readArrayFromConsole method

	// Method to break the Array recursively until it gets to size 1
	public static int[] breakArray(int[] myArray) {

		// System.out.println("myArray: " + myArray.toString());

		if (myArray.length > 1) {
			int size = myArray.length;
			int newSize = size / 2;

			int[] a1 = new int[newSize];
			int[] a2 = new int[size - newSize];

			// Populate first array (a1)
			for (int i = 0; i < newSize; i++) {
				a1[i] = myArray[i];
			}

			// Populate second array (a2)
			for (int i = newSize; i < size; i++) {
				a2[i - newSize] = myArray[i];
			}

			a1 = breakArray(a1);
			a2 = breakArray(a2);

			// Call mergeSort to merge both arrays and sort them
			int[] rstArray = mergeSort(a1, a2);

			return rstArray;

		} else {
			return myArray;
		}

	}// end of breakArray method

	// Method to merge 2 ordered arrays into one array
	public static int[] mergeSort(int[] first, int[] second) {

		// Create the new array with the size of the sum of both arrays size
		int[] rstArray = new int[first.length + second.length];
		int j = 0; // position on rstArray

		// Until one of the arrays is empty, compares the first element 
		// of each and move the smaller into the new array (last position) 
		while ((first.length > 0) && (second.length > 0)) {
			if (first[0] < second[0]) {
				rstArray[j] = first[0];
				first = removeFirstElement(first);
				j++; // increments the position on rstArray
			} else {
				rstArray[j] = second[0];
				second = removeFirstElement(second);
				j++; // increments the position on rstArray
			}
		}

		// Add the remaining items (in case there are any)
		while (first.length > 0) {
			rstArray[j] = first[0];
			first = removeFirstElement(first);
			j++; // increments the position on rstArray
		}

		// Add the remaining items (in case there are any)
		while (second.length > 0) {
			rstArray[j] = second[0];
			second = removeFirstElement(second);
			j++; // increments the position on rstArray
		}

		return rstArray;
	} // end of mergeSort method

	// Method to remove the first element on an array
	public static int[] removeFirstElement(int[] myArray) {
		int[] rst = new int[myArray.length - 1];

		for (int i = 1; i < myArray.length; i++) {
			rst[i - 1] = myArray[i];
		}

		return rst;
	} // end removeFirstElement method

} // end class
