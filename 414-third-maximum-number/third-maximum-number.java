class Solution {
    public int thirdMax(int[] nums) {
        
          HashMap <Integer,Integer>map=new HashMap<>();
        for (int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        ArrayList<Integer>list=new ArrayList<>();
        for (Map.Entry<Integer,Integer>entry:map.entrySet())
        {
            list.add(entry.getKey());
        }
        Collections.sort(list);
        if(list.size()<3) return list.get(list.size()-1);
        return list.get(list.size()-3);
    }
}