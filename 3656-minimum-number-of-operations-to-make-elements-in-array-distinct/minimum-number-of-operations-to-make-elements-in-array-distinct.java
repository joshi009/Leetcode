class Solution {
    public boolean check(int i,int arr[])
    {
        HashSet<Integer>set=new HashSet<>();
        for(int j=i;j<arr.length;j++)
        {
           if( set.contains(arr[j]))
            {
                return true;
            }
            else
            {
                set.add(arr[j]);
            }
        }
        return false;
    
    }
    public int minimumOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i+=3)
        {
           if(!check(i,nums))
           {
            break;
           }
           count++;
        }
        return count;
        
    }
}