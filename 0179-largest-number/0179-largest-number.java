import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert all numbers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        // Sort strings based on custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        // If after sorting, the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }
        
        // Build the largest number string
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }
        
        return largestNumber.toString();
    }
}
