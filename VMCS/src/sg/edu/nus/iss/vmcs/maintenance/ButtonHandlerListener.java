package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Archana
 */ 
public class ButtonHandlerListener implements ActionListener {
	private MaintenanceController mctrl;

	public ButtonHandlerListener(MaintenanceController mc) {
		mctrl = mc;
	}
	public void actionPerformed(ActionEvent e) {
	      CommandInterface CommandObj = (CommandInterface) e.getSource();
	      CommandObj.processEvent(mctrl);
	    }
}
