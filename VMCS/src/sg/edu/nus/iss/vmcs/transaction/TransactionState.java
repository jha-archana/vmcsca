package sg.edu.nus.iss.vmcs.transaction;

public abstract class TransactionState {

	public abstract void startTransaction(TransactionController controller,int item);
}
