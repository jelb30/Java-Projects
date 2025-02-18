import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        final int[] arr = {3,2,1};
        System.out.println(Arrays.toString(selectionSort(Arrays.copyOf(arr, arr.length))));

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time it took to complete "+totalTime/1000+"ms");
    }

    public static int[] selectionSort(int[] arr){
        int len = arr.length;
        int minIndex = 0;
        int temp = 0;
        int minVal = 0;

        for (int i = 0; i < len-1 ; i++) {
            minIndex=i;
            minVal = arr[i];
            for (int j = i+1 ; j < len ; j++) {
                if(minVal > arr[j]){
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            temp = arr[i]; //SWAPPING 
            arr[i] = minVal;
            arr[minIndex] = temp;
        }
        return arr;
    }
}
