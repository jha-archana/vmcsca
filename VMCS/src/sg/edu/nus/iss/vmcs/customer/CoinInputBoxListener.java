package sg.edu.nus.iss.vmcs.customer;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.store.Coin;

public class CoinInputBoxListener implements ActionListener {

    private CoinReceiver coinReceiver = null;

    public CoinInputBoxListener(CoinReceiver coinReceiver) {
            this.coinReceiver = coinReceiver;
    }

    public void actionPerformed (ActionEvent e) {
    	
    	Button btn = (Button) e.getSource();
        String cmd = btn.getActionCommand();
        System.out.println("cmd"+cmd);
         try
         {
            if (!cmd.equalsIgnoreCase(Integer.toString(Coin.INVALID_COIN))) {
                    
                    double weight = Double.parseDouble(cmd);
                    
                    coinReceiver.receiveCoin(weight);
            }
         }
         catch(Exception ex)
         {
        	 
        	 System.out.println("exc"+ex.getMessage());
         }
    }

	

}
