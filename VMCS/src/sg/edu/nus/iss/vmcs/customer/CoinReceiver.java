package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class CoinReceiver {
private TransactionController tCtrl;
	
	public CoinReceiver(TransactionController tCtrl)
	{
this.tCtrl=tCtrl;
}
	
	public void setActive(boolean status)
	{
		
		
	}
	public void startReceive()
	{
		
	tCtrl.getCustomerPanel().getCoinInputBox().setActive(true);
		
	}
}
