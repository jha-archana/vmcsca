package sg.edu.nus.iss.vmcs.store;
import java.io.IOException;

public interface PropertyLoaderImpl {

		public void initialize() throws IOException ;

		public void saveProperty() throws IOException ;

		public int getNumOfItems();

		public void setNumOfItems(int vl) ;

		/*public abstract StoreItem getItem(int index);

		public abstract void setItem(int index, StoreItem item);*/

		// Utility methods for accessing the hashtable 

		public String getValue(String key) ;

		public void setValue(String key, String value) ;
	
}
