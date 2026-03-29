class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i <= nums.length ; i++){
            list.add(new ArrayList<>());
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.get(entry.getValue()).add(entry.getKey());
        }
        int[] ans = new int[k];
        int count = k;
        int index = 0;
        for(int i = nums.length ; i >= 0 ; i--){
            if(count == 0) break;
            List<Integer> curr = list.get(i);
            if(!curr.isEmpty()){
                for(int n : curr){
                    ans[index++] = n;
                    count--;
                }
            }
        }
        return ans;
    }
}
