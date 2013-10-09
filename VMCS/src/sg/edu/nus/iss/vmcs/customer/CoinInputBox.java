package sg.edu.nus.iss.vmcs.customer;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import sg.edu.nus.iss.vmcs.store.CashStore;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class CoinInputBox extends Panel{
	 private TransactionController ctrl;
     private StoreController storeCtrl;
     public CoinInputBox(Panel composite, TransactionController controller) {
         ctrl = controller;
         
       //  StoreItem[] items = storeCtrl.getStoreItems(Store.CASH);

         this.setLayout(new GridLayout(0, 1));

         // add title
         Label lb = new Label("Enter Coins Here", Label.LEFT);
         this.add(lb);

         // add coin buttons
        
         
         //this.add(coinPanel);            
 }

 public void setActive(boolean b) {
         /*for (int i = 0; i < len; i++) {
                 buttons[i].setEnabled(b);
         }
         invalidCoinButton.setEnabled(b);*/
 }
}
