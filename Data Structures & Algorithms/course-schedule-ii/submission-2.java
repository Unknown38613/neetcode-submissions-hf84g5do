class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] order = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            order[idx++] = curr;
            for(int nei : adj.get(curr)){
                if(--indegree[nei] == 0) queue.offer(nei);
            }
        }
        if(idx == numCourses) return order;
        return new int[]{};
    }
}
