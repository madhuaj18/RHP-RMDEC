//leetcode 396

public class Solution {
    public int maxRotateFunction(int[] nums) {
        int N =nums.length;
        if(N==1){
            return 0;
        }
       
        int sum=0;
        long fnval=0;

        for(int i=0;i<N;i++){
            sum+=nums[i];
            fnval += nums[i]*i;
        }
        long max = fnval;

        for(int i=N-1;i>0;i--){
            fnval = fnval + (sum-nums[i]) - (nums[i]*(N-1));
            if(fnval>max)
                max = fnval;
        }

        return (int)max;
    }
} {
    
}
