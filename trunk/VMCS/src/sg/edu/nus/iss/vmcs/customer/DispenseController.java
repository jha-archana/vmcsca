package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class DispenseController {
	
	private TransactionController tCtrl;
	
	public DispenseController(TransactionController tCtrl)
	{
this.tCtrl=tCtrl;
}
	
	public void updateDrinkPanel()
	{
		
		
	}
	
	public void updateDrinkSelection(int index) {
        StoreItem item = tCtrl.getStoreController().getStoreItem(Store.DRINK, index);
        int quantity = item.getQuantity();
        StoreObject obj = item.getContent();
       // int price = ((DrinksBrand) obj).getCalculatedPrice();
        //String name = ((DrinksBrand) obj).getName();
       // tCtrl.getCustomerPanel().getDrinkSelectionBox().update(index, quantity, price, name);
}
	
public void allowSelection(boolean activeSelect) {
        
	tCtrl.getCustomerPanel().getDrinkSelectionBox().setActive(activeSelect);              
}
}