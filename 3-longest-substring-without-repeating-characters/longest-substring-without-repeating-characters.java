class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++)
        {
         Set<Character>set=new HashSet<>();
         for(int j=i;j<s.length();j++)
         {
            if(set.contains(s.charAt(j)))

            {
                break;
            }
            set.add(s.charAt(j));
            length=Math.max(length,set.size());
         }    
        }
        return length==Integer.MIN_VALUE?0:length;
        
    }
}