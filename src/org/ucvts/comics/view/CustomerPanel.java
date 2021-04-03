package org.ucvts.comics.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.ucvts.comics.MidtownComics;
import org.ucvts.comics.controller.ViewManager;
import org.ucvts.comics.model.Customer;

@SuppressWarnings("serial")
public class CustomerPanel extends JPanel implements ActionListener {
    
    private ViewManager manager;

    /**
     * Creates an instance of the CustomerPanel class.
     * 
     * @param manager the controller
     * @param product the product represented by this panel
     */
    
    public CustomerPanel(ViewManager manager, Customer customer) {
        super(new BorderLayout());
        
        this.manager = manager;
        this.init(customer);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
    }
    
    /*
     * Initializes all UI components.
     */

    private void init(Customer c) {
        JPanel content = getContentPanel(c);
        JPanel actions = getActionPanel(c);
        
        this.add(content, BorderLayout.CENTER);
        this.add(actions, BorderLayout.EAST);
        this.add(new JSeparator(), BorderLayout.SOUTH);
    }
    
    /*
     * Initializes the content panel UI components.
     */
    
    private JPanel getContentPanel(Customer c) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        JLabel name = new JLabel("Name: " + c.getFirstName() + " " + c.getLastName());
        JLabel email = new JLabel("Email: " + c.getEmail());
        
        name.setFont(new Font("DialogInput", Font.BOLD, 18));
        email.setFont(new Font("DialogInput", Font.ITALIC, 12));
        
        panel.add(name);
        panel.add(email);
        
        return panel;
    }
    
    /*
     * Initializes the action panel UI components.
     */
    
    private JPanel getActionPanel(Customer c) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        
        JButton edit = new JButton("Edit");
        edit.putClientProperty("id", c.getCustomerId());
        edit.putClientProperty("type", "EDIT");
        edit.addActionListener(this);

        panel.add(edit);
        
        return panel;
    }
    
    /*
     * Handles button clicks in this view.
     *
     * @param e the event that triggered this action
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        Long id = (Long) source.getClientProperty("id");
        String type = (String) source.getClientProperty("type");
        
        for (Customer c : manager.getCustomerList()) {
            if (id.longValue() == c.getCustomerId() && type.equals("EDIT")) {
                manager.attachCustomer(c);
                manager.switchTo(MidtownComics.CustomerView);
            }
        }
        
    }
}