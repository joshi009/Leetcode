class Solution {
    public char nextGreatestLetter(char[] numbers, char key) {
         int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            
            if (numbers[mid] <=key) {   //right
                start = mid + 1;
            } else {    //left
                end = mid - 1;
            }
        }
        return numbers[start%numbers.length];
        
    }
}