class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return true;
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            int u = p[0], v = p[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        List<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            order.add(curr);
            for(int nei : adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei] == 0) queue.offer(nei);
            }
        }
        return order.size() == numCourses;
    }
}