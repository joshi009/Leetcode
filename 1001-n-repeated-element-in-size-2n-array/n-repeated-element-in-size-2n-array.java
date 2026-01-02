class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int n : nums){
            if(map.contains(n)) return n;
            map.add(n);
        }

        return 0;
    }
}