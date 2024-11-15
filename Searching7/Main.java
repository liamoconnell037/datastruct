public class Main {
    public static void main(String[] args)   {
        Integer[] anArray = new Integer[] {5, 8, 10, 13, 15, 20, 22, 26, 30, 31, 34, 40};
        System.out.println(binarySearch(anArray, 0, anArray.length-1, 34));
    }

    private static <T> void printArray(T[] anArray, int first, int last) {
        for(int i = first; i <= last; i++) {
            System.out.print(anArray[i] + " ");
        }
        System.out.println();
    }

    private static <T extends Comparable<? super T>>
        boolean binarySearch(T[] anArray, int first, int last, T desiredItem)
    {
        printArray(anArray, first, last);
        boolean found;
        int mid = first + (last - first) / 2;
      
        if (first > last)
            found = false;
        else if (desiredItem.equals(anArray[mid]))
            found = true;
        else if (desiredItem.compareTo(anArray[mid]) < 0)
            found = binarySearch(anArray, first, mid - 1, desiredItem);
        else
            found = binarySearch(anArray, mid + 1, last, desiredItem);

        return found;
    } // end binarySearch
}