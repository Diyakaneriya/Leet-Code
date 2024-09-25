class Solution {
    static class TrieNode {
        TrieNode[] children;
        int count;  
        
        TrieNode() {
            children = new TrieNode[26];  
            count = 0;
        }
    }
    
    private TrieNode root = new TrieNode();
    
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++;  
        }
    }
    
    private int getScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            score += node.count;  
        }
        return score;
    }
    
    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insert(word);
        }
        
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = getScore(words[i]);
        }
        
        return result;
    }
}
