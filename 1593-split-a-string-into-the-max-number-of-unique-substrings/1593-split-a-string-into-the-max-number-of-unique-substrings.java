import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> used) {
        if (start == s.length()) {
            return 0;
        }

        int maxUnique = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substr = s.substring(start, end);
            if (!used.contains(substr)) {
                used.add(substr);
                maxUnique = Math.max(maxUnique, 1 + backtrack(s, end, used));
                used.remove(substr);
            }
        }
        return maxUnique;
    }
}
