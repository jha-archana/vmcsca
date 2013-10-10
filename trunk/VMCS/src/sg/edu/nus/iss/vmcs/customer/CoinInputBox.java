package sg.edu.nus.iss.vmcs.customer;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.vmcs.store.CashStore;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class CoinInputBox extends Panel{
	 private StoreController ctrl;
     private CoinReceiver coinReceiver;
     private double[] coin_weights;
     private List<Button> buttons;
     public CoinInputBox(Panel composite, CoinReceiver coinReceiver) {
    	 this.coinReceiver = coinReceiver;
    	 ctrl=coinReceiver.getTransactionController().getStoreController();
    	int len = ctrl.getStoreSize(Store.CASH);
         StoreItem[] items = ctrl.getStoreItems(Store.CASH);
         Label lb = new Label("Enter Coins Here", Label.LEFT);
         this.add(lb);
         this.setLayout(new GridLayout(0, 1));

         Panel coinPanel = new Panel();
         coinPanel.setLayout(new GridLayout(0, len + 1)); // the +1 is for additional space
         CoinInputBoxListener   coinInputBoxListener = new CoinInputBoxListener(coinReceiver);                                                                       // for Invalid Coin
         int i;
         StoreObject coin;
         buttons = new ArrayList<Button>();
         coin_weights = new double[len];
//       CoinInputBoxListener cibl = new CoinInputBoxListener();
         for (i = 0; i < len; i++) {
                 coin = items[i].getContent();
                 coin_weights[i] = ((Coin) coin).getWeight();
                 Button btn=new Button(coin.getName());
btn.addActionListener(coinInputBoxListener);
                btn.setActionCommand(String.valueOf(coin_weights[i]));
                 btn.setEnabled(false);
                 buttons.add(btn);
                 
                 coinPanel.add(btn);
                 
         }
         Button btn =  new Button("Invalid");
         btn.addActionListener(coinInputBoxListener);
         btn.setActionCommand(String.valueOf(Coin.INVALID_COIN));
         btn.setEnabled(false);
         buttons.add(btn);
         coinPanel.add(btn);
         this.add(coinPanel);
              
 }
     
     
 

 public void setActive(boolean b) {
	 for(Button btn:buttons)
	 {
		 
		 btn.setEnabled(b);
	 }
 }
}
