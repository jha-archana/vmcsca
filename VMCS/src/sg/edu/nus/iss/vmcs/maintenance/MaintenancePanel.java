package sg.edu.nus.iss.vmcs.maintenance;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.util.LabelledDisplay;
import sg.edu.nus.iss.vmcs.util.VMCSException;
import sg.edu.nus.iss.vmcs.util.WarningDisplay;

/**
 *
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 * @author Updated by Archana to apply Command Pattern
 */

public class MaintenancePanel extends Dialog {
	public final static int WORKING = 1;
	public final static int PSWD    = 2;
	public final static int DIALOG  = 3;

	private static final String TITLE = "Maintenance Panel";
	private LabelledDisplay password;
	private LabelledDisplay collectCash;
	private ExitButton exitBtn;
	private CoinDisplay cDisplay; // need to be access from other class.
	private DrinkDisplay dDisplay; // need to be access from other class.
	private TotalCashButton totalCash;
	private ResetPrice resetPrice;
	private TransferCashButton transferCash;
	private WarningDisplay validPswd;
	private WarningDisplay invalidPswd;
	private MaintenanceController mctrl;
	private Label totalCashValue;

	public MaintenancePanel(Frame fr, MaintenanceController mc) {
		super(fr, TITLE, false);

		mctrl = mc;

		// north part
		Label lb = new Label(TITLE);
		lb.setFont(new Font("Helvetica", Font.BOLD, 24));
		Panel tp1 = new Panel();
		tp1.add(lb);

		Panel tpn = new Panel();
		tpn.setLayout(new GridLayout(0, 1));

		password = new LabelledDisplay("Password:", 30, LabelledDisplay.FLOW);
		PasswordListener pl = new PasswordListener(mc.getAccessManager());
		password.addListener(pl);

		Panel tp3 = new Panel();
		validPswd = new WarningDisplay("Valid Password");
		invalidPswd = new WarningDisplay("Invalid Password");
		tp3.add(validPswd);
		tp3.add(invalidPswd);
		tpn.add(tp1);
		tpn.add(password);
		tpn.add(tp3);

		// center part
		Panel tpc = new Panel();
		tpc.setLayout(new GridLayout(0, 1));

		cDisplay = new CoinDisplay(mctrl);
		dDisplay = new DrinkDisplay(mctrl);

		Panel tp5 = new Panel();
		tp5.setLayout(new GridLayout(0, 1));
		
		//adding common button listener to interpret Command pattern
		ButtonHandlerListener buttonListener = new ButtonHandlerListener(mctrl);

		//totalCash = new ButtonItem("Show Total Cash Held", 5, ButtonItem.FLOW);
		
		//totalCash = new TotalCashButton("Show Total Cash Held", 5, ButtonItem.FLOW);
		totalCash = new TotalCashButton("Show Total Cash Held");
		//TotalCashButtonListener tl;

		//tl = new TotalCashButtonListener(mctrl);
		totalCash.addActionListener(buttonListener);
		
		/*Reset Price Button*/
		resetPrice = new ResetPrice("Reset Price");
		resetPrice.addActionListener(buttonListener);
				
		totalCashValue = new Label("          ");
		totalCashValue.setBackground(Color.white);

		transferCash = new TransferCashButton("Press to Collect All Cash");
		transferCash.addActionListener(buttonListener);

		Panel tp7 = new Panel();
		tp7.setLayout(new FlowLayout());
		tp7.add(resetPrice);
		tp7.add(totalCash);
		tp7.add(totalCashValue);

		
		Panel tp6 = new Panel();
		tp6.setLayout(new FlowLayout());
		tp6.add(transferCash);

		collectCash =
			new LabelledDisplay("Collect Cash:", 5, LabelledDisplay.FLOW);
		exitBtn = new ExitButton("Press Here when Finished");
		exitBtn.addActionListener(buttonListener);

		//tp5.add(totalCash);
		tp5.add(tp7);
		tp5.add(tp6);
		tp5.add(collectCash);
		tp5.add(exitBtn);
		tpc.setLayout(new BorderLayout());
		Panel pp = new Panel();
		pp.setLayout(new GridLayout(1, 2));
		pp.add(cDisplay);
		pp.add(dDisplay);
		tpc.add("Center", pp);
		tpc.add("South", tp5);

		this.setLayout(new BorderLayout());
		this.add("North", tpn);
		this.add("Center", tpc);

		pack();
		setLocation(200, 100);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mctrl.closeDown();
			}
		});
	}

	public void display() {
		System.out.println("MaintenancePanel: before display");
		this.setVisible(true);
		System.out.println("MaintenancePanel: after display");

	}

	public void closeDown() {
		dispose();

	}

	public CoinDisplay getCoinDisplay() {
		return cDisplay;
	}

	public DrinkDisplay getDrinksDisplay() {
		return dDisplay;
	}

	public void displayPasswordState(boolean st) {
		if (st == true) {
			validPswd.setState(true);
			invalidPswd.setState(false);
		} else {
			validPswd.setState(false);
			invalidPswd.setState(true);
		}

	}

	public void setActive(int comp, boolean st) {
		switch (comp) {
			case DIALOG :
				setActive(PSWD, st);
				setActive(WORKING, !st);
				validPswd.setState(false);
				invalidPswd.setState(false);
				break;
			case WORKING :
				collectCash.setActive(st);
				cDisplay.setActive(st);
				dDisplay.setActive(st);
				totalCash.setEnabled(st);
				transferCash.setEnabled(st);
				break;
			case PSWD :
				password.setActive(st);
				break;
		}
	}

	public int getCurIdx() {
		return dDisplay.getCurIdx();
	}

	public void displayTotalCash(int tc) {
		String stc;

		stc = new String(tc + " C");
		//totalCash.setValue(stc);
		totalCashValue.setText(stc);
	}

	public void displayCoins(int cc) {
		collectCash.setValue(cc);
	}

	/**
	 *  use when machinery simulator panel changes qty;
	 *  It is used to automatically update the displayed quantity in maintenance panel.
	 *  It is called by Maintenance Controller
	 *  Not required in requirement.
	 */

	public void updateQtyDisplay(int type, int idx, int qty)
		throws VMCSException {
		if (type == Store.CASH) {
			cDisplay.displayQty(idx, qty);
		} else
			dDisplay.displayQty(idx, qty);
	}

	/**
	 * When transfer all button is pushed, the current display needs to be updated.
	 * not required in requirement.
	 */
	public void updateCurrentQtyDisplay(int type, int qty)
		throws VMCSException {
		int curIdx;
		if (type == Store.CASH)
			curIdx = cDisplay.getCurIdx();
		else
			curIdx = dDisplay.getCurIdx();
		updateQtyDisplay(type, curIdx, qty);
	}

	public void initCollectCash() {
		collectCash.setValue("");
	}

	public void initTotalCash() {
		//totalCash.setValue("");
		totalCashValue.setText("");
	}

	public void clearPassword() {
		password.setValue("");
	}

	public void displayPrice(int qty) {
		dDisplay.getPriceDisplay().setValue(qty + "C");
	}
}
