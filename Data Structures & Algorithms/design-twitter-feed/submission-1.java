class Twitter {

    private static int timeStamp = 0;

    class Tweet{
        int tweet;
        int time;
        Tweet(int tweet, int time){
            this.tweet = tweet;
            this.time = time;
        }
    }

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> followings;

    public Twitter() {
        this.tweets = new HashMap<>();
        this.followings = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> mostRecent = new PriorityQueue<>((a, b) -> b.time - a.time);
        if(tweets.containsKey(userId)){
            mostRecent.addAll(tweets.get(userId));
        }
        if(followings.containsKey(userId)){
            for(int f : followings.get(userId)){
                if(tweets.containsKey(f)){
                    mostRecent.addAll(tweets.get(f));
                }
            }
        }
        int count = 10;
        List<Integer> feed = new ArrayList<>();
        while(!mostRecent.isEmpty() && count != 0){
            feed.add(mostRecent.poll().tweet);
            count -= 1;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followings.putIfAbsent(followerId, new HashSet<>());
        followings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!followings.containsKey(followerId)) return;
        followings.get(followerId).remove(Integer.valueOf(followeeId));
    }
}