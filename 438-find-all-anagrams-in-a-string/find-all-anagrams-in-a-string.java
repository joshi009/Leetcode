class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = p.charAt(i);
            if (!pmap.containsKey(ch)) {
                pmap.put(ch, 0);
            }
            pmap.put(ch, pmap.get(ch) + 1);

        }
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        while (j < m) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (j - i + 1 == n) {
                if (map.equals(pmap)) {
                    list.add(i);
                    
                }
                char rem=s.charAt(i);
                map.put(rem,map.get(rem)-1);
                if(map.get(rem)==0)
                {
                    map.remove(rem);
                }
                i++;

                
            }
            j++;

        }

        return list;

    }
}