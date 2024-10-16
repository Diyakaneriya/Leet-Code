import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        
        
        if (a > 0) pq.add(new int[]{a, 'a'});
        if (b > 0) pq.add(new int[]{b, 'b'});
        if (c > 0) pq.add(new int[]{c, 'c'});
        
        StringBuilder result = new StringBuilder();
        
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            int count1 = first[0];
            char char1 = (char) first[1];
            
            if (result.length() >= 2 && result.charAt(result.length() - 1) == char1 && result.charAt(result.length() - 2) == char1) {
                if (pq.isEmpty()) {
                    break;
                }
                
                int[] second = pq.poll();
                int count2 = second[0];
                char char2 = (char) second[1];
                
                result.append(char2);
                count2--;
                
                if (count2 > 0) {
                    pq.add(new int[]{count2, char2});
                }
                
                pq.add(first);
            } else {
                result.append(char1);
                count1--;
                
                if (count1 > 0) {
                    pq.add(new int[]{count1, char1});
                }
            }
        }
        
        return result.toString();
    }
}
