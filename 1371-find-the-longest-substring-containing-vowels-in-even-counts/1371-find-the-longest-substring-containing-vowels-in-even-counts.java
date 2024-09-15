import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1); 
        
        int bitmask = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'a') {
                bitmask ^= 1 << 0; 
            } else if (c == 'e') {
                bitmask ^= 1 << 1; 
            } else if (c == 'i') {
                bitmask ^= 1 << 2; 
            } else if (c == 'o') {
                bitmask ^= 1 << 3; 
            } else if (c == 'u') {
                bitmask ^= 1 << 4; 
            }

            if (seen.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - seen.get(bitmask));
            } else {
                seen.put(bitmask, i);
            }
        }
        
        return maxLength;
    }
}
