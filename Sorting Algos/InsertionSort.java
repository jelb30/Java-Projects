import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] arr = {3,2,1};
        System.out.println(Arrays.toString(insertionSort(arr)));

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time it took to complete "+totalTime/1000+"ms");
    }

    public static int[] insertionSort(int[] arr){
        int len = arr.length;
        int temp = 0;
        int k = 0;
        for (int i = 0; i < len-1 ; i++) {
            k = i ;
            if(arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;

                while(k>0 && arr[k]<arr[k-1]){
                    temp = arr[k];
                    arr[k] = arr[k-1];
                    arr[k-1] = temp;
                    k--;
                }

            }
            
        }
        return arr;
    }

    }
}
