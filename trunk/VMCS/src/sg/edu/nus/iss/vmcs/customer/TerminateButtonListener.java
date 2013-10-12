package sg.edu.nus.iss.vmcs.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class TerminateButtonListener implements ActionListener {
    
    private TransactionController trxCtrl;
    
    public TerminateButtonListener (TransactionController trxCtrl) { 
            this.trxCtrl = trxCtrl;
    }
    
    public void actionPerformed (ActionEvent e) {
            trxCtrl.cancelTransaction();
    }

}
