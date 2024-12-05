class Solution {
    public boolean canChange(String start, String target) {
        // Remove all '_' and check if the sequences of 'L' and 'R' are the same
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }
        
        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip blanks in both strings
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            // If both pointers are within bounds
            if (i < n && j < n) {
                // If the characters are not the same, return false
                if (start.charAt(i) != target.charAt(j)) {
                    return false;
                }

                // Check movement constraints
                if (start.charAt(i) == 'L' && i < j) {
                    return false; // 'L' cannot move to the right
                }
                if (start.charAt(i) == 'R' && i > j) {
                    return false; // 'R' cannot move to the left
                }

                // Move both pointers
                i++;
                j++;
            }
        }

        return true;
    }
}
