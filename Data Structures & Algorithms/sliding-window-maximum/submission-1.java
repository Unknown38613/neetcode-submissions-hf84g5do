class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1 && k == 1) return new int[]{nums[0]};
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            int windowStart = i - k + 1;
            if(!deque.isEmpty() && deque.peekFirst() < windowStart){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k - 1){
                output[windowStart] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}