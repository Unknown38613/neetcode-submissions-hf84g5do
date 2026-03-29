class TimeMap {
    private static class Pair {
        final int timestamp;
        final String value;
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private final Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null || list.isEmpty()) return "";

        int lo = 0, hi = list.size() - 1;
        String ans = "";
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < timestamp) {
                ans = list.get(mid).value; // best so far
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}