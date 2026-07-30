class Solution {
    public boolean isValid(int f1[],int f2[]){
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        int f1[] =new int[26];
        int f2[] =new int[26];
        int i=0,j=0;
        while(j<s1.length()){
            int idx1 = (int)(arr1[j]-'a');
            int idx2 = (int)(arr2[j]-'a');
            f1[idx1]++;
            f2[idx2]++;
            j++;
        }
        if(isValid(f1,f2))return true;
        while(j<s2.length()){
            int idx1 = (int)(arr2[i]-'a');
            int idx2 = (int)(arr2[j]-'a');
            f2[idx1]--;
            f2[idx2]++;
            if(isValid(f1,f2))return true;
            j++;
            i++;
        }
        return false;
    }
}
