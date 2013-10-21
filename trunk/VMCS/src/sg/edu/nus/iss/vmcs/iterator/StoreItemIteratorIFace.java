package sg.edu.nus.iss.vmcs.iterator;

import sg.edu.nus.iss.vmcs.store.StoreItem;

public interface StoreItemIteratorIFace {
	public void first();

	public void next();

	public boolean isDone();

	public StoreItem currentItem();
}
