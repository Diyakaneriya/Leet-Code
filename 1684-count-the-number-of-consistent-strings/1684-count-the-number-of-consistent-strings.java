class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a bitmask for the allowed string
        int allowedMask = 0;
        for (char c : allowed.toCharArray()) {
            allowedMask |= (1 << (c - 'a'));  // Set the bit for each allowed character
        }
        
        int consistentCount = 0;
        
        // Iterate through each word in the words array
        for (String word : words) {
            int wordMask = 0;
            
            // Create a bitmask for the current word
            for (char c : word.toCharArray()) {
                wordMask |= (1 << (c - 'a'));  // Set the bit for each character in the word
            }
            
            // Check if all characters in the word are allowed
            if ((wordMask & allowedMask) == wordMask) {
                consistentCount++;
            }
        }
        
        return consistentCount;
    }
}
