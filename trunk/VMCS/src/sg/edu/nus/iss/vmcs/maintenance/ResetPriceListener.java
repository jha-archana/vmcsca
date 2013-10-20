package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */

public class ResetPriceListener implements ActionListener {
	MaintenanceController mctrl;

	public ResetPriceListener(MaintenanceController mc) {
		mctrl = mc;
	}
	public void actionPerformed(ActionEvent e) {
		mctrl.getTotalCash();
	}
}