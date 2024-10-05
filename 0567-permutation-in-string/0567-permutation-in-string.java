import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;

        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);

        for (int i = 0; i <= n - m; i++) {
            String sub = s2.substring(i, i + m);

            char[] sortedSub = sub.toCharArray();
            Arrays.sort(sortedSub);

            if (Arrays.equals(sortedS1, sortedSub)) {
                return true; 
            }
        }

        return false;
    }
}
