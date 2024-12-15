import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue (max-heap) to store classes based on potential gain
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );
        
        // Add all classes to the heap with their initial gain
        for (int[] c : classes) {
            int passi = c[0], totali = c[1];
            double gain = calculateGain(passi, totali);
            maxHeap.offer(new double[]{gain, passi, totali});
        }
        
        // Assign extra students
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int passi = (int) top[1];
            int totali = (int) top[2];
            
            // Add one extra student
            passi++;
            totali++;
            extraStudents--;
            
            // Recalculate gain and push back into the heap
            gain = calculateGain(passi, totali);
            maxHeap.offer(new double[]{gain, passi, totali});
        }
        
        // Calculate the final average pass ratio
        double totalPassRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int passi = (int) top[1];
            int totali = (int) top[2];
            totalPassRatio += (double) passi / totali;
        }
        
        return totalPassRatio / classes.length;
    }
    
    // Helper method to calculate the gain in pass ratio
    private double calculateGain(int passi, int totali) {
        return ((double) (passi + 1) / (totali + 1)) - ((double) passi / totali);
    }
}
