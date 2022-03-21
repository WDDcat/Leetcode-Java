package general_2000_2099;

public class _2043_Simple_Bank_System {
	
	/*
	 * 这题……
	 * 我连题解都不想写
	 * 好没意思
	 * */
	
	private long[] balance;
	private int length;
	public _2043_Simple_Bank_System(long[] balance) {
		this.balance = balance;
		this.length = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
    	if(account1 <= length && account1 > 0 && balance[account1 - 1] >= money
    			&& account2 <= length && account2 > 0) {
    		balance[account1 - 1] -= money;
    		balance[account2 - 1] += money;
    		return true;
    	}
    	return false;
    }
    
    public boolean deposit(int account, long money) {
    	if(account <= length && account > 0) {
    		balance[account - 1] += money;
    		return true;
    	}
    	return false;
    }
    
    public boolean withdraw(int account, long money) {
    	if(account <= length && account > 0 && balance[account - 1] >= money) {
    		balance[account - 1] -= money;
    		return true;
    	}
    	return false;
    }
}
