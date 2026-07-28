class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }


        int half = (nums1.length+nums2.length)/2;
        int total = nums1.length+nums2.length;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i=0, j= nums1.length;
        while(i<=j){
           int cut1 = (j-i)/2+i;
           int cut2 = half - cut1;
           int l1 = cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
           int r1 = cut1==n1?Integer.MAX_VALUE:nums1[cut1];
           int l2 = cut2==0?Integer.MIN_VALUE:nums2[cut2-1];
           int r2 = cut2==n2?Integer.MAX_VALUE:nums2[cut2];
            // System.out.printf("l1 -> %d, l2 -> %d, r1 -> %d, r2 -> %d\n",l1,l2,r1,r2);
           if(l1<=r2 && l2<=r1){
                //if n is odd;
                if(total%2!=0){
                    return (double) Math.min(r1,r2);
                }
                else{
                    // System.out.println(Math.max(l1,l2) + " hh "+ Math.min(r1,r2));
                    return ((double) (Math.max(l1,l2)+Math.min(r1,r2)))/2;
                }

           }
           else if(l1<=r2){
            i=cut1+1;
           }
           else{
            j =cut1-1;
           }
        }
        return -1;

    }
}
