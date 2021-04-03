package org.ucvts.comics.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.ucvts.comics.model.Customer;

@SuppressWarnings("serial")
public class CustomerForm extends JPanel {
    
    private JTextField customerIdField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField streetAddressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField postalCodeField;
    private JLabel errorLabel;
    private JScrollPane scroll;
    
    /**
     * Creates a default instance of the CustomerForm class.
     */
    
    public CustomerForm() {
        this(null);
    }
    
    /**
     * Creates an instance of the CustomerForm class.
     * 
     * @param product the source customer
     */
    
    public CustomerForm(Customer customer) {
        this.init(customer);
    }
    
    /**
     * Updates fields with actual customer data.
     * 
     * @param customer the customer with which to update the fields
     */
    
    public void updateFields(Customer customer) {
        if (customer == null) {
            clearFields();
            
            return;
        }
        
        customerIdField.setText(String.valueOf(customer.getCustomerId()));
        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        phoneField.setText(String.valueOf(customer.getPhone()));
        emailField.setText(customer.getEmail());
        streetAddressField.setText(customer.getStreetAddress());
        cityField.setText(customer.getCity());
        stateField.setText(customer.getState());
        postalCodeField.setText(customer.getPostalCode());

    }
    
    /**
     * Returns a customer built from the form fields.
     * 
     * @return a customer
     */
    
    public Customer getCustomerFromFields() {
        if (customerIdField.getText().trim().isEmpty()) {
            return new Customer(
            	Long.parseLong(customerIdField.getText()),
            	firstNameField.getText(),
            	lastNameField.getText(),
            	Long.parseLong(phoneField.getText()),
            	emailField.getText(),
            	streetAddressField.getText(),
            	cityField.getText(),
            	stateField.getText(),
            	postalCodeField.getText()
            );
        } else {
            return new Customer(
            	Long.parseLong(customerIdField.getText()),
               	firstNameField.getText(),
               	lastNameField.getText(),
               	Long.parseLong(phoneField.getText()),
               	emailField.getText(),
               	streetAddressField.getText(),
               	cityField.getText(),
               	stateField.getText(),
               	postalCodeField.getText()
            );
        }
    }
    
    /**
     * Updates the form error message.
     * 
     * @param message the new message
     */
    
    public void updateErrorMessage(String message) {
        errorLabel.setText(message);
    }
    
    /*
     * Initializes all UI components.
     */
    
    private void init(Customer customer) {
//        this.setLayout(null);
        
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        initCustomerId(customer);
       	initFirstName(customer);
       	initLastName(customer);
       	initPhone(customer);
       	initEmail(customer);
       	initStreetAddress(customer);
       	initCity(customer);
       	initState(customer);
       	initPostalCode(customer);
       	initErrorMessage();
       	
       	scroll = new JScrollPane(body);
        this.add(scroll, BorderLayout.CENTER);
    }
    
    /*
     * Initializes the customer ID UI field.
     */
    
    private void initCustomerId(Customer customer) {
        JLabel label = new JLabel("Customer ID");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 15, 100, 40);
        label.setLabelFor(customerIdField);
        
        customerIdField = new JTextField(10);
        customerIdField.setBounds(20, 45, 710, 40);;
        customerIdField.setEditable(false);
        
        this.add(label);
        this.add(customerIdField);
    }
    
    /*
     * Initializes the first name UI field.
     */
    
    private void initFirstName(Customer customer) {
        JLabel label = new JLabel("First Name");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 85, 100, 40);
        label.setLabelFor(firstNameField);
        
        firstNameField = new JTextField(10);
        firstNameField.setBounds(20, 115, 710, 40);
        
        this.add(label);
        this.add(firstNameField);
    }
    
    /*
     * Initializes the last name UI field.
     */
    
    private void initLastName(Customer customer) {
        JLabel label = new JLabel("Last Name");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 155, 100, 40);
        label.setLabelFor(lastNameField);
        
        lastNameField = new JTextField(10);
        lastNameField.setBounds(20, 185, 710, 40);
        
        this.add(label);
        this.add(lastNameField);
    }
    
    /*
     * Initializes the phone UI field.
     */
    
    private void initPhone(Customer customer) {
        JLabel label = new JLabel("Phone No.");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 225, 100, 40);
        label.setLabelFor(phoneField);
        
        phoneField = new JTextField(10);
        phoneField.setBounds(20, 255, 710, 40);
        
        this.add(label);
        this.add(phoneField);
    }
    
    /*
     * Initializes the email UI field.
     */
    
    private void initEmail(Customer customer) {
        JLabel label = new JLabel("Email");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 295, 100, 40);
        label.setLabelFor(emailField);
        
        emailField = new JTextField(10);
        emailField.setBounds(20, 325, 710, 40);
        
        this.add(label);
        this.add(emailField);
    }
    
    /*
     * Initializes the street address UI field.
     */
    
    private void initStreetAddress(Customer customer) {
        JLabel label = new JLabel("Street Address");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 365, 100, 40);
        label.setLabelFor(streetAddressField);
        
        streetAddressField = new JTextField(10);
        streetAddressField.setBounds(20, 395, 710, 40);
        
        this.add(label);
        this.add(streetAddressField);
    }
    
    /*
     * Initializes the city UI field.
     */
    
    private void initCity(Customer customer) {
        JLabel label = new JLabel("City");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 435, 100, 40);
        label.setLabelFor(cityField);
        
        cityField = new JTextField(10);
        cityField.setBounds(20, 465, 710, 40);
        
        this.add(label);
        this.add(cityField);
    }
    
    /*
     * Initializes the state UI field.
     */
    
    private void initState(Customer customer) {
        JLabel label = new JLabel("State");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 505, 100, 40);
        label.setLabelFor(stateField);
        
        stateField = new JTextField(10);
        stateField.setBounds(20, 535, 710, 40);
        
        this.add(label);
        this.add(stateField);
    }
    
    /*
     * Initializes the postal code UI field.
     */
    
    private void initPostalCode(Customer customer) {
        JLabel label = new JLabel("Postal Code");
        label.setFont(new Font("DialogInput", Font.BOLD, 14));
        label.setBounds(25, 575, 100, 40);
        label.setLabelFor(postalCodeField);
        
        postalCodeField = new JTextField(10);
        postalCodeField.setBounds(20, 605, 710, 40);
        
        this.add(label);
        this.add(postalCodeField);
    }
    
    /*
     * Initializes the error message UI field.
     */
    
    private void initErrorMessage() {
        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(20, 640, 710, 40);
        
        this.add(errorLabel);
    }
    
    /*
     * Resets all UI fields to their default values.
     */
    
    private void clearFields() {
    	customerIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        streetAddressField.setText("");
        cityField.setText("");
        stateField.setText("");
        postalCodeField.setText("");
    }
    
}