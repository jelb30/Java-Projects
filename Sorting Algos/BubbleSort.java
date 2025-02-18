import java.util.Arrays;

public class BubbleSort{
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] arr = {3,2,1};
        System.out.println("Without Sorting :"+Arrays.toString(arr));
        System.out.println("Sorted BubbleSort :"+Arrays.toString(bubbleSort(Arrays.copyOf(arr, arr.length))));

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time it took to complete "+totalTime/1000+"ms");
    }

    public static int[] bubbleSort(int[] arr){
        int index = 0;
        int temp = 0;
        int count = 0;
        while(true){
            if(count==0 && index==arr.length-1){
                break;
            }

            if(arr[index+1] < arr[index]){
                temp = arr[index+1];
                arr[index+1] = arr[index];
                arr[index] = temp;
                count++;
            }
            index++;
            if(count!=0 && index==arr.length-1){
                count=0;
                index=0;
            }
            
            
        }
        return arr;
    }

}