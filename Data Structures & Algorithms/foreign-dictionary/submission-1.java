class Solution {
    public String foreignDictionary(String[] words) {
       Map<Character, Set<Character>> graph = new HashMap<>();
       Map<Character, Integer> indegree =  new HashMap<>();

       for(String w : words){
            for(char c : w.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
       }

       for(int i = 0 ; i < words.length - 1 ; i++){
          String first = words[i];
          String second = words[i + 1];

          if(second.length() > first.length() && first.startsWith(second)){
            return "";
          }
          if(first.length() > second.length() && first.startsWith(second)){
            return "";
          }
          int len = Math.min(first.length(), second.length());
          for(int j = 0 ; j < len ; j++){
            char c1 = first.charAt(j);
            char c2 = second.charAt(j);
            if(c1 != c2){
                if(graph.get(c1).add(c2)){
                    indegree.put(c2, indegree.get(c2) + 1);
                }
                break;
            }
          }
       }

       Deque<Character> queue = new ArrayDeque<>();
       for(Map.Entry<Character, Integer> entry : indegree.entrySet()){
           if(entry.getValue() == 0) queue.offer(entry.getKey());
       }
       StringBuilder order = new StringBuilder();
       while(!queue.isEmpty()){
          char c = queue.poll();
          order.append(c);
          for(char n : graph.get(c)){
             indegree.put(n, indegree.get(n) - 1);
             if(indegree.get(n) == 0) queue.offer(n);
          }
       }
       return order.length() == indegree.size() ? order.toString() : "";
    }
}
