class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int z = 0 ; z < size ; z++){
                String word = queue.poll();
                if(word.equals(endWord)) return steps;
                
                char[] carr = word.toCharArray();

                for(int i = 0 ; i < carr.length ; i++){
                    char original = carr[i]; //b

                    for(char c = 'a' ; c <= 'z' ; c++){
                        if(c == original) continue;

                        carr[i] = c;
                        String newword = new String(carr); //aat

                        if(dict.contains(newword) && !visited.contains(newword)){
                            visited.add(newword);
                            queue.offer(newword);
                        }
                    }

                    carr[i] = original;
                }
            }

            steps++;
        }
        return 0;
    }
}
