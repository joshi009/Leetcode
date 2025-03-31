class Solution {
    public boolean find132pattern(final int[] numbers) {
        if(numbers.length < 3)
            return false;
        
        int minElement = Integer.MIN_VALUE, idx = numbers.length;
        
        for(int i = numbers.length - 1; i >= 0; i--) {
            if(numbers[i] < minElement)
                return true;
            
            while(idx < numbers.length && numbers[i] > numbers[idx])
                minElement = numbers[idx++];

            numbers[--idx] = numbers[i];
        }
        
        return false;
    }
}