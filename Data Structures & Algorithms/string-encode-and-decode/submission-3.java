class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        str.append(strs.size()+",");
        for(String s:strs){
            int len = s.length();
            str.append(len + ",");
        }
        for(String s:strs){
           
            str.append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        char arr[] = str.toCharArray();
        int i =0;
        System.out.println(str);
        List<Integer> idx = new ArrayList<>();
        String getFirst = null;
       
        for(;i<arr.length;i++){
            if(arr[i]==','){
                getFirst= str.substring(0,i);
                i++;
                break;
            }
        }
        int total = Integer.parseInt(getFirst);
        
        int start =i;

        while(total>0){
            if(arr[i]==','){
                idx.add(Integer.parseInt(str.substring(start,i)));
                start = ++i;
                total--;
            }
            else{
                i++;
            }
        }
        int k=0;
        
        for(int id:idx){
            int till =i;
            till+=id;
            // System.out.println(str.substring(i,till));
            if(id==0){ans.add("");}
            else{
            ans.add(str.substring(i,till));}
            i = till;
 
        }
        return ans;
    }
}
