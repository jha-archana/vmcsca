
package sg.edu.nus.iss.vmcs.bridge;
/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import java.io.*;

import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 *
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public abstract class PropertyLoader {
	
	public abstract void initialize() throws IOException;
	
	public abstract void saveProperty() throws IOException; 

	public abstract int getNumOfItems();

	public abstract void setNumOfItems(int numItems);

	public abstract StoreItem getItem (int index);

	public abstract void setItem (int index, StoreItem item);

}
