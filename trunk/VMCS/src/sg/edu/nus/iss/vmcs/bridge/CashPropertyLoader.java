package sg.edu.nus.iss.vmcs.bridge;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import java.io.IOException;

import sg.edu.nus.iss.vmcs.store.*;

/**
 *
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */

public class CashPropertyLoader extends PropertyLoader {

	private static final String NAME_LABEL     = "Name";
	private static final String WEIGHT_LABEL   = "Weight";
	private static final String VALUE_LABEL    = "Value";
	private static final String QUANTITY_LABEL = "Quantity";

	private PropertyLoaderImpl fileProperyLoader;	 
	 
    public CashPropertyLoader(String filen) {
    	fileProperyLoader = new FilePropertyLoader(filen);

    }

	public StoreItem getItem (int index) {
		int idx = index + 1;
		Coin coin = new Coin();

		String name = new String(NAME_LABEL + idx);
		String value = fileProperyLoader.getValue(name);
		coin.setName(value);

		name = new String(WEIGHT_LABEL + idx);
		value = fileProperyLoader.getValue(name);
		coin.setWeight(Double.parseDouble(value));

		name = new String(VALUE_LABEL + idx);
		value = fileProperyLoader.getValue(name);
		coin.setValue(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = fileProperyLoader.getValue(name);
		int qty = Integer.parseInt(value);

		CashStoreItem item = new CashStoreItem(coin, qty);
		return item;
	}

	public void setItem(int index, StoreItem cashItem) {
		int idx = index + 1;

		CashStoreItem item = (CashStoreItem) cashItem;
		Coin cn = (Coin) item.getContent();
		String itn = new String(NAME_LABEL + idx);

		fileProperyLoader.setValue(itn, cn.getName());

		itn = new String(WEIGHT_LABEL + idx);
		fileProperyLoader.setValue(itn, String.valueOf(cn.getWeight()));

		itn = new String(VALUE_LABEL + idx);
		fileProperyLoader.setValue(itn, String.valueOf(cn.getValue()));

		itn = new String(QUANTITY_LABEL + idx);
		fileProperyLoader.setValue(itn, String.valueOf(item.getQuantity()));
	}

	@Override
	public void initialize() throws IOException {
		fileProperyLoader.initialize();
		
	}

	@Override
	public void saveProperty() throws IOException {
		fileProperyLoader.saveProperty();
		
	}

	@Override
	public int getNumOfItems() {		
		return fileProperyLoader.getNumOfItems();
	}

	@Override
	public void setNumOfItems(int numItems) {
		fileProperyLoader.setNumOfItems(numItems);		
	}

}