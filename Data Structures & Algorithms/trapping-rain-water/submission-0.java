class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int res = 0;
        while(l < r){
           if(lmax < rmax){
              l++;
              lmax = Math.max(lmax, height[l]);
              res += lmax - height[l];
           }
           else{
              r--;
              rmax = Math.max(rmax, height[r]);
              res += rmax - height[r];
           }
        }
        return res;
    }
}
