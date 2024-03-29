package sg.edu.nus.iss.vmcs.store;

import sg.edu.nus.iss.vmcs.iterator.StoreItemIteratorIFace;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

/**
 *
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */

public class CashStore extends Store {

	public final static int INVALID_COIN_WEIGHT = 9999;

	public CashStore() {
	}
	
	public int findCashStoreIndex (Coin c) {
		int size = getStoreSize();
		for (int i = 0; i < size; i++) {
			StoreItem item = (CashStoreItem) getStoreItem(i);
			Coin current = (Coin) item.getContent();
			if (current.getWeight() == c.getWeight())
				return i;
		}
		return -1;
	}
	public Coin findCoin(double weight)
	{
		
		StoreItemIteratorIFace storeItemIterator = getStoreItemIterator();
		while (!storeItemIterator.isDone()) {
			Coin coin = (Coin) storeItemIterator.currentItem().getContent();
			 System.out.println("coin.getWeight()"+coin.getWeight());
             if (coin.getWeight() == weight)
                     return coin;
			storeItemIterator.next();
		}
        return null;
	}

}

