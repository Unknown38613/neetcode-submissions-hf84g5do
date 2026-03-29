class Solution {
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }
    private void backtrack(StringBuilder current, int open, int close, int max){
        if(current.length() == 2 * max){
           ans.add(current.toString());
           return;
        }
        if(open < max){
            current.append("(");
            backtrack(current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if(close < open){
            current.append(")");
            backtrack(current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}