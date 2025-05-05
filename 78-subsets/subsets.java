
class Solution {
    static List<List<Integer>> list;
    static List<Integer> help;
    public List<List<Integer>> subsets(int[] nums) {
        list=new ArrayList<>();
        help=new ArrayList<>();
        subset(nums,0);
        return list;
    }
    public void subset(int nums[],int index){
        if(index==nums.length){
            list.add(new ArrayList<>(help));
            return;
        }
        help.add(nums[index]);
        subset(nums, index + 1);
        help.remove(help.size()-1);
        subset(nums,index+1);
    }
}