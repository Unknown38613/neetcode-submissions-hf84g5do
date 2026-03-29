class Solution {

    static class Node{
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
        String word = null;
    }

    private Node root = new Node();
    private List<String> ans = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        for(String s : words){
            Node curr = root;
            for(char c : s.toCharArray()){
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.isWord = true;
            curr.word = s;
        }
        int row = board.length;
        int col = board[0].length;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                dfs(root, board, i, j);
            }
        }
        return ans;
    }

    private void dfs(Node curr, char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char ch = board[i][j];
        if(ch == '#') return;
        Node node = curr.children.get(ch);
        if(node == null) return;
        if(node.isWord){
            ans.add(node.word);
            node.isWord = false;
        }
        board[i][j] = '#';
        dfs(node, board, i + 1, j);
        dfs(node, board, i - 1, j);
        dfs(node, board, i, j + 1);
        dfs(node, board, i, j - 1);
        board[i][j] = ch;
    }
}