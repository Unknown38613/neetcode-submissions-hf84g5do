class WordDictionary {

    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        if(word == null || word.isEmpty()) return false;
        return dfs(curr, word, 0);
    }

    private boolean dfs(TrieNode curr, String word, int idx){
        if(idx == word.length()){
            return curr.isEndOfWord;
        }
        char c = word.charAt(idx);
        if(c == '.'){
            for(TrieNode child : curr.children.values()){
                if(dfs(child, word, idx + 1)) return true;
            }
            return false;
        }
        else{
            TrieNode child = curr.children.get(c);
            if(child == null) return false;
            return dfs(child, word, idx + 1);
        }
    }
}