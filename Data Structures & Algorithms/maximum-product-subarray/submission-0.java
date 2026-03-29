class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            int cur = nums[i];

            int tempMax = maxSoFar;

            maxSoFar = Math.max(cur, Math.max(maxSoFar * cur, minSoFar * cur));

            minSoFar = Math.min(cur, Math.min(tempMax * cur, minSoFar * cur));

            result = Math.max(result, maxSoFar); 
        }

        return result;
    }
}