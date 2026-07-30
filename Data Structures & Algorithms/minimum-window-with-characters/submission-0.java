class Solution {
    public boolean isValid(HashMap<Character,Integer> map,int usd[]){
        for(Map.Entry<Character,Integer> m:map.entrySet()){
            char c = m.getKey();
            int f = m.getValue();
            int idx = (int)(c-'A');
            if(usd[idx]<f)return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        int usd[] = new int[58];
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        for(char tr:tArray){
            map.put(tr,map.getOrDefault(tr,0)+1);
        }
        
        int i=0,j=0;
        int minAns = Integer.MAX_VALUE;
        int minI =-1,minJ=-1;
        while(j<sArray.length){
            if(i!=j){
                int idx = (int)(sArray[j]-'A');
                usd[idx]++;
                if(map.containsKey(sArray[j])){
                    
                    while(isValid(map,usd)){
                        if(minAns>(j-i+1)){
                            minI=i;
                            minJ=j;
                            minAns=j-i+1;
                        }
                        int idx1 = (int)(sArray[i]-'A');
                        usd[idx1]--;
                        i++;

                    }
                }
            }
            else{
                
                if(map.containsKey(sArray[j])){
                    int idx = (int)(sArray[j]-'A');
                    usd[idx]++;
                    if(isValid(map,usd)){
                        if(minAns>(j-i+1)){
                            minI=i;
                            minJ=j;
                            minAns=j-i+1;
                        }

                    }
                }
                else{
                    i++;
                }
            }
            j++;
        }   
        if(minI==-1) return "";
        return s.substring(minI,minJ+1);     
    }
}
