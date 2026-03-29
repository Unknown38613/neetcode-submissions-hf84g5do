class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Build pairs: [position, timeToTarget]
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i]; // use double to avoid truncation
        }

        // Sort by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Monotonic non-decreasing stack of fleet times
        Deque<Double> stack = new ArrayDeque<>();
        for (double[] car : cars) {
            double time = car[1];
            // New fleet only if this car's time is strictly greater than the fleet ahead
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time); // start a new fleet
            }
            // else: time <= stack.peek() -> merges into the fleet at the top; do not push
        }

        return stack.size();
    }
}