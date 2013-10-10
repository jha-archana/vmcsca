package sg.edu.nus.iss.vmcs.transaction;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;

public class DrinkSelectionState extends TransactionState{

	@Override
	public void startTransaction(TransactionController controller) {
		// TODO Auto-generated method stub
		StoreItem storeitem=controller.getStoreController().getStoreItem(Store.DRINK, getSelection());
		DrinksBrand drink=(DrinksBrand) storeitem.getContent();
		int price=drink.getPrice();
		setPrice(price);
		controller.getChangeGiver().resetChange();
		controller.getDispenseController().resetCan();
		controller.getChangeGiver().displayChangeStatus();
		controller.getDispenseController().allowSelection(false);
		controller.getCoinReceiver().startReceive();
		controller.setState(new CoinInputState());
	}

	@Override
	public void processMoneyReceived(TransactionController controller, int coin) {
		// TODO Auto-generated method stub
		
	}

}
