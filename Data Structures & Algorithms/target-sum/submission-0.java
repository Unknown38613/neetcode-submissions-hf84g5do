class Solution {
    private int[] nums;
    private Map<String, Integer> ways;
    private int findways(int i, int currsum, int target){
        if(i == nums.length && currsum == target) return 1;
        if(i >= nums.length) return 0;
        String state = i + ", " + currsum;
        if(ways.containsKey(state)) return ways.get(state);
        int add = findways(i + 1, currsum + nums[i], target);
        int sub = findways(i + 1, currsum - nums[i], target);
        int res = add + sub;
        ways.put(state, res);
        return res;
    }
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.ways = new HashMap<>();
        return findways(0, 0, target);
    }
}