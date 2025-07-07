class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid>0 &&  nums[mid] == nums[mid - 1]) {
                //then we are at the second elment of the occurence
                if ((mid - 1) % 2 != 0) {
                    //if it is odd  then the unique element will be at lhs 
                    end = mid - 2;
                } else {
                    //element is not on the left
                    start = mid + 1;
                }

            } else if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                //means we are first occurence of the elememt
                if (mid % 2 != 0) {
                    //if it is odd  then the unique element will be at lhs 
                    end = mid - 1;
                } else {
                    //element is not on the left
                    start = mid + 2;
                }

            } else {
                return nums[mid];
            }

        }
        return nums[start];//or end both are equal

    }
}