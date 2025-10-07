class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length,i=0;
        int[] res=new int[n];
        HashMap<Integer,Integer> mp=new HashMap<>();
        ArrayList<Integer> dryDays=new ArrayList<>();
        for(i=0;i<n;i++){
            if(rains[i]==0){
                dryDays.add(i);
                res[i]=1;
            }
            else{
                int lake=rains[i];
                
                if(mp.containsKey(lake)){
                    int j=0;
                    while(j<dryDays.size() && dryDays.get(j)<mp.get(lake)){
                        j++;
                    }
                    
                    if(j>=dryDays.size()) return new int[]{};
                    else{
                        res[dryDays.get(j)]=lake;
                        dryDays.remove(j);
                       
                    }
                }

                res[i]=-1;
                mp.put(lake,i);
                
            }
        }
        return res;
    }
}