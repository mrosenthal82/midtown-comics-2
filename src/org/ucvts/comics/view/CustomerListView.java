package org.ucvts.comics.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.ucvts.comics.MidtownComics;
import org.ucvts.comics.controller.ViewManager;

@SuppressWarnings("serial")
public class CustomerListView extends JPanel implements ActionListener {
	
	 private ViewManager manager;
	 private JScrollPane scroll;
	 private JButton inventoryView;
	 
	 /**
	 * Creates an instance of the CustomerListView class.
	 * 
	 * @param manager the controller
	 */
	    
	 public CustomerListView(ViewManager manager) {
		 super(new BorderLayout());
	        
	     this.manager = manager;
	     this.init();
	 }
	 
	 /**
	 * Refreshes the customer list.
	 */
	    
	 public void refreshCustomerList() {
		 this.remove(scroll);
	        
	     initCustomerList();
	  }	 
	 
	 /*
	 * Initializes all UI components.
	 */
	    
	 private void init() {        
		initHeader();
        initCustomerList();
        initFooter();
	 }	 
	 
    /*
     * Initializes the header UI components.
     */
    
    private void initHeader() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JLabel label = new JLabel("Midtown Comics");
        label.setFont(new Font("DialogInput", Font.BOLD, 21));
        label.setBorder(new EmptyBorder(15, 15, 10, 0));
	                
        panel.add(label, BorderLayout.WEST);
        this.add(panel, BorderLayout.NORTH);
    }	 
    
    /*
     * Initializes the customer list UI components.
     */
    
//    Update here and in ViewManager --> make CustomerView, make CustomerForm, add more methods to ViewManager
    private void initCustomerList() {
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        for (int i = 0; i < manager.getCustomerList().size(); i++) {            
            body.add(new CustomerPanel(manager, manager.getCustomerList().get(i)));
        }
        
        scroll = new JScrollPane(body);
        this.add(scroll, BorderLayout.CENTER);
    }
    
    /*
     * Initializes the footer UI components.
     */
    
    private void initFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 15, 15, 15));
        
        inventoryView = new JButton("Inventory");
        inventoryView.putClientProperty("id", -1L);
        inventoryView.addActionListener(this);
        
        panel.add(inventoryView, BorderLayout.WEST);
        this.add(panel, BorderLayout.SOUTH);
    }
	
	/*
     * Handles button clicks in this view.
     *
     * @param e the event that triggered this action
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        
        if (source.equals(inventoryView)) {
            manager.switchTo(MidtownComics.InventoryView);
        } 
    }
}