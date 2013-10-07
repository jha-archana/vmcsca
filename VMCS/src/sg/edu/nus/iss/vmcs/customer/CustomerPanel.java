package sg.edu.nus.iss.vmcs.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import sg.edu.nus.iss.vmcs.transaction.TransactionController;

public class CustomerPanel extends Dialog {

    private static final String TITLE = "Customer Panel";
    public static final char DIALOG = 'a';
    
    public final static Color ACT_COLOR = Color.white;
    private DrinkSelectionBox drinkSelectionBox;
    private TransactionController transactionController;
    private static final String HEADING = "VMCS Soft Drink Dispenser";
  

    public CustomerPanel(Frame fr,TransactionController transactController) {
            super(fr,TITLE);
            this.transactionController = transactController;

            Label titleLabel = new Label(TITLE);
            titleLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
            Panel northPanel = new Panel();
            northPanel.setLayout(new GridLayout(0, 1));

            Label heading = new Label(HEADING);
            heading.setFont(new Font("Helvetica", Font.BOLD, 24));
            northPanel.add(heading);
//          Panel tp1 = new Panel();
//          tp1.add(lb);

            /*Label lb = new Label("VIMTO Soft Drink Dispenser");
            lb.setFont(new Font("Helvetica", Font.BOLD, 24));
            lb.setAlignment(Label.CENTER);*/

            Panel centerPanel = new Panel();
            centerPanel.setLayout(new GridLayout(0, 1));

            // Drink selection box
            drinkSelectionBox = new DrinkSelectionBox(northPanel, transactionController);
            centerPanel.add(drinkSelectionBox);
            
                 

            // layout setup
            this.setLayout(new BorderLayout());
           

            pack();
            setLocation(200, 100);

            addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                            //transactionController.closePanel();
                    }
            });

    }
    public DrinkSelectionBox getDrinkSelectionBox() {
        return drinkSelectionBox;
}

    public void display() {
            this.setVisible(true);
    }
}

