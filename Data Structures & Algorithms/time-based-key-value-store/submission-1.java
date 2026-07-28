class TimeMap {
     HashMap<String,TreeMap<Integer,String>> map;

    public TimeMap() {
       map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        TreeMap<Integer,String> m = map.get(key);
        m.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> temp = map.get(key);
        if(temp==null || temp.floorKey(timestamp)==null){
            return "";
        }
        return temp.get(temp.floorKey(timestamp));
    }
}
