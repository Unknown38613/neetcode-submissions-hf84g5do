class Solution {

    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private List<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        dfs("JFK");

        Collections.reverse(path);
        return path;
    }

    private void dfs(String airport){
        PriorityQueue<String> nextAirport = graph.get(airport);

        while(nextAirport != null && !nextAirport.isEmpty()){
            String next = nextAirport.poll();
            dfs(next);
        }
        
        path.add(airport);
    }
}