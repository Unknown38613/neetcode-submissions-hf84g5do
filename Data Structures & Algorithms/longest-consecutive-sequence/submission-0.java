class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int n : nums) set.add(n);
        for(int i = 0 ; i < nums.length ; i++){
            int curr = nums[i];
            int count = 1;
            if(!set.contains(curr - 1)){
                while(set.contains(curr + 1)){
                    count += 1;
                    curr += 1;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
