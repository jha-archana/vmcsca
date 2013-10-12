package sg.edu.nus.iss.vmcs.bridge;
import java.io.IOException;

public interface PropertyLoaderImpl {

		public abstract void initialize() throws IOException ;

		public abstract void saveProperty() throws IOException ;

		public abstract int getNumOfItems();

		public abstract void setNumOfItems(int vl) ;

		/*public abstract StoreItem getItem(int index);

		public abstract void setItem(int index, StoreItem item);*/

		// Utility methods for accessing the hashtable 

		public abstract String getValue(String key) ;

		public abstract void setValue(String key, String value) ;
	
}
