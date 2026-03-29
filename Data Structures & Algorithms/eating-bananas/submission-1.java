class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //binary search for speed values between 1 and max(piles)
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int i = 0 ; i < piles.length ; i++){
            if(piles[i] > right) right = piles[i];
        }
        int result = right;
        while(left <= right){
            int mid = left + (right - left) / 2; //current speed
            if(canFinish(piles, mid, h)){ //valid speed
                result = mid; //record it
                right = mid - 1; // try finding more smaller
            }
            else left = mid + 1; //invalid or too slow speed
        }
        return result;
    }
    private boolean canFinish(int[] piles, int mid, int h){
        long timeTaken = 0;
        for(int p : piles){
            timeTaken += Math.ceil((double) p / mid);
            if(timeTaken > h) return false;
        }
        return true;
    }
}