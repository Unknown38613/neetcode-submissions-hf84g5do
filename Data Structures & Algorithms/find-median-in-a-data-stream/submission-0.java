class MedianFinder {
    private final PriorityQueue<Integer> leftMaxHeap;
    private final PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        this.leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int left = leftMaxHeap.size();
        int right = rightMinHeap.size();
        if(left == 0 && right == 0){
            leftMaxHeap.offer(num);
            return;
        }
        if(right != 0 && num > rightMinHeap.peek()){
            rightMinHeap.offer(num);
            right++;
        }
        else{
            leftMaxHeap.offer(num);
            left++;
        }
        //balance both 
        //3 2
        while(left > right + 1){
            int max = leftMaxHeap.poll();
            rightMinHeap.offer(max);
            left--;
            right++;
        }
        //4 3 -> 3 3
        while(right > left){
            int min = rightMinHeap.poll();
            leftMaxHeap.offer(min);
            right--;
            left++;
        }
    }
    
    public double findMedian() {
        int left = leftMaxHeap.size();
        int right = rightMinHeap.size();
        if((left + right) == 0) return 0.0;
        if(right == 0) return (double) leftMaxHeap.peek();
        return (left + right) % 2 == 0 ? (double)(leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0 : (double) leftMaxHeap.peek();
    }
}
