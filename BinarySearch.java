//leetcode 704

class Solution {
    public int search(int[] nums, int target) {
        int lt = 0, rt = nums.length - 1;

        // if(lt==rt && nums[lt]==target) {
        //     return lt;
        // }

        while(lt+1 < rt){
            int mid = (lt+rt)/2;

            // if(nums[mid]==target){
            //     return mid;
            // }
            // else 
            if(nums[mid]>target){
                rt = mid;
            }
            else{
                lt = mid;
            }
        }
        if(nums[lt]==target){return lt;}
        else if(nums[rt]==target){return rt;}
        return -1;
    }
}