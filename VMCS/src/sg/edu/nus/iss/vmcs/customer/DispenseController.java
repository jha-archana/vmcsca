package sg.edu.nus.iss.vmcs.customer;


import java.util.Observable;
import java.util.Observer;
import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

import sg.edu.nus.iss.vmcs.util.VMCSException;

public class DispenseController implements Observer{

	private TransactionController tCtrl;

	public DispenseController(TransactionController tCtrl) {
		this.tCtrl = tCtrl;
		
	}

	public void updateDrinkPanel() {
		int len = tCtrl.getMainController().getStoreController()
				.getStoreSize(Store.DRINK);
		for (int i = 0; i < len; i++) {
			updateDrinkSelection(i);
		}
	}

	public void updateDrinkSelection(int index) {
		StoreItem item = tCtrl.getStoreController().getStoreItem(Store.DRINK,
				index);
		int quantity = item.getQuantity();
		StoreObject obj = item.getContent();
		int price = ((DrinksBrand) obj).getPrice();
		String name = ((DrinksBrand) obj).getName();
		tCtrl.getCustomerPanel().getDrinkSelectionBox()
				.update(index, quantity, price, name);
	}

	public void allowSelection(boolean activeSelect) {

		tCtrl.getCustomerPanel().getDrinkSelectionBox().setActive(activeSelect);
	}
	
	public void resetCan()
	{
		
		tCtrl.getCustomerPanel().getCanCollectionBox().setValue("");
	}
	
	
	
	public boolean dispenseDrink(int idx) throws VMCSException {
		tCtrl.getMachineryController().dispenseDrink(idx);
		//tCtrl.getStoreController().dispenseDrink(item);
		tCtrl.getCustomerPanel().getCanCollectionBox().setValue(tCtrl.getSelection());
		return true;
	}

	@Override
	public void update(Observable storeItem, Object object) {	
		updateDrinkPanel();
	}
}