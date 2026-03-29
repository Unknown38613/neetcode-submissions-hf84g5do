class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int[] c;
    private int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.c = candidates;
        this.target = target;
        dfs(0, new ArrayList<>(), 0);
        return ans;
    }
    
    private void dfs(int i, List<Integer> path, int sum){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(i >= c.length || sum > target) return;

        // Skip duplicates at this depth!
        int next = i + 1;
        while (next < c.length && c[next] == c[i]) next++;

        // Choose c[i]
        path.add(c[i]);
        dfs(i + 1, path, sum + c[i]);
        path.remove(path.size() - 1);

        // Skip all duplicates of c[i]
        dfs(next, path, sum);
    }
}