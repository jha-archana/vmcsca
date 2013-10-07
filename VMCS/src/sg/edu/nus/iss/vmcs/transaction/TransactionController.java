package sg.edu.nus.iss.vmcs.transaction;

import java.awt.Frame;

import sg.edu.nus.iss.vmcs.customer.ChangeGiver;
import sg.edu.nus.iss.vmcs.customer.CoinReceiver;
import sg.edu.nus.iss.vmcs.customer.CustomerPanel;
import sg.edu.nus.iss.vmcs.customer.DispenseController;
import sg.edu.nus.iss.vmcs.maintenance.MaintenancePanel;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.system.MainController;
import sg.edu.nus.iss.vmcs.system.SimulatorControlPanel;

public class TransactionController {
	private MainController mCtrl;
	private DispenseController dCtrl;
	private CoinReceiver cRcvr;
	private ChangeGiver cGvr;
	private CustomerPanel cPnl;
	private StoreController strCtrl;
	public TransactionController(MainController mctrl)
	{
		mCtrl = mctrl;
		dCtrl=new DispenseController(this);
		cRcvr=new CoinReceiver(this);
		cGvr=new ChangeGiver(this);
		strCtrl=mCtrl.getStoreController();
		
	}

	public CoinReceiver getCoinReceiver()
	{
		return cRcvr;
		
	}
	
	public ChangeGiver getChangeGiver()
	{
		return cGvr;
		
	}
	
	public StoreController getStoreController()
	{
		return strCtrl;
		
	}
	
	public CustomerPanel getCustomerPanel()
	{
		
		
		return cPnl;
	}
	public void displayCustomerPanel()
	{
		
		SimulatorControlPanel scp = mCtrl.getSimulatorControlPanel();
		if (cPnl == null)
			cPnl = new CustomerPanel((Frame) scp, this);
		cPnl.display();
		//cPnl.setActive(MaintenancePanel.DIALOG, true);
		dCtrl.updateDrinkPanel();
		
	}
	
	
}
