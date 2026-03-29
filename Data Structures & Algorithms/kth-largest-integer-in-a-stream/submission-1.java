class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> minHeap; // size <= k

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int n : nums) {
            add(n); // reuse logic to maintain size <= k
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            // Only insert if it can be in the top k
            minHeap.poll();
            minHeap.offer(val);
        } // else ignore val; it's not in the top k
        return minHeap.peek();
    }
}