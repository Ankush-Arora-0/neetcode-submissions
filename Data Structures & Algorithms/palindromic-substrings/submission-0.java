class Solution {
    int count=0;
     public void getPalindrome(char arr[],int centre){
        {int s =centre,e =centre;
            while(s>=0 && e<arr.length){
                if(arr[s]==arr[e]){
                    count++;
                     
                }else{
                    break;
                }
                s--;e++;
            }
            
        }
        {int s =centre,e =centre+1;
            while(s>=0 && e<arr.length){
                if(arr[s]==arr[e]){
                    count++;
                    
                }else{
                    break;
                }
                s--;e++;
            }
        }

    }
    public int countSubstrings(String s) {
        if(s.length()==1)return 1;
        char arr[] = s.toCharArray();
        for(int idx=0;idx<arr.length;idx++){
            getPalindrome(arr,idx);
        }
        return count;
    }
}
