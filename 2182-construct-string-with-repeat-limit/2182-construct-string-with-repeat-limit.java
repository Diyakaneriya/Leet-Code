import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Step 1: Count the frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 2: Use a max heap to prioritize lexicographically largest characters
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 25; i >= 0; i--) {
            if (freq[i] > 0) {
                maxHeap.add(new int[] {i, freq[i]}); // {character index, frequency}
            }
        }
        
        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll(); // The character with the largest lexicographical value
            int charIndex = curr[0];
            int charFreq = curr[1];
            char currentChar = (char) ('a' + charIndex);
            
            int repeatCount = Math.min(charFreq, repeatLimit);
            for (int i = 0; i < repeatCount; i++) {
                result.append(currentChar);
            }
            
            // If there are leftover characters for this character
            if (charFreq > repeatLimit) {
                if (maxHeap.isEmpty()) {
                    // If no other characters are available, stop
                    break;
                }
                
                // Insert a different character to break the sequence
                int[] next = maxHeap.poll();
                int nextCharIndex = next[0];
                int nextCharFreq = next[1];
                char nextChar = (char) ('a' + nextCharIndex);
                
                result.append(nextChar);
                nextCharFreq--;
                
                // Reinsert the characters back into the heap if they still have frequency left
                if (nextCharFreq > 0) {
                    maxHeap.add(new int[] {nextCharIndex, nextCharFreq});
                }
                maxHeap.add(new int[] {charIndex, charFreq - repeatLimit});
            }
        }
        
        return result.toString();
    }
}
