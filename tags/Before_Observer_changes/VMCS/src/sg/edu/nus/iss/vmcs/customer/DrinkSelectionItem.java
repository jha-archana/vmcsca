package sg.edu.nus.iss.vmcs.customer;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.store.DrinksStoreItem;
import sg.edu.nus.iss.vmcs.store.StoreItem;

public class DrinkSelectionItem {

        
        private final static int                PRICELEN = 5;
        private final static int                STOCKSTATELEN = 10;
        
        private Button                          button;
        private TextField                       price;
        private TextField                       stock_state;
        private DrinksStoreItem         drinkItem; 
        private int                                     index;
        

        public DrinkSelectionItem (Panel container, StoreItem item, int idx) {
                drinkItem = (DrinksStoreItem) item;
                index = idx;
                
                button = new Button (drinkItem.getContent().getName());
                button.setEnabled(false);
                container.add(button);
                
                Panel pricePanel = new Panel();
                pricePanel.setLayout(new FlowLayout());
                price = new TextField("", PRICELEN);
                price.setBackground(Color.black);
                price.setForeground(Color.white);
                price.setEditable(false);
                //container.add(price);
                pricePanel.add(price);
                container.add(pricePanel);
                
                Panel stock_statePanel = new Panel();
                stock_statePanel.setLayout(new FlowLayout());
                stock_state = new TextField("  Not In Stock  ", STOCKSTATELEN);
                stock_state.setBackground(Color.black);
                stock_state.setForeground(Color.black);
                stock_state.setEditable(false);
                stock_statePanel.add(stock_state);
                container.add(stock_statePanel);
        }
        
        public void addListener (ActionListener listener) {
                button.addActionListener(listener);
                button.setActionCommand(String.valueOf(index));
        }
        
        public void setItemState (boolean active) {
                if (    drinkItem.getQuantity() < 1) {
                        button.setEnabled(false); //no more cans
                        stock_state.setForeground(Color.white);
                }
                else { //have cans
                        button.setEnabled(active);
                        stock_state.setForeground(Color.black);
                }
        }
        
        public void setPrice (int price) {
                int spaceLEN = ( PRICELEN - (String.valueOf(price).length() + 2) ) / 2;
                String space = new String();
                for (int i = 0; i < spaceLEN; i++) {
                        space = space + " ";
                }
                this.price.setText(space + String.valueOf(price) + " c");
        }
        
        public void setName (String name) {
                button.setLabel(name);
        }
}
