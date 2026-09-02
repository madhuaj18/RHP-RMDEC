//leetcode 189

class Solution {
    public void reverse(int[] nums, int lt, int rt){
        int temp;
        while(lt<rt){
            temp = nums[lt];
            nums[lt] = nums[rt];
            nums[rt] = temp;
            lt++;
            rt--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
}