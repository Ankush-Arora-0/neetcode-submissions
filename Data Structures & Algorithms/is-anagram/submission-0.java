class Solution {
    public boolean isAnagram(String s, String t) {
        char a[] = s.toCharArray();
        char b[] = t.toCharArray();
        if(a.length!=b.length) return false;
        int aidx[] = new int[26];
        int bidx[] = new int[26];

        for(int i=0;i<a.length;i++){
            aidx[(int)(a[i]-'a')]++;
            bidx[(int)(b[i]-'a')]++;
        }
        for(int i=0;i<26;i++){
            if(aidx[i]!=bidx[i]) return false;
        }
        return true;
    }
}
