class Solution {
    public int maxArea(int[] heights) {
        int maxarea = 0;
        int l = 0 , r = heights.length - 1;
        while(l < r){
            int fc = heights[l];
            int sc = heights[r];
            int min = Math.min(fc, sc);
            int currarea = min * (r - l);
            maxarea = Math.max(maxarea, currarea);
            if(fc < sc) l++;
            else r--;
        }
        return maxarea;
    }
}