package sg.edu.nus.iss.vmcs.store;
import java.io.IOException;
import java.util.Properties;

	/** 
	 * This interface provides the generic functionality required to initialize 
	 * the stores.  
	 * @author Divya
	 */
	 
	public interface PropertyLoaderImpl {	        
	 
	     /**	 
	      * This operation reads the properties file into a hash table. 	 
	      * @throws java.io.IOException	 
	      */	 
	      public Properties initialize() throws IOException;	        
	        	 
	      /**	 
	      * This operation writes the properties from the hash table to the file.	 
	      * @throws java.io.IOException	 
	      */	 
	      public void saveProperty(Properties prop) throws IOException; 
	       
	}
	 

