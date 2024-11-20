class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        
        int n = s.length();
        int[] count = new int[3]; // To store counts of 'a', 'b', 'c'
        
        // Count total occurrences of 'a', 'b', 'c'
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // If any character appears fewer than k times, return -1
        if (count[0] < k || count[1] < k || count[2] < k) return -1;
        
        // Sliding window to find the longest subarray that leaves at least k characters
        int[] windowCount = new int[3]; // To store counts within the current window
        int left = 0, maxWindowLength = 0;
        
        for (int right = 0; right < n; right++) {
            windowCount[s.charAt(right) - 'a']++;
            
            // Shrink the window if it invalidates the condition
            while (count[0] - windowCount[0] < k || 
                   count[1] - windowCount[1] < k || 
                   count[2] - windowCount[2] < k) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
            
            // Update the maximum length of the valid subarray
            maxWindowLength = Math.max(maxWindowLength, right - left + 1);
        }
        
        // Minimum number of characters to take is the complement of the max window length
        return n - maxWindowLength;
    }
}
