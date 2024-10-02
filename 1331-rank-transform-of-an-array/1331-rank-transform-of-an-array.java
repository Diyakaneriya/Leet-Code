import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];  
        
        int[][] valueIndexPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            valueIndexPairs[i][0] = arr[i];  
            valueIndexPairs[i][1] = i;       
        }
        
        Arrays.sort(valueIndexPairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int rank = 1;
        
        result[valueIndexPairs[0][1]] = rank;  
        for (int i = 1; i < n; i++) {
            if (valueIndexPairs[i][0] != valueIndexPairs[i - 1][0]) {
                rank++;
            }
            result[valueIndexPairs[i][1]] = rank;
        }
        
        return result;
    }
}
