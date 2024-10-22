/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // Base case
        if (root == null) return -1;

        // Priority queue (min-heap) to store the k largest sums
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform BFS to calculate level sums
        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;

            // Traverse nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                // Add child nodes to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add the level sum to the heap
            minHeap.offer(levelSum);

            // Keep only the k largest sums in the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest sum
            }
        }

        // If the heap contains fewer than k elements, return -1
        if (minHeap.size() < k) return -1;

        // The root of the heap is the kth largest level sum
        return minHeap.peek();
    }
}
