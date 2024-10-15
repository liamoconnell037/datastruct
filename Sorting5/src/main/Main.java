package main;

public class Main {
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
	public static void main(String[] args) {
		System.out.println("\t\tInsertion Sort: ");
		Integer[] array = createArray(15);
		System.out.print("Before: ");
		printArray(array);
		System.out.println("\n\n");
		ArraySorter.insertionSort(array, array.length);
		System.out.println("\n\nAfter: ");
		printArray(array);
	}

}
