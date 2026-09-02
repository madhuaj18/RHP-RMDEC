//This code is accepted in LeetCode

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n-2; i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int lt=i+1;
            int rt=n-1;

            while(lt<rt){
                int sum = nums[i]+nums[lt]+nums[rt];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[lt], nums[rt]));
                    
                    while(lt+1<n-1 && nums[lt]== nums[lt+1]) lt++;
                    lt++;
                }
                else if(sum<0){
                    lt++;
                }
                else{
                    rt--;
                }
            }
        }
        return result;
    }
}