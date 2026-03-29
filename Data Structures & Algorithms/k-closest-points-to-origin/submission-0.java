class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0 ; i < points.length ; i++){
            int euclid = (int) Math.ceil(Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
            pq.offer(new int[]{euclid, points[i][0], points[i][1]});
        }
        int[][] ans = new int[k][2];
        int count = k;
        int idx = 0;
        while(!pq.isEmpty()){
            if(count == 0) break;
            int[] x = pq.poll();
            ans[idx][0] = x[1];
            ans[idx++][1] = x[2];
            count -= 1;
        }
        return ans;
    }
}