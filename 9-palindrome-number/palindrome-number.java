class Solution {
    public boolean isPalindrome(int x) {
        return x==rev(x);    
    }
    int rev(int x){
        int s=0;
        while(0<x){
            s=s*10+x%10;
            x=x/10;
        }
        return s;
    }
}