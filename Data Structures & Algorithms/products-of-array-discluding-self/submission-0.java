class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            res[i] = res[i - 1] * nums[i];
        }
        int suffix = 1;
        for(int i = res.length - 1; i >= 1 ; i--){
            res[i] = res[i - 1] * suffix;
            suffix *= nums[i]; 
        }
        res[0] = suffix;
        return res;
    }
}  