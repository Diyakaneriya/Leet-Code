class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // Define the search space
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        int result = right;

        // Binary search for the minimum possible penalty
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, mid, maxOperations)) {
                result = mid; // Update result with the feasible penalty
                right = mid - 1; // Search for a smaller penalty
            } else {
                left = mid + 1; // Search for a larger penalty
            }
        }

        return result;
    }

    // Check if a given penalty is feasible
    private boolean canDivide(int[] nums, int penalty, int maxOperations) {
        int operations = 0;

        for (int num : nums) {
            // Calculate the number of splits needed for the current bag
            operations += (num - 1) / penalty;

            // If operations exceed maxOperations, return false
            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}
