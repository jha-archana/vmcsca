package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class ChangeGiver {
private TransactionController tCtrl;
	
	public ChangeGiver(TransactionController tCtrl)
	{
this.tCtrl=tCtrl;
}
	 public void resetChange() {
		 tCtrl.getCustomerPanel().getRefundChangeTrayDisplay().setValue(0);
 }       

	public void displayChangeStatus()
	{
		
		
		
	}
}