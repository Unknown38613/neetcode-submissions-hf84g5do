class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int[] c, int start, int remain, List<Integer> path, List<List<Integer>> ans) {
        if (remain == 0) {
            ans.add(new ArrayList<>(path));
            return;                               // terminal for this path
        }
        if (remain < 0) return;                   // prune
        for (int i = start; i < c.length; i++) {
            if(i > start && c[i] == c[i - 1]) continue;
            path.add(c[i]);                       // choose c[i]
            dfs(c, i + 1, remain - c[i], path, ans);  // reuse allowed -> i (not i+1)
            path.remove(path.size() - 1);         // backtrack
        }
    }
}