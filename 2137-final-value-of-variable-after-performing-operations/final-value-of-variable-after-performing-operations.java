class Solution {
    public int finalValueAfterOperations(String[] operations) {
        var counter = 0;
        for (var operation : operations)
            if (operation.charAt(1) == '+')
                counter++;
            else
                counter--;
        return counter;
    }
}