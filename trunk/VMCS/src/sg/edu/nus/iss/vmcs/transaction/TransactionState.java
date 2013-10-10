package sg.edu.nus.iss.vmcs.transaction;

public abstract class TransactionState {
	private int price;
	private int selection;
	public abstract void startTransaction(TransactionController controller);
	public abstract void processMoneyReceived(TransactionController controller,int coin);
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public int getSelection() {
		return selection;
	}


	public void setSelection(int selection) {
		this.selection = selection;
	}
}
