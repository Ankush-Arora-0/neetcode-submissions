class Solution {
    HashMap<String,Boolean> map = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    public boolean isPalindrome(String str){
        if(map.containsKey(str)) return map.get(str);
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                map.put(str,false);
                return false;
            }
            i++;j--;
        }
        map.put(str,true);
        return true;
    }
    public boolean getPalindrome(char arr[],String main , int idx,StringBuilder str,List<String> temp){

        if(str.length()>0){
            if(isPalindrome(str.toString())) temp.add(str.toString());
            else return false;
        }
        if(idx==arr.length){
            if(temp.size()>0){
                ans.add(new ArrayList<>(temp));
            }
            return true;
        }
        int j = idx;
        
        for(;j<arr.length;j++){
            StringBuilder s = new StringBuilder(main.substring(idx,j+1));

            if(getPalindrome(arr,main,j+1,s,temp)){
                if(temp.size()>0){
                    temp.removeLast();
                }
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        char arr[] = s.toCharArray();
        getPalindrome(arr,s,0,new StringBuilder(),new ArrayList<>());
        return ans;
    }
}
