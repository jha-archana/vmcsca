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
     

     public DrinkSelectionBox(Panel container, TransactionController controller) {

             transactionCtrl = controller;
             storeCtrl = transactionCtrl.getStoreController();

             this.setLayout(new GridLayout(0, 3));

             int i, len;
             len = storeCtrl.getStoreSize(Store.DRINK);
             drink_identifiers = new int[len];
             StoreItem[] items = storeCtrl.getStoreItems(Store.DRINK);

             
             }
     
public void setActive(boolean active) {
    
}

}