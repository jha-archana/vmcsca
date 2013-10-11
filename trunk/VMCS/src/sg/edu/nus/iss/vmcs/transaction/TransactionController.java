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
	private TransactionState currentState;
	private int price;
	private int selection;
	private boolean changegiven;
	private boolean drinkdispensed;
	
	public TransactionController(MainController mctrl)
	{
		mCtrl = mctrl;
		dCtrl=new DispenseController(this);
		cRcvr=new CoinReceiver(this);
		cGvr=new ChangeGiver(this);
		strCtrl=mCtrl.getStoreController();
		
		
	}
	
	public boolean isChangegiven() {
		return changegiven;
	}

	public void setChangegiven(boolean changegiven) {
		this.changegiven = changegiven;
	}

	public boolean isDrinkdispensed() {
		return drinkdispensed;
	}

	public void setDrinkdispensed(boolean drinkdispensed) {
		this.drinkdispensed = drinkdispensed;
	}

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public int getSelection() {
		return selection;
	}


	public void setSelection(int selection) {
		this.selection = selection;
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
	
	
	public MainController getMainController() {
        return mCtrl;
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
		dCtrl.allowSelection(true);
		currentState=new DrinkSelectionState();
		changegiven=false;
		drinkdispensed=false;
	}
	
	public void startTransaction(int selectedItem)
	{
		setSelection(selectedItem);
		currentState.startTransaction(this);
		
	}
	
	public void processMoneyReceived(int coin)
	{
		currentState.processMoneyReceived(this, coin);
		
	}
	
	public void terminateTransaction()
	{
		
		
	}
	public DispenseController getDispenseController()
	{
		
		return dCtrl;
	}
	
	public void setState(TransactionState state)
	{
		
		this.currentState=state;
		
	}
	
}
