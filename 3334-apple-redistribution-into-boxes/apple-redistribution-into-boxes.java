class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int s=0,e= capacity.length-1;
        while(s<=e){
            int t =capacity[s];
            capacity[s] = capacity[e];
            capacity[e] = t;
            s++;
            e--;
        }
        int sum =0,cnt=0;
        for(int i=0; i<apple.length; i++){
            sum += apple[i];
        }
        for(int i=0; i<capacity.length; i++){
            if(sum>0 && sum>capacity[i]){
                sum = sum-capacity[i];
                cnt++;
            }
            else if(sum>0 && capacity[i]>=sum){
                cnt++;
                break;
            }
        }
        return cnt;   
    }
}