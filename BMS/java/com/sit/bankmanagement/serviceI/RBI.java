package com.sit.bankmanagement.serviceI;

public interface RBI {
	void createAccount();

	void displayAllDetails();

	void depositeMoney();

	void withdrawal();

	void balanceCheck();

	void showTransactionHistory();

	void updateAccountDetails();

	boolean isAccountValid(long accNo, int pin);

	void getLoan();

	void largeAmountaccNo();
	
	void  viewsallaccNo();
	
	
	void Dstatement();
	 
	

}
