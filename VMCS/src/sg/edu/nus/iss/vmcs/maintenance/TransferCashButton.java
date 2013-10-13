package sg.edu.nus.iss.vmcs.maintenance;

import javax.swing.JButton;

public class TransferCashButton extends JButton implements CommandInterface {

	public void processEvent(MaintenanceController mc) {
			mc.transferAll();
	    }

	public TransferCashButton(String name) {
	      super(name);
	    }
}
