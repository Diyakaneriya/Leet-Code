class Solution {
    public boolean checkIfExist(int[] arr) {
        // Use a HashSet to store elements for fast lookup
        Set<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            // Check if twice the current number or half (if even) exists in the set
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }
        
        // If no such pair is found, return false
        return false;
    }
}
