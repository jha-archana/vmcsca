package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class ChangeGiver {
	private TransactionController tCtrl;

	public ChangeGiver(TransactionController tCtrl) {
		this.tCtrl = tCtrl;
	}

	public void resetChange() {
		tCtrl.getCustomerPanel().getRefundChangeTrayDisplay().setValue(0);
	}

	public void displayChangeStatus() {

	}

	public boolean giveChange(int change_required) {
		System.out.println("change_required" + change_required);
		//tCtrl.getMainController().getMachineryController().giveChange(idx, numOfCoins);
		tCtrl.getCustomerPanel().getRefundChangeTrayDisplay().setValue(change_required);
		return true;

	}
}
