class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int i=0;
        int j=1;
        int ans=0;
        while(i<s.length()){
            if(i==s.length()-1){
                ans+=hm.get(s.charAt(i));
                return ans;
            }
            Character ch1=s.charAt(i);
           Character ch2=s.charAt(j);
            if(hm.get(ch1)<hm.get(ch2)){
                ans+=(hm.get(ch2)-hm.get(ch1));
                i+=2;
                j+=2;
            }
            else{
                ans+=hm.get(ch1);
                i++;
                j++;
            }
            
        }
         return ans;
         
    }
}