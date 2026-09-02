//leetcode 494

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        List<Integer> currlist = new ArrayList<>();
        
        int N = nums.length;
        
         if(N==1 && nums[0] == 0 && target==0){
            return 2;
        }
        
        else if(N==1 &&( nums[0]==target || nums[0]==-target)){
            return 1;
        }
        else if(N==1){
            return 0;
        }
        currlist.add(nums[0]);
        currlist.add(-nums[0]);

        for(int i=1;i<N;i++){
            List<Integer> newlist = new ArrayList<>();
            for(int a: currlist){
                newlist.add(a+nums[i]);
                newlist.add(a-nums[i]);
            }
           currlist = newlist;
           
        }
        int count=0;
        
        for(int a: currlist){
            if(a==target) count++;
        }
        return count;
    }
}