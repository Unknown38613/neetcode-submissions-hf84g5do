class Solution {
    public int leastInterval(char[] tasks, int n) {
        //get frequency of each task
        int[] freq = new int[26];
        for(char c : tasks) freq[c - 'A']++;

        //Scheduler
        //max heap so most frequent task is always first
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int f : freq){
            if(f > 0) pq.offer(f);
        }
        
        // waiting queue
        // after completing 1 task, store the remaining task along with time 
        // so that it will get released when its time will come to get executed
        Queue<int[]> queue = new ArrayDeque<>(); //time, count

        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            //perform 1 task
            if(!pq.isEmpty()){
                int count = pq.poll() - 1;
                if(count > 0){
                    queue.offer(new int[]{time + n, count});
                }
            }

            //release the task whose time has come
            while(!queue.isEmpty() && queue.peek()[0] == time){
                pq.offer(queue.poll()[1]);
            }
            time++;
        }

        return time;
    }
}