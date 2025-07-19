class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        Set<Character>set=new HashSet<>();
        int maxl=Integer.MIN_VALUE;
        while(j<s.length())
        {
          while(set.contains(s.charAt(j)))
          {  
            set.remove(s.charAt(i));
            i++;
          } 
          set.add(s.charAt(j));
          maxl=Math.max(maxl,j-i+1);
          j++;
        }
         return maxl==Integer.MIN_VALUE?0:maxl;       
    }
}