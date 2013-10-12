package sg.edu.nus.iss.vmcs.customer;

import java.awt.GridLayout;
import java.awt.Panel;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class DrinkSelectionBox extends Panel {
	 private int drink_identifiers[];

     private TransactionController transactionCtrl;
     private StoreController storeCtrl;
     private DrinkSelectionItem[] drinkSelectionItems;

     public DrinkSelectionBox(Panel container, TransactionController controller) {

             transactionCtrl = controller;
             storeCtrl = transactionCtrl.getStoreController();

             this.setLayout(new GridLayout(0, 3));

             int i, len;
             len = storeCtrl.getStoreSize(Store.DRINK);
             drink_identifiers = new int[len];
             StoreItem[] items = storeCtrl.getStoreItems(Store.DRINK);

             drinkSelectionItems = new DrinkSelectionItem[len];
            DrinkSelectionListener dsl = new DrinkSelectionListener(transactionCtrl);
             StoreObject ob;

             for (i = 0; i < len; i++) {
                     // drink_identifiers[i] = ((DrinksBrand) items[i].getContent())
                     // .getPrice();
                     drink_identifiers[i] = ((DrinksBrand) items[i].getContent())
                                     .getPrice();
                     drinkSelectionItems[i] = new DrinkSelectionItem(this, items[i], i);
                     drinkSelectionItems[i].addListener(dsl);
             }
             }
     
     public void setState(int brand_index, boolean active) {
         // activate / deactivate drink selection buttons on cust panel
         drinkSelectionItems[brand_index].setItemState(active);
 }


     
public void setActive(boolean active) {
	int len = drink_identifiers.length;
    for (int i = 0; i < len; i++) {
    	drinkSelectionItems[i].setItemState(active);
    }
}


public void update(int brand, int quantity, int price, String name) {
    drinkSelectionItems[brand].setName(name);
    drinkSelectionItems[brand].setPrice(price);
    if (quantity > 0) {
        setItemState(brand, true);
} else {
        setItemState(brand, false);
}
}

public void setItemState(int brand_index, boolean active) {
    setState(brand_index, active);
}
}