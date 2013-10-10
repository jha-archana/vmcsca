package sg.edu.nus.iss.vmcs.transaction;

public class CoinInputState extends TransactionState{

	@Override
	public void startTransaction(TransactionController controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processMoneyReceived(TransactionController controller, int coin) {
		// TODO Auto-generated method stub
		if(coin<getPrice())
		{
			controller.getCoinReceiver().continueReceive();
		}
		else
		{
			completeTransaction(controller);
		}
	}
	private void completeTransaction(TransactionController controller)
	{
		
		controller.getDispenseController().dispenseDrink(getSelection());
		
	}

}
