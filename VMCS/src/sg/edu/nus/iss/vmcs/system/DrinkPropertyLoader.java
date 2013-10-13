package sg.edu.nus.iss.vmcs.system;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import sg.edu.nus.iss.vmcs.store.*;
import java.io.IOException;

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
	private PropertyLoaderImpl fileLoader;
	
	public DrinkPropertyLoader(String filen) {
		fileLoader = new FilePropertyLoader(filen);
	}

	public StoreItem getItem(int index) {
		int idx = index + 1;
		DrinksBrand brand = new DrinksBrand();

		String name = new String(NAME_LABEL + idx);
		String value = fileLoader.getValue(name);
		brand.setName(value);

		name = new String(PRICE_LABEL + idx);
		value = fileLoader.getValue(name);
		brand.setPrice(Integer.parseInt(value));

		name = new String(QUANTITY_LABEL + idx);
		value = fileLoader.getValue(name);
		int qty = Integer.parseInt(value);

		DrinksStoreItem item = new DrinksStoreItem(brand, qty);
		return item;

	}

	public void setItem(int index, StoreItem drinksItem) {
		int idx = index + 1;

		DrinksStoreItem item = (DrinksStoreItem) drinksItem;
		DrinksBrand brand = (DrinksBrand) item.getContent();
		String itn = new String(NAME_LABEL + idx);
		fileLoader.setValue(itn, brand.getName());

		itn = new String(PRICE_LABEL + idx);
		fileLoader.setValue(itn, String.valueOf(brand.getPrice()));

		itn = new String(QUANTITY_LABEL + idx);
		fileLoader.setValue(itn, String.valueOf(item.getQuantity()));

	}
	
public void initialize() throws IOException {		 
        fileLoader.initialize();
}

public void saveProperty() throws IOException {
        fileLoader.saveProperty();
}
public int getNumOfItems() {
        return fileLoader.getNumOfItems();
}
public void setNumOfItems(int numItems) {
        fileLoader.setNumOfItems(numItems);
}


}
