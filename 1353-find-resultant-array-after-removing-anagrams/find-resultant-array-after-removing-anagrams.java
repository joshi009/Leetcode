class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for(int i=1;i<words.length;i++)
        {
            if(!isAnagram(words[i],words[i-1]))
                result.add(words[i]);
        }
        return result;
    }

    private boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){ 
            return false;
        }
        int[] freq = new int[26];
        for(int i=0;i<str1.length();i++){
            freq[str1.charAt(i)-'a']++;
            freq[str2.charAt(i)-'a']--;
        }
        for(int val : freq){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}