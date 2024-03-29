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

public class DrinkPropertyLoader extends PropertyLoader {

	private static final String NAME_LABEL     = "Name";
	private static final String PRICE_LABEL    = "Price";
	private static final String QUANTITY_LABEL = "Quantity";

	private PropertyLoaderImpl fileProperyLoader;	 
	 
    public DrinkPropertyLoader(String filen) {
    	fileProperyLoader = new FilePropertyLoader(filen);

    }

	public StoreItem getItem(int index) {
		int idx = index + 1;
		DrinksBrand brand = new DrinksBrand();

		String name = new String(NAME_LABEL + idx);
		String value = fileProperyLoader.getValue(name);
		brand.setName(value);

		name = new String(PRICE_LABEL + idx);
		value = fileProperyLoader.getValue(name);
		brand.setPrice(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = fileProperyLoader.getValue(name);
		int qty = Integer.parseInt(value);

		DrinksStoreItem item = new DrinksStoreItem(brand, qty);
		return item;

	}

	public void setItem(int index, StoreItem drinksItem) {
		int idx = index + 1;

		DrinksStoreItem item = (DrinksStoreItem) drinksItem;
		DrinksBrand brand = (DrinksBrand) item.getContent();
		String itn = new String(NAME_LABEL + idx);
		fileProperyLoader.setValue(itn, brand.getName());

		itn = new String(PRICE_LABEL + idx);
		fileProperyLoader.setValue(itn, String.valueOf(brand.getPrice()));

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
