package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class DispenseController {

	private TransactionController tCtrl;

	public DispenseController(TransactionController tCtrl) {
		this.tCtrl = tCtrl;
	}

	public void updateDrinkPanel() {
		int len = tCtrl.getMainController().getStoreController().getStoreSize(Store.DRINK);
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
}