import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints); // Sort the time points
        
        int minDifference = Integer.MAX_VALUE;
        int firstTimeInMinutes = getMinutes(timePoints.get(0));
        int prevTimeInMinutes = firstTimeInMinutes;
        
        // Compare consecutive time points
        for (int i = 1; i < timePoints.size(); i++) {
            int currentTimeInMinutes = getMinutes(timePoints.get(i));
            minDifference = Math.min(minDifference, currentTimeInMinutes - prevTimeInMinutes);
            prevTimeInMinutes = currentTimeInMinutes;
        }
        
        // Compare the first and last time to account for the circular nature of the clock
        minDifference = Math.min(minDifference, (firstTimeInMinutes + 1440) - prevTimeInMinutes);
        
        return minDifference;
    }

    private int getMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
