class Solution {
    public boolean isPerfectSquare(int num) {
        // num = Math.sqrt(num);
        int root=(int)Math.sqrt(num);
        return root*root==num;
    }
}