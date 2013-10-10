package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class CoinReceiver {
private TransactionController tCtrl;
	
	public CoinReceiver(TransactionController tCtrl)
	{
this.tCtrl=tCtrl;
}
	public TransactionController getTransactionController()
	{
		return tCtrl;
	}
	public void setActive(boolean status)
	{
		
		tCtrl.getCustomerPanel().getCoinInputBox().setActive(status);
	}
	public void startReceive()
	{
		
		setActive(true);
		
	}
	
	public void receiveCoin(int coin)
	{
		
		
	}
	
	public void continueReceive()
	{
		setActive(true);
		
	}
}
