package AlgorithmsLogicalMethodsAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Question2QuickSort {

	public static void main(String[] args) {
		// create Integer Array to store user input
		int nums[] = readArrayFromConsole();

		// Show initial values
		System.out.println("\nInitial Array: " + Arrays.toString(nums));

		// Apply QuickSort
		quickSort(nums, 0, nums.length - 1);

		// Show Final Values
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
	} //end of readArrayFromConsole()

	// Recursive method to apply quickSort
	public static void quickSort(int[] list, int lower, int upper) {
		if (lower < upper) {
			// Find out the pivot to partition the array
			int pivot = partition(list, lower, upper);
			
			// call quickSort (recursively)
			quickSort(list, lower, pivot - 1);
			quickSort(list, pivot + 1, upper);
		}
	} // end of quickSort method

	// Method that sorts a partition
	public static int partition(int[] list, int lower, int upper) {

		while (lower < upper) {
			
			// while the order between lower and upper is right, move upper down
			while (list[lower] < list[upper]) {
				upper--;
			}
			// When the order is not right, swap elements and move lower up
			swap(list, lower, upper);
			if (upper != lower) {// condition to avoid upper becoming < lower
				lower++;
			}

			// while the order between lower and upper is right, move lower up
			while (list[lower] < list[upper]) {
				lower++;
			}
			// When the order is not right, swap elements and move upper down
			swap(list, lower, upper);
			if (upper != lower) { // condition to avoid upper becoming < lower
				upper--;
			}
		} // end of while

		return lower;
	} // end of partition method

	// Method that swaps two elements from an array
	public static void swap(int[] list, int index1, int index2) {
		int temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	} // end of swap method

} // end of class
