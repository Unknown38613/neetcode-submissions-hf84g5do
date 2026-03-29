class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        while(!pq.isEmpty()){
           if(pq.size() == 1) break;
           int stone1 = pq.poll();
           int stone2 = pq.poll();
           if(stone2 < stone1) pq.offer(stone1 - stone2);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
