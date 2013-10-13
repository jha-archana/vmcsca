package sg.edu.nus.iss.vmcs.maintenance;

import javax.swing.JButton;

/**
 * @author Archana
 */ 

public class ExitButton  extends JButton implements CommandInterface {

	
	private static final long serialVersionUID = 1L;

	public void processEvent(MaintenanceController mc) {
	      mc.logoutMaintainer();
	    }

	public ExitButton(String name) {
	      super(name);
	    }
}
