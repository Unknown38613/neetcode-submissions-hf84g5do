class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < n - 2 ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] > 0) break;
            if(nums[i] + nums[n - 1] + nums[n - 2] < 0) continue;
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                int f = nums[i];
                int s = nums[l];
                int t = nums[r];
                if(f + s + t == 0){
                    List<Integer> tempList = Arrays.asList(f, s, t);
                    res.add(tempList);
                    l++;
                    r--;
                    while(l < r && nums[l] == s) l++;
                    while(l < r && nums[r] == t) r--; 
                }
                else if(f + s + t < 0) l++;
                else r--;
            }
        }
        return res;
    }
}
