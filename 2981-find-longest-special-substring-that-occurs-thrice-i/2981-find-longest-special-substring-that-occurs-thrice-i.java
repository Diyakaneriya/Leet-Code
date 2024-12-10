class Solution {
    // Function to check if a substring is special
    private boolean isSpecial(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public int maximumLength(String s) {
        int n = s.length();
        
        // Start from the longest possible substring length
        for (int len = n; len > 0; len--) {
            for (int i = 0; i <= n - len; i++) {
                String substr = s.substring(i, i + len);
                if (isSpecial(substr)) {
                    int count = 0;
                    for (int j = 0; j <= n - len; j++) {
                        if (s.substring(j, j + len).equals(substr)) {
                            count++;
                        }
                    }
                    if (count >= 3) {
                        return len;
                    }
                }
            }
        }
        
        return -1;
    }
}
