class Solution {
    public int thirdMax(int[] nums) {
         long first = Long.MIN_VALUE;
         long sec = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for( int n:nums){
   
            if(first < n){
                third = sec;
                sec = first;
                first = n;
            }
           else if(n>sec  && n<first){
                third = sec;
                sec = n;
            }
            else if(n<sec && third<n) {
                third = n;
            }
            
        }
        if(third==Long.MIN_VALUE)
        {
            return (int) first;
        }
        return (int) third; 
    }
}