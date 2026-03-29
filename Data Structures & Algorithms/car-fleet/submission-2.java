class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Pair: [position, timeToTarget]
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            double time = (double) (target - position[i]) / speed[i]; // use double!
            cars[i][0] = position[i];
            cars[i][1] = time;
        }

        // Sort by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double maxTimeSoFar = Double.MIN_VALUE; // time of the last (front-most) fleet

        // Traverse from frontmost car to back
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            // If current car's time is greater, it cannot catch the fleet in front -> new fleet
            if (time > maxTimeSoFar) {
                fleets++;
                maxTimeSoFar = time;
            }
            // else: time <= maxTimeSoFar -> it joins the fleet; do nothing
        }

        return fleets;
    }
}