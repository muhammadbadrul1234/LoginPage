import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame{
    public Register() {
		super("Registration");
        
        setSize(500,500);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
        setLayout(null);

        Font labelFont=((new Font("Segoe UI",Font.CENTER_BASELINE,16)));
	    
	
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(93,130,250));
		inputPanel.setBounds(0,0,500,500);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(50,5,100,25);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);
		inputPanel.add(nameLabel);

		JTextField nameText = new JTextField();
		nameText.setBounds(250,5,200,25);
		nameText.setFont(labelFont);
		inputPanel.add(nameText);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(50,35,100,25);
		emailLabel.setFont(labelFont);
		emailLabel.setForeground(Color.WHITE);
		inputPanel.add(emailLabel);
		
		JTextField emailTextField = new JTextField();
		emailTextField.setBounds(250,35,200,25);
		emailTextField.setFont(labelFont);
		inputPanel.add(emailTextField);
		
		JLabel passwordLabel = new JLabel("Password ");
		passwordLabel.setBounds(50,65,100,25);
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Color.WHITE);
		inputPanel.add(passwordLabel);
		
		JTextField passwordTextField = new JTextField();
		passwordTextField.setBounds(250,65,200,25);
		passwordTextField.setFont(labelFont);
		
		inputPanel.add(passwordTextField);
		
		JLabel conPassLabel = new JLabel("Confirm Password");
		conPassLabel.setBounds(50,95,170,25);
		conPassLabel.setFont(labelFont);
		conPassLabel.setForeground(Color.WHITE);
		inputPanel.add(conPassLabel);
				
	    JTextField consPassText = new JTextField();
		consPassText.setBounds(250,95,200,25);
		consPassText.setFont(labelFont);
		inputPanel.add(consPassText);
		
		JLabel MobileNum = new JLabel("Mobile");
		MobileNum.setBounds(50,125,100,25);
		MobileNum.setFont(labelFont);
		MobileNum.setForeground(Color.WHITE);
		inputPanel.add(MobileNum);
		
		JTextField mobileText= new JTextField();
		mobileText.setBounds(250,125,200,25);
		mobileText.setFont(labelFont);

		inputPanel.add(mobileText);

		JLabel addressField = new JLabel("Address");
		addressField.setBounds(50,155,100,25);
		addressField.setFont(labelFont);
		addressField.setForeground(Color.WHITE);
		inputPanel.add(addressField);
				
		JTextField addressText= new JTextField();
		addressText.setBounds(250,155,200,25);
		addressText.setFont(labelFont);
		inputPanel.add(addressText);

		JLabel uniID = new JLabel("Rreference");
		uniID.setBounds(50,185,100,25);
		uniID.setFont(labelFont);
		uniID.setForeground(Color.WHITE);
		inputPanel.add(uniID);
				
		JTextField uniIDText= new JTextField();
		uniIDText.setBounds(250,185,200,25);
		uniIDText.setFont(labelFont);
		inputPanel.add(uniIDText);

		JLabel dob = new JLabel("Date of Birth");
		dob.setBounds(50,215,100,25);
		dob.setFont(labelFont);
		dob.setForeground(Color.WHITE);
		inputPanel.add(dob);
				
		JTextField dobText= new JTextField();
		dobText.setBounds(250,215,200,25);
		dobText.setFont(labelFont);
		inputPanel.add(dobText);


		JButton registerButton = new JButton("Register");
		registerButton.setBounds(250,250,100,30);
		registerButton.setBackground(new Color(219,143,160));
		registerButton.setFont(labelFont);
		registerButton.setForeground(Color.white);
		registerButton.setBorder(new LineBorder(new Color(93,130,250)));
		registerButton.setFocusable(false);
		inputPanel.add(registerButton);
		
		JButton loginButton = new JButton("Return to Login Page");
		loginButton.setBounds(290, 540, 300, 25);
		loginButton.setBackground(new Color(93,130,250));
		loginButton.setFont(labelFont);
		loginButton.setForeground(new Color(255,255,255));
		loginButton.setBorder(new LineBorder(new Color(93,130,250)));
		loginButton.setFocusable(false);
		inputPanel.add(loginButton);

		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userName= nameText.getText();
				String email= emailTextField.getText();
				String pass= passwordTextField.getText();
				String conPass= dobText.getText();
				String mobile = mobileText.getText();
				String adress = addressText.getText();
				String uniID = uniIDText.getText();
				//System.out.println(userName);
				if(userName.trim().isEmpty() || email.trim().isEmpty() || pass.trim().isEmpty() || conPass.trim().isEmpty() || mobile.trim().isEmpty() || adress.trim().isEmpty() || uniID.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {

					String insertQuery = "INSERT INTO `registered`"
							+ "(`name`, `password`, `email`, `number`, `address`, `uniID`,`dob`) "
							+ " VALUES ('" + userName + "','" + pass + "','" + email + "','" + mobile + "','" + adress
							+ "','" + uniID + "','" + conPass + "') ";

					Database db = new Database();
					db.insertRegister(insertQuery);
					dispose();

					new Login();
				}

				
			}
			
		});
		
		
		
		setVisible(true);
	}
	

}