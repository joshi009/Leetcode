class Solution {
    public int[] plusOne(int[] digits) {
        int index=digits.length -1;
        for(int i=index;i>=0;i--){
            if(digits[i] >=9){
                digits[i] = 0;
                if(i==0){
                    int[] arr = new int[index+2];
                    arr[0] = 1;
                    for(int k=1;k<=index+1;k++){
                        arr[k] = digits[k-1];
                    }
                    return arr;
                }
                continue;
            }
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
        }
        return digits;
    }
}