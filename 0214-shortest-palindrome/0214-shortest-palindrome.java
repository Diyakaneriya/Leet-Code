class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String reverseStr = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reverseStr;
        
        int[] lps = computeLPS(combined);
        
        int charsToAdd = s.length() - lps[lps.length - 1];
        String toAdd = reverseStr.substring(0, charsToAdd);
        
        return toAdd + s;
    }
    
    private int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int length = 0; 
        int i = 1;
        
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];  
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
