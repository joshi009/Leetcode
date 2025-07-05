class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int n:nums)
        {
            set.add(n);
        }
        if(set.size()<3)
        {
            return set.pollLast();
        }
        set.pollLast();
        set.pollLast();
        
        return set.pollLast();
        
    }
}