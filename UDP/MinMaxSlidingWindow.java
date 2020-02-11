package distributed_systems_assignment1.UDP;

import java.util.*;



public class MinMaxSlidingWindow {


    public void FindMinMax(int[] array, int numElem, int slidingWindowSize) {
        
        int k=0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = slidingWindowSize-1;
        for(int i=0; i<(numElem-slidingWindowSize); i++) {
            while(k < slidingWindowSize) {
                sum += array[k++];
            }
            maxSum = sum > maxSum ? sum : maxSum; 
            minSum = sum < minSum ? sum : minSum;
            sum -= array[start++];
            sum += array[++end];
            //System.out.println("i:"+i+"start:"+start+"end:"+end); 
        }
        maxSum = sum > maxSum ? sum : maxSum; 
        minSum = sum < minSum ? sum : minSum;
        minSum = minSum == Integer.MAX_VALUE ? 0 : minSum;
        maxSum = maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    // Your implementation
    }

    public static void main(String args[] ){
        MinMaxSlidingWindow msw = new MinMaxSlidingWindow();
        int[] array = new int[]{1,2,4,5,3,6,3,7};
        int numElem = 8;
        int slidingWindowSize = 3;
        msw.FindMinMax(array, numElem, slidingWindowSize);
    }
}