package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.CashStore;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class CoinReceiver {
	private TransactionController tCtrl;
	private int totalInserted;
	private List<Coin> coins;

	public CoinReceiver(TransactionController tCtrl) {
		this.tCtrl = tCtrl;
		totalInserted = 0;
		coins = new ArrayList<Coin>();
	}

	public int getTotalInserted() {
		return totalInserted;
	}

	public void setTotalInserted(int totalInserted) {
		this.totalInserted = totalInserted;
	}

	public TransactionController getTransactionController() {
		return tCtrl;
	}

	public void setActive(boolean status) {

		tCtrl.getCustomerPanel().getCoinInputBox().setActive(status);
	}

	public void startReceive() {

		setActive(true);
		totalInserted = 0;
		coins.clear();

	}

	public void receiveCoin(double weight) {
		setActive(false);
		Coin foundCoin = ((CashStore) tCtrl.getStoreController().getStore(
				Store.CASH)).findCoin(weight);
		System.out.println("coin.foundCoin()" + foundCoin);
		if (foundCoin != null) {
			totalInserted = totalInserted + foundCoin.getValue();
			coins.add(foundCoin);
			System.out.println("totalInserted" + totalInserted);
			tCtrl.processMoneyReceived(totalInserted);

		}

	}
	

	public void continueReceive() {
		setActive(true);

	}

	public boolean storeCash() {
		return true;
	}

	public void stopReceive() {
		setActive(false);
	}
	
	public void refundcash()
	{
		
		
	}
}
