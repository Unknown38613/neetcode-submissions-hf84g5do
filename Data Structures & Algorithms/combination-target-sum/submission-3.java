class Solution {
    private List<List<Integer>> combinations = new ArrayList<>();
    private int target;
    private int[] candidates;

    private void dfs(int index, List<Integer> sum, int currSum){
        if(currSum == target){
            combinations.add(new ArrayList<>(sum));
            return;
        }
        if(index >= candidates.length || currSum > target) return; //pruning
        sum.add(candidates[index]);
        dfs(index, sum, currSum + candidates[index]); //pick same element
        sum.remove(sum.size() - 1); //backtracking
        dfs(index + 1, sum, currSum); // pick next element
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        dfs(0, new ArrayList<>(), 0);
        return combinations;
    }
}