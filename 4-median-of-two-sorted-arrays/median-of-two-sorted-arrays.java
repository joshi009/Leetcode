class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int i= 0;
     int j=0;
     int k=0;

     int ans[]=new int[nums1.length+ nums2.length];
     while(i< nums1.length && j< nums2.length)
     {
         if(nums1[i]<nums2[j])
         {
             ans[k]=nums1[i];
             i++;
         }
         else{
             ans[k]=nums2[j];
             j++;

         }
         k++;
     }
     while (i<nums1.length){
         ans[k]=nums1[i];
         i++;
         k++;
     }
        while (j<nums2.length){
            ans[k]=nums2[j];
            j++;
            k++;
        }
        int total= ans.length;
        if (total % 2 == 1) {
            // If the total number of elements is odd, return the middle element as the median.
            return (double) ans[total / 2];
        } else {
            // If the total number of elements is even, calculate the average of the two middle elements as the median.
            int middle1 = ans[total / 2 - 1];
            int middle2 = ans[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }

    }
}