package sg.edu.nus.iss.vmcs.customer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import sg.edu.nus.iss.vmcs.transaction.TransactionController;
import sg.edu.nus.iss.vmcs.util.LabelledDisplay;

public class CustomerPanel extends Dialog {

	private static final String TITLE = "Customer Panel";
	public static final char DIALOG = 'a';
	private Button terminateButton;
	public final static Color ACT_COLOR = Color.white;
	private DrinkSelectionBox drinkSelectionBox;
	private CoinInputBox coinInputBox;
	private TransactionController transactionController;
	private static final String HEADING = "VMCS Soft Drink Dispenser";
	private LabelledDisplay refundChangeTrayDisplay;
	private LabelledDisplay canCollectionBox;
	private LabelledDisplay totalMoneyInsertedDisplay;

	public CustomerPanel(Frame fr, TransactionController transactController) {
		super(fr, TITLE);
		this.transactionController = transactController;

		Label titleLabel = new Label(TITLE);
		titleLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
		Panel northPanel = new Panel();
		northPanel.setLayout(new GridLayout(0, 1));
		Panel southPanel = new Panel();
		southPanel.setLayout(new GridLayout(0, 1));
		Label heading = new Label(HEADING);
		heading.setFont(new Font("Helvetica", Font.BOLD, 24));
		northPanel.add(heading);
		// Panel tp1 = new Panel();
		// tp1.add(lb);

		/*
		 * Label lb = new Label("VIMTO Soft Drink Dispenser"); lb.setFont(new
		 * Font("Helvetica", Font.BOLD, 24)); lb.setAlignment(Label.CENTER);
		 */

		Panel centerPanel = new Panel();
		centerPanel.setLayout(new GridLayout(0, 1));

		// Drink selection box
		totalMoneyInsertedDisplay=new LabelledDisplay("Total Money Inserted:", 5,
				LabelledDisplay.FLOW);
		totalMoneyInsertedDisplay.setEditable(false);
		totalMoneyInsertedDisplay.setValue("0 c");
		drinkSelectionBox = new DrinkSelectionBox(northPanel,
				transactionController);
		centerPanel.add(drinkSelectionBox);
		coinInputBox = new CoinInputBox(northPanel,
				transactionController.getCoinReceiver());
		northPanel.add(coinInputBox);
		northPanel.add(totalMoneyInsertedDisplay);
		
         terminateButton = new Button("Terminate and Return Cash"); 
        // TerminateButtonListener tbl = new TerminateButtonListener(
                      //   this.transactionController);
        // terminateButton.setEnabled(false);
        // terminateButton.addActionListener(tbl);
         
         northPanel.add(terminateButton);
		refundChangeTrayDisplay = new LabelledDisplay("Collect Coins:", 5,
				LabelledDisplay.FLOW);
		refundChangeTrayDisplay.setEditable(false);
		refundChangeTrayDisplay.setValue("0 c");
		southPanel.add(refundChangeTrayDisplay);
		canCollectionBox = new LabelledDisplay("Collect Cans:", 10,
				LabelledDisplay.FLOW);
		canCollectionBox.setEditable(false);
		canCollectionBox.setValue("");
		southPanel.add(canCollectionBox);

		// layout setup
		this.setLayout(new BorderLayout());
		this.add("North", northPanel);
		this.add("Center", centerPanel);
		this.add("South", southPanel);

		pack();
		setLocation(200, 100);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				transactionController.closeDown();
			}
		});

	}

	public DrinkSelectionBox getDrinkSelectionBox() {
		return drinkSelectionBox;
	}

	public void display() {
		this.setVisible(true);
	}

	public LabelledDisplay getRefundChangeTrayDisplay() {
		return refundChangeTrayDisplay;
	}

	public LabelledDisplay getCanCollectionBox() {
		return canCollectionBox;
	}

	public CoinInputBox getCoinInputBox() {
		return coinInputBox;
	}

	public LabelledDisplay getTotalMoneyInsertedDisplay() {
		return totalMoneyInsertedDisplay;
	}

	public void setTotalMoneyInsertedDisplay(
			LabelledDisplay totalMoneyInsertedDisplay) {
		this.totalMoneyInsertedDisplay = totalMoneyInsertedDisplay;
	}
	public void closeDown() {
		dispose();
	}

}
