package sg.edu.nus.iss.vmcs.maintenance;

import javax.swing.JButton;

/**
 * @author Tee Kai Xin
 */ 
public class ResetPrice extends JButton implements CommandInterface {

	public void processEvent(MaintenanceController mc) {
		mc.resetPrice();
    }

	public ResetPrice(String name) {
      super(name);
    }
}
