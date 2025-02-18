import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        int[] arr1 = {0,3,4,5,6,10,12,18,31};
        int[] arr2 = {4,30,32};

        System.out.println(Arrays.toString(mergeSort(arr1, arr2)));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time it took to complete "+totalTime/1000+"ms");

    }

    public static int[] mergeSort(int[] arr1, int[] arr2){

        int[] merged = new int[arr1.length + arr2.length];
        int indArr1 = 0; //FOR MANAGING ARRAY1 INDEX
        int indArr2 = 0;  //FOR MANAGING ARRAY1 INDEX

        while(true){
            // LOOP STARTS
            if((indArr1+indArr2)>merged.length-1){ // FOR BREAKING WHILE AFTER COMPLETION OF SORTING!
                break;
            }

            if(indArr1 == arr1.length){ // FOR CHEKING INDEXING OF ARRAY1!
                while(merged[merged.length-1]==0){
                    merged[(indArr1+indArr2)] = arr2[indArr2];
                    indArr2++;
                }
                break;
            }
            
            if(indArr2 == arr2.length){ // FOR CHEKING INDEXING OF ARRAY2!
                while(merged[merged.length-1]==0){
                    merged[(indArr1+indArr2)] = arr1[indArr1];
                    indArr1++;
                }
                break;
            }

            if(arr1[indArr1]<= arr2[indArr2]){ // CHEKING ARRAY VALUES GREATER OR LESSER!
                merged[(indArr1+indArr2)] = arr1[indArr1];
                indArr1++;
                continue;

            }

            if(arr1[indArr1]> arr2[indArr2]){  // CHEKING ARRAY VALUES GREATER OR LESSER!
                merged[(indArr1+indArr2)] = arr2[indArr2];
                indArr2++;
                continue;
            }
            
            // LOOP ENDS
        }
        return merged;
    }
}
