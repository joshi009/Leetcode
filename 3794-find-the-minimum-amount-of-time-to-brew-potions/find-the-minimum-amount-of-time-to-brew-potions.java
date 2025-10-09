class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n=skill.length;
        int m=mana.length;

        long[] finishTime = new long[n+1];

        for(int j=0; j<m; j++){
            for(int i=0 ; i<n; i++){
                finishTime[i+1] = Math.max(finishTime[i+1], finishTime[i]) + (long) mana[j]*skill[i];
            }
            for(int i=n-1 ; i>0; i--){
                finishTime[i] = finishTime[i+1] - (long) mana[j]*skill[i];
            }
        }
    return finishTime[n];
    }
}