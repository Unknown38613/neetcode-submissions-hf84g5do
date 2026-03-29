class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks) freq[c - 'A']++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int f : freq){
            if(f > 0) pq.offer(f);
        }

        //time, count
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            if(!pq.isEmpty()){
                int count = pq.poll() - 1;
                if(count > 0){
                    queue.offer(new int[]{time + n, count});
                }
            }
            while(!queue.isEmpty() && queue.peek()[0] == time){
                pq.offer(queue.poll()[1]);
            }
            time++;
        }
        return time;
    }
}