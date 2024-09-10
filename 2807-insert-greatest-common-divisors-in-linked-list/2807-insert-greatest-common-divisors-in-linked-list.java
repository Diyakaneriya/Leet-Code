class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        
        // Traverse the list until the second last node
        while (current != null && current.next != null) {
            // Calculate GCD of current node value and the next node value
            int gcdValue = gcd(current.val, current.next.val);
            
            // Create a new node with the GCD value
            ListNode gcdNode = new ListNode(gcdValue);
            
            // Insert the new node between current and next node
            gcdNode.next = current.next;
            current.next = gcdNode;
            
            // Move to the next pair of nodes (skip the inserted node)
            current = gcdNode.next;
        }
        
        return head;
    }
    
    // Helper method to calculate GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
