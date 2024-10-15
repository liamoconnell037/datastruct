package main;
import java.util.HashMap;
public class Main {
	
	// Sort Integer array ascending
	public static  void countingSort(Integer[] array, int min, int max) {
		Integer[] temp = new Integer[max+1];
		for(int i = 0; i < temp.length;i++) { // default values because object, not primitive
			temp[i] = 0;
		}
		for(int i = 0; i < array.length;i++) {
			temp[array[i]]++;
		}
		int index = 0;
		for(int i = 0; i < temp.length;i++) {
			for(int j = 0;j < temp[i];j++) { 
				array[index++] = i;
			}
		}
		
		
		// my first way of doing it
//		HashMap<Integer, Integer> counter = new HashMap<>();
//		for(int i = 0; i < array.length;i++) {
//			if(!counter.containsKey(array[i])) //create pair with starting value of 1
//				counter.put(array[i], 1);
//			else //increment value by one
//				counter.replace(array[i], counter.get(array[i])+1);
//		}
//		int index = 0;
//		for(Integer key : counter.keySet()) { // loop through all keys
//			for(int i = 0; i < counter.get(key);i++) { // set array indices to amount of nums
//				array[index++] = key;
//			}
//		}
	}
	
	public static <T> void printArray(T[] array) {
		System.out.print("{ ");
		for(int i = 0; i < array.length;i++) {
			System.out.print(array[i]);
			if(i != array.length-1)
				System.out.print(", ");
		}
		System.out.println(" } ");
	}
	public static Integer[] createArray(int length) {
		Integer[] array = new Integer[length];
		for(int i = 0; i < array.length;i++) {
			array[i] = (int)(Math.random()*100+1);
		}
		return array;
	}
	public static Integer[] createArray(int length, int min, int max) {
		Integer[] array = new Integer[length];
		for(int i = 0; i < array.length;i++) {
			array[i] = (int)(Math.random()*(max+1 - min)+min);
		}
		return array;
	}
	public static void main(String[] args) {
		System.out.println("\t\tInsertion Sort: ");
		Integer[] array = createArray(15);
		System.out.print("Before: ");
		printArray(array);
		System.out.println();
		ArraySorter.insertionSort(array, array.length);
		System.out.println("\nAfter: ");
		printArray(array);
		
		System.out.println("\n\n\t\tSelection Sort: ");
		array = createArray(15);
		System.out.print("Before: ");
		printArray(array);
		System.out.println();
		ArraySorter.selectionSort(array, array.length);
		System.out.println("\nAfter: ");
		printArray(array);
		
		
		// part 2
		System.out.println("\n\t\tCounting Sort");
		array = createArray(15, 5, 15);
		System.out.print("Before: ");
		printArray(array);
		countingSort(array, 5, 15);
		System.out.print("\nAfter: ");
		printArray(array);
		
		// Part 3
		// (b) O(x + y), where x is length of array passed in and y is length of temp
		// array
		// (d) How useful?
		// This could be used on collections that are known to have duplicate values,
		// and a small range of numbers. If the range is large, this becomes inefficient.
		// It also requires the use of positive integers. This also uses a lot of memory 
		// space, so if the array passed in is large enough it could be a problem. 
		// So, this could have a use in very niche places, but I would prefer using other
		// algorithms.
	}

}
