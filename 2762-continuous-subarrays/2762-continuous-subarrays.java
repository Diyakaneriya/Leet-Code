import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long total = 0;
        int start = 0;

        // TreeMap to track frequency of numbers in the window
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        for (int end = 0; end < n; end++) {
            // Add the current number to the frequency map
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);

            // Shrink the window if the condition is violated
            while (freqMap.lastKey() - freqMap.firstKey() > 2) {
                freqMap.put(nums[start], freqMap.get(nums[start]) - 1);
                if (freqMap.get(nums[start]) == 0) {
                    freqMap.remove(nums[start]);
                }
                start++;
            }

            // Add the number of subarrays ending at `end`
            total += (end - start + 1);
        }

        return total;
    }
}
