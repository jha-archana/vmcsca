package sg.edu.nus.iss.vmcs.customer;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class DrinkSelectionListener implements ActionListener {
    
    private TransactionController tctrl;
    
    public DrinkSelectionListener (TransactionController transaction_controller) {
            tctrl = transaction_controller;
    }
    
    public void actionPerformed (ActionEvent e) { 
            Button btn = (Button) e.getSource();
            String cmd = btn.getActionCommand();
            int idx = Integer.parseInt(cmd);
            System.out.println("Button index / Drink name / price: " 
                            + idx 
                            + " / "
                            + tctrl.getStoreController().getStore(Store.DRINK).getStoreItem(idx).getContent().getName()
                            + " / "
                            + ((DrinksBrand) tctrl.getStoreController().getStore(Store.DRINK).getStoreItem(idx).getContent()).getPrice());
            tctrl.startTransaction(idx);
    }
}
