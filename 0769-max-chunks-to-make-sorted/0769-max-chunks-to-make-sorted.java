class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            // Update the maximum value encountered so far
            max = Math.max(max, arr[i]);
            
            // If the maximum value equals the current index,
            // we can make a chunk
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
