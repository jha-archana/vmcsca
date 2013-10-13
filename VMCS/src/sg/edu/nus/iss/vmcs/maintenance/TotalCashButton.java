package sg.edu.nus.iss.vmcs.maintenance;

import javax.swing.JButton;

/**
 * @author Archana
 */ 
public class TotalCashButton extends JButton implements CommandInterface {

	public void processEvent(MaintenanceController mc) {
		mc.getTotalCash();
    }

	public TotalCashButton(String name) {
      super(name);
    }
}
