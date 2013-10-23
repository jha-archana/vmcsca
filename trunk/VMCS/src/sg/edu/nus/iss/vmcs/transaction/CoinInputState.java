package sg.edu.nus.iss.vmcs.transaction;

import sg.edu.nus.iss.vmcs.util.VMCSException;
/**
 * 
 * @author ALPHY
 *
 */
public class CoinInputState extends TransactionState{
	CoinInputState()
	{}
	@Override
	public void startTransaction(TransactionController controller) {
		// TODO Auto-generated method stub
		
		super.refundMoney(controller);
	}

	@Override
	public void processMoneyReceived(TransactionController controller, int coin) {
		// TODO Auto-generated method stub
		System.out.println("getprice"+controller.getPrice());
		System.out.println("coin"+coin);
		if(coin<controller.getPrice())
		{
			controller.getCoinReceiver().continueReceive();
		}
		else
		{
			if(completeTransaction(controller))
			{
				controller.setDrinkdispensed(true);
			if(coin>controller.getPrice())
			{
				
				if(controller.getChangeGiver().giveChange(coin-controller.getPrice()))
				{
				controller.setChangegiven(true);
				storecash(controller);
				}
			}
			else
			{
				storecash(controller);
			}
		}
		}
	}
	
	private void storecash(TransactionController controller)
	{
		controller.setChangegiven(true);
		if(controller.getCoinReceiver().storeCash())
		{
			
			controller.getDispenseController().allowSelection(true);
			controller.setState(new DrinkSelectionState());
			
		}
		
	}
	private boolean completeTransaction(TransactionController controller)
	{
		
		try {
			return controller.getDispenseController().dispenseDrink(controller.getSelection());
		} catch (VMCSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
@Override
	public void cancelTransaction(TransactionController controller) {
		super.cancelTransaction(controller);		
		controller.setState(new DrinkSelectionState());
	}

}
