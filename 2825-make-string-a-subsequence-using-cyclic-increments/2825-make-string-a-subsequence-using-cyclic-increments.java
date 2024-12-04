class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n1 = str1.length(), n2 = str2.length();

        // Use two pointers to match str2 as a subsequence of str1
        while (i < n1 && j < n2) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);

            // Check if the current character of str1 can match the current character of str2
            if (ch1 == ch2 || (ch1 - 'a' + 1) % 26 + 'a' == ch2) {
                j++; // Move to the next character in str2 if matched
            }
            i++; // Always move to the next character in str1
        }

        // If we've matched all characters of str2, return true
        return j == n2;
    }
}
