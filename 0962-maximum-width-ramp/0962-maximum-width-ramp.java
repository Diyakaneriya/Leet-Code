class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        // Step 1: Precompute left minimums
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        // Step 2: Precompute right maximums
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], nums[j]);
        }

        // Step 3: Two-pointer technique to find the maximum width ramp
        int i = 0, j = 0, maxWidth = 0;
        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                maxWidth = Math.max(maxWidth, j - i);
                j++;  // Move j to widen the ramp
            } else {
                i++;  // Move i to find a valid minimum
            }
        }

        return maxWidth;
    }
}
