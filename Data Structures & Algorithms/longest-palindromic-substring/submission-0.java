class Solution {
    int i =0,j=0;
    int len = 0;
    public void getPalindrome(char arr[],int centre){
        {int s =centre,e =centre;
            while(s>=0 && e<arr.length){
                if(arr[s]==arr[e]){
                    int l = e-s+1;
                    if(len<l){
                        len=l;
                        i=s;j=e;
                    } 
                }else{
                    break;
                }
                s--;e++;
            }
        }
        {int s =centre,e =centre+1;
            while(s>=0 && e<arr.length){
                if(arr[s]==arr[e]){
                    int l = e-s+1;
                    if(len<l){
                        len=l;
                        i=s;j=e;
                    } 
                }else{
                    break;
                }
                s--;e++;
            }
        }

    }
    public String longestPalindrome(String s) {
        if(s.length()==1)return s;
        char arr[] = s.toCharArray();
        for(int idx=0;idx<arr.length;idx++){
            getPalindrome(arr,idx);
        }
        return s.substring(i,j+1);
    }
}
