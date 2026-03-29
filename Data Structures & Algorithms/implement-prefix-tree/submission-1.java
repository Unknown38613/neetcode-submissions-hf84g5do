class PrefixTree {
    
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
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
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
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
            if(curr.children.get(c) == null) return null; 
            curr = curr.children.get(c);
        }
        return curr;
    }
}