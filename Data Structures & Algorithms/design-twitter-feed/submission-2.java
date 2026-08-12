class Twitter {
    public int  counter =0;
    HashMap<Integer,User> set;
    class Tweet implements Comparable<Tweet>{
        int tweetId;
        int cntr;
        Tweet(int ti){
            tweetId = ti;
            cntr = ++counter;
        }
        public int compareTo(Tweet that){
            return Integer.compare(that.cntr,this.cntr);
        }
    }
    class User implements Comparable<User>{
        int uid;
        HashSet<Integer> frnds;
        List<Tweet> tweets;
        User(int id){
            uid = id;
            frnds = new HashSet<>();
            tweets = new ArrayList<>();
        }
        public int compareTo(User that){
            return Integer.compare(that.uid,this.uid);
        }
    }
    public Twitter() {
        set= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(set.containsKey(userId)){
            User usr = set.get(userId);
            usr.tweets.add(new Tweet(tweetId));
        }
        else{
            User usr = new User(userId);
            usr.tweets.add(new Tweet(tweetId));
            set.put(userId,usr);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User usr = set.get(userId);
        for(Tweet t:usr.tweets){
            pq.offer(t);
        }
        for(int fd:usr.frnds){
            User fr = set.get(fd);
            for(Tweet t:fr.tweets){
                pq.offer(t);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<10;i++){
            if(!pq.isEmpty())ans.add(pq.poll().tweetId);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId!=followeeId){
            if(!set.containsKey(followerId)){
                User usr = new User(followerId);
                set.put(followerId,usr);
            }
                User usr = set.get(followerId);
                usr.frnds.add(followeeId);
            
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId!=followeeId){
            User usr = set.get(followerId);
            usr.frnds.remove(followeeId);
        }
    }
}
