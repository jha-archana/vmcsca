package sg.edu.nus.iss.vmcs.system;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

import java.util.*;
import java.io.*;

import sg.edu.nus.iss.vmcs.store.*;

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

public class FilePropertyLoader implements PropertyLoaderImpl {

	//private static final String PROP_NUM_ITEMS = "NumOfItems";
	private Properties prop;	
	private String fileName;	

	/**	 
     * This constructor creates an instance of FilePropertyLoader.     
     * @param fileName     
     */
	public FilePropertyLoader(String fileName) {
		this.fileName = fileName;
	}

	/**	 
     * This operation reads the properties file into a hash table.
     */
	public Properties initialize() throws IOException {
		prop = new Properties(System.getProperties());
		FileInputStream stream = new FileInputStream(fileName);
		prop.load(stream);
		stream.close();
		
		return prop;
	}
	
	/**	 
     * This operation writes the properties from the hash table to the file.      
     * @throws IOException- File Input/Output Exception
     */
	public void saveProperty(Properties prop) throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		prop.store(stream, "");
		stream.close();
	}	

}