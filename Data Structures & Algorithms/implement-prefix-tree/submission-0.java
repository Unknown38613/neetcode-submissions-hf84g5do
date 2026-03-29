class PrefixTree {
    
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word == null || word.isEmpty()) return;
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = searchPrefix(word);
        return curr != null && curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = searchPrefix(prefix);
        return curr != null;
    }

    private TrieNode searchPrefix(String s){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            int idx = c - 'a';
            if(curr.children[idx] == null) return null;
            curr = curr.children[idx];
        }
        return curr;
    }
}