class Solution {
    private List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) return ans;
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> mapping = new ArrayList<>();
        for(char c : digits.toCharArray()){
            int i = c - '0';
            mapping.add(map.get(i));
        }
        backtrack(mapping, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(List<String> strings, int pos, StringBuilder path){
        if(pos == strings.size()){
            ans.add(path.toString());
            return;
        }
        String curr = strings.get(pos);
        for(int i = 0 ; i < curr.length() ; i++){
            path.append(curr.charAt(i));
            backtrack(strings, pos + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}