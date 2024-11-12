class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // expected sum 
        int expectedSum = n * (n + 1) / 2;
        
        // sum of array
        int actualSum = 0;
        for (int i = 0; i < n; i++) {
            actualSum += nums[i];
        }
        
        return expectedSum - actualSum;
    }
}
