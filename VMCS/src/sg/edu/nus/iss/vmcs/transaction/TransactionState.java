package sg.edu.nus.iss.vmcs.transaction;

public abstract class TransactionState {

	public abstract void startTransaction(TransactionController controller);

	public abstract void processMoneyReceived(TransactionController controller,
			int coin);

	public void terminateTransaction(TransactionController controller) {

		controller.getDispenseController().allowSelection(false);
		controller.getCoinReceiver().stopReceive();
		if (controller.getCoinReceiver().getTotalInserted() > 0) {

			controller.getCoinReceiver().refundcash();
		}
	}

	public void terminateFault(TransactionController controller) {
		controller.getDispenseController().allowSelection(false);
		if (controller.isDrinkdispensed() && !controller.isChangegiven()) {
			controller.getCoinReceiver().storeCash();
		} else if (!controller.isDrinkdispensed()
				&& controller.getCoinReceiver().getTotalInserted() > 0) {
			controller.getCoinReceiver().refundcash();

		}

	}

	public void cancelTransaction(TransactionController controller) {

		if (!controller.isDrinkdispensed()) {
			controller.getCoinReceiver().stopReceive();
			if (controller.getCoinReceiver().getTotalInserted() > 0) {			

				controller.getCoinReceiver().refundcash();				

			}
			controller.getDispenseController().allowSelection(true);
		}
	}
}
