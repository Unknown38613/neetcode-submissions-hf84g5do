class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int i = 0 ; i < piles.length ; i++){
            if(piles[i] > right) right = piles[i];
        }
        int result = right;
        while(left <= right){
            int mid = left + (right - left) / 2; //current speed
            long timeTaken = 0;
            for(int p : piles){
                timeTaken += Math.ceil((double) p / mid);
            }
            if(timeTaken <= h){ //valid speed range
                result = mid; //record it
                right = mid - 1; // try finding more smaller
            }
            else left = mid + 1; //invalid or too slow speed
        }
        return result;
    }
}