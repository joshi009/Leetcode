class Solution {
    public int totalMoney(int n) 
    {
        int weeks = n/7;
        int amount = 0;
        for(int i=0;i<weeks;i++)
        {
            amount += 28 + (7*i);
        }

        weeks+=1;

        for(int i=0;i<n%7;i++)
        {
            amount += weeks+i;
        }

        return amount;
    }
}