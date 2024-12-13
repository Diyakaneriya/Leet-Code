import java.util.Arrays;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Convert array to Integer[] for easier sorting
        Integer[] giftArray = Arrays.stream(gifts).boxed().toArray(Integer[]::new);

        // Sort array in descending order
        Arrays.sort(giftArray, (a, b) -> b - a);

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Take the largest pile
            int maxGifts = giftArray[0];

            // Replace with floor(sqrt(maxGifts))
            giftArray[0] = (int) Math.floor(Math.sqrt(maxGifts));

            // Re-sort the array in descending order
            Arrays.sort(giftArray, (a, b) -> b - a);
        }

        // Sum the remaining gifts
        long totalGifts = 0;
        for (int gift : giftArray) {
            totalGifts += gift;
        }

        return totalGifts;
    }
}
