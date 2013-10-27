
package sg.edu.nus.iss.vmcs.store;
/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import java.io.*;
import java.util.Properties;

/**
 *
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li 
 */

/**
 * 
 * @Modified By Divya 
 *
 */
public abstract class PropertyLoader {
	
	private PropertyLoaderImpl loader;
	private static final String PROP_NUM_ITEMS = "NumOfItems";
	private Properties prop;
 
    public PropertyLoader(PropertyLoaderImpl loader) {
          this.loader = loader;          
    }  
    
    //read data from file
    public void initialize()
    {
    	 try {
 			prop=this.loader.initialize();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    
    //save data back to file
    public void save(){

            try {
            loader.saveProperty(prop);
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }  
    
    /**	 
     * This operation returns the number of items (either CashPropertyLoader 	 
     * or DrinkPropertyLoader) stored in the hash table.
     * @return the number of items (either CashCashPropertyLoader 	 
     * or DrinkCashPropertyLoader)	 
     */	 
    public int getNumOfItems() {
		String nm = prop.getProperty(PROP_NUM_ITEMS);
		int nmi;
		nmi = Integer.parseInt(nm);
		return nmi;
	}

    /**	 
     * This operation sets the number of items (either CashCashPropertyLoader or 	 
     * DrinkCashPropertyLoader) stored in the hash table. 	 
     * @param numItems the integer value that determines the number of items.	 
     */	 
	public void setNumOfItems(int vl) {
		prop.setProperty(PROP_NUM_ITEMS, String.valueOf(vl));
	}
	
	/**	 
     * This operation reads data from the hash table and creates a StoreLoader. 	 
     * @param key the position of the PropertyLoader item in the hash table.	 
     * @return returns the PropertyLoader item.	 
     */	 
	public String getValue(String key) {
		return prop.getProperty(key);
	}


    /**	 
     * This operation updates the hash table with data from the PropertyLoader. 	 
     * @param key the position value of the Item in the hash table.	 
     * @param value the PropertyLoader item that needs to be set.	 
     */	 
	public void setValue(String key, String value) {
		prop.setProperty(key, value);
	}	
	
	/**	 
     * This operation reads data from the HashTable and creates a StoreItem .
     * @param index Zero-based index of the item
     * @return
     */
	public  abstract  StoreItem getItem (int index) ;
	
	  /**	 
     * This operation updates the HashTable with data from the  StoreItem.
     * @param index Zero-based index
     * @param item StoreItem to be put in given index
     */
	public  abstract  void setItem(int index, StoreItem cashItem) ;
	
}
