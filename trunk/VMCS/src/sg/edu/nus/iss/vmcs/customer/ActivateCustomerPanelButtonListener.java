package sg.edu.nus.iss.vmcs.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.system.SimulationController;

public class ActivateCustomerPanelButtonListener implements ActionListener {
	private SimulationController ctrl;

	public ActivateCustomerPanelButtonListener(SimulationController ct) {
		ctrl = ct;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ctrl.setupCustomer();
	}

}
