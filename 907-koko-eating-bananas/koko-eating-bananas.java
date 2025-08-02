    class Solution {
        public int hr(int piles[], int k){
            int hour=0;
            for(int n:piles)
            {
                hour+=Math.ceil((double)n/(double)k);
            }
            return hour;
        }
        public int minEatingSpeed(int[] piles, int h) {
            int end=Integer.MIN_VALUE;
            int start = 1;
            for(int n:piles)
            {
                end=Math.max(end,n);
            }
            int ans = 0;
                while(start<=end){
                    int mid  = start + (end-start)/2;
                    if(hr(piles,mid)<= h){
                        ans = mid;
                        end = mid-1;
                    }
                    else{
                        start =mid+1;
                    }
                }
                return ans;
        }

    }