class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    private int result(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(map.get(n) != null) return map.get(n);
        int a = result(n - 1);
        int b = result(n - 2);
        map.put(n, a + b);
        return a + b;
    }
    public int climbStairs(int n) {
        return result(n);
    }
}