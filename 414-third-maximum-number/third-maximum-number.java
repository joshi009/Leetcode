import java.util.TreeSet;

public class Solution {
    public int thirdMax(int[] nums) {
        // TreeSet to keep numbers in sorted order and only unique elements
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num); 

           
            if (set.size() > 3) {
                set.remove(set.first()); 
            }
        }

        
        if (set.size() == 3) {
            return set.first();
        }

        return set.last();
    }
}