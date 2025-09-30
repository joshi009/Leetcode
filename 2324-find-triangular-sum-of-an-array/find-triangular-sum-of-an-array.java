class Solution {
    int[] num;

    public int triangularSum(int[] nums) {
        num = nums;
        return triSum(nums.length);
    }

    public int triSum(int len){
        if(len == 1){
            return num[0];
        }
        else{
            for(int i=0; i<len-1; i++){
                num[i] = (num[i] + num[i+1])%10;
            }
            return triSum(len-1);
        }
    }
}