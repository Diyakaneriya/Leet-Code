class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words using spaces
        String[] words = sentence.split(" ");
        
        // Iterate through the words and check if searchWord is a prefix
        for (int i = 0; i < words.length; i++) {
            // Check if the current word starts with searchWord
            if (words[i].startsWith(searchWord)) {
                return i + 1; // Return 1-indexed position
            }
        }
        
        // If no word matches, return -1
        return -1;
    }
}
