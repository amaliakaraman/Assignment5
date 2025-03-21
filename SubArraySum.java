import java.util.*;

public class SubArraySum {
    public static int[] sumTarget(int[]A,int K){
        int left=0,sum=0; //left pointer and sum
        for(int right=0;right<A.length;right++){ //iterate array
            sum+=A[right]; //add current element to sum
            while(sum>K)sum-=A[left++]; //shrink if sum exceeds k
            if(sum==K)return new int[]{left,right}; //return indices if sum matches k
        }
        return new int[]{-1,-1}; //return [-1,-1] if no subarray found
    }
    public static void main(String[]args){
        int[]A={1,2,3,7,5}; //input array
        int K=12; //target sum
        System.out.println(Arrays.toString(sumTarget(A,K))); //print result
    }
}
