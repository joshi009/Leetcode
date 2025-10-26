class Bank {
    long[] acc;
    int n;

    public Bank(long[] balance) {
        this.acc = balance;
        this.n = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(1 > account1 || account1 > n || 1 > account2 || account2 > n)
            return false;

        if(withdraw(account1, money)){
            return deposit(account2, money);
        }
        
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account < 1 || account > n) return false;
        acc[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account < 1 || account > n || acc[account - 1] < money) return false;
        acc[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */