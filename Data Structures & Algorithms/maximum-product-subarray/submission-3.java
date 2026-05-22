class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int maxprod = nums[0];
        int maxsofar = nums[0];
        int minsofar = nums[0];

        for(int i = 1 ; i < n ; i++){
            int curr = nums[i];

            if(curr < 0){
                int temp = maxsofar;
                maxsofar = minsofar;
                minsofar = temp;
            }

            maxsofar = Math.max(curr, maxsofar * curr);
            minsofar = Math.min(curr, minsofar * curr);

            maxprod = Math.max(maxprod, maxsofar);
        }

        return maxprod;
    }
}