class Solution {
    public boolean isPerfectSquare(int num) {
        long st = 1;
        long ed = num;
        while(st<=ed){
            long mid = st + (ed- st)/2;
            if(mid*mid == num){
                return true;
            }if(mid*mid<num){
                st = mid+1;
            }else{
                if(mid*mid>num){
                ed= mid-1;
                }
            }
        }
        return false;
    }
}