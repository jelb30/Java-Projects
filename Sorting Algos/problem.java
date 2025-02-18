import java.util.ArrayList;
import java.util.Arrays;

import javax.management.ListenerNotFoundException;
import javax.sound.sampled.ReverbType;

public class problem {
    public static void main(String[] args) {

        // System.out.println(checkPallindrom(-121));

        // System.out.println(factorial(10));

        // System.out.println(trailingZeros(10));

        // System.out.println(getGDC(13, 18));

        // System.out.println(getLCM(12, 18));

        // System.out.println(checkPrime(1031));

        // System.out.println(quadratic(752, 904, 164));

        // System.out.println(digitsInFactorial(19));
        
        // System.out.println(termOfgp(2, 3, 5));

        // System.out.println(isPrime(17));

        // System.out.println(exactly3Divisors(49));

        // System.out.println("START");
        // allDivisors(100);
        // System.out.println("END");

        // addIntArray(new int[]{9,9,9,9,9,9,9}, new int[]{9,9,9,9});

        //System.out.println(sumUnderModulo(922, 92));

        //recurssion(5);

        //System.out.println(sumOfDigits(99999)); 

        System.out.println(countDigits(391));
    }

    public static boolean checkPallindrom(int n){
        int ogInt = n;
        int sum =0;
        while(n>0){
            sum = sum*10 + (n%10);
            n/=10;
        }
        if(sum==ogInt){
            return true;
        }
        
        return false;
    }

    public static long factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    // LAST ZEROES
    public static int trailingZeros(int n){
        long fact = factorial(n);
        int count=0;
        while(fact%10==0){
            count++;
            fact/=10;
        }
        return count;
    }

    // GCD
    public static int getGDC(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return getGDC(b, a%b);
        }
    }
    
    //FORMULA
    // a*b = gcd(a,b) * lcm(a,b)
    public static int getLCM(int a, int b){
        return (a*b)/getGDC(a, b);
    }

    public static boolean checkPrime(int n){
        if(n==1){
            return false;
        }
        if(n==2 || n==3){
            return false;
        }
        if(n%2==0 || n%3==0){
            return false;
        }
        for (int i = 5; i*i <= n ; i=i+6) {
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Double> quadratic(int a, int b, int c){
        ArrayList<Double> ls = new ArrayList<>();
        int d = (b*b)-(4*(a*c));
        if(d<0){
            ls.add(-1.0);
        }
        else{
            ls.add((-b-Math.sqrt(d))/(2*a));
            ls.add((-b+Math.sqrt(d))/(2*a));
        }
        return ls;
    }

    public static int digitsInFactorial(int N){
        // code here
        Long fact = factorial(N);
        int count=0;
        while(fact>0){
            count++;
            fact/=10;
        }
        return count;
    }

    public static double termOfgp(int A, int B, int N){
        double r = (double)B/(double)A;
        return (A*(Math.pow(r,N-1)));
    }

    public static boolean isPrime(int N) {
        // code here
        for (int i = 2; i <= N/2; i++) {
            if(N%i==0){
                return false;
            }
        }
        return true;
      }

    public static int exactly3Divisors(int N){
        int count=0;
        int subCount=0;
        for (int i = 4; i <=N; i++) {
            for (int j = 2; j <=i/2; j++) {
                if(i%j==0){
                    subCount++;
                }
            }
            if(subCount==1){
                count++;
                System.out.println(i);
            }
            subCount=0;
        }
        return count;
    }
    /*
    public static long sumUnderModulo(Long a, Long b){
        // code here
        long s1=a%(long)(Math.pow(10,9)+7);
        long s2=b%(long)(Math.pow(10,9)+7);
        long s3=(s1+s2)%(long)(Math.pow(10,9)+7);
        return s3;
    } 

    public static long mulUnderModulo(Long a, Long b){
        long s1=a%(long)(Math.pow(10,9)+7);
        long s2=b%(long)(Math.pow(10,9)+7);
        long s3=(s1*s2)%(long)(Math.pow(10,9)+7);
        return s3;
    }
    */

    public static void allDivisors(int n){
        int count =1;
        for (count = 1; count*count <=n ; count++) {
            if(n%count==0){
                System.out.println(count);
            }
        }
        if((count-1) == n/(count-1)){
            count--;
        }
        for(; count>=1;count--){
            if(n%count==0){
                System.out.println(n/count);
            }
        }
    }

    public static void addIntArray(int[] arr1, int[] arr2){
        ArrayList<Integer> arrlist = new ArrayList<>();
        int arrSum1 = 0;
        int arrSum2 = 0;

        for (Integer integer : arr1) {
            arrSum1 = arrSum1*10 + integer;
        }
        for (Integer integer : arr2) {
            arrSum2 = arrSum2*10 + integer;
        }
         
        int finalSum = arrSum1+arrSum2;

        while(finalSum>0){
            arrlist.add(finalSum%10);
            finalSum/=10;
        }
        
    }

    public static void recurssion(int n){
        if(n==0){
            return;
        }
        recurssion(n-1);
        System.out.println(n);
    }

    public static int sumOfDigits(int n)
    {
        // add your code here
        if(n==0){
            return 0;
        }
        int sum = n%10;
        return sum+sumOfDigits(n/10);
    }

    public static int countDigits(int n)
    {
        // add your code here
        if(n==0){
            return 1;
        }
        int count = 0;
        while(true){
            if(n-(Math.pow(10, count))>=0){
               count++; 
               continue;
            }
            break;
        }
        return count;
    }
}
