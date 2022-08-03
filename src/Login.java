import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login() {
        super("Login Page");
        setSize(500,500);
        setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
        
        Font labelFont = ((new Font("Segoe UI", Font.CENTER_BASELINE, 16)));
        Font labelFont2 = ((new Font("Segoe UI", Font.CENTER_BASELINE, 10)));
        
        

	    JPanel inputpanel=new JPanel();
		inputpanel.setBackground(new Color(25,79,87));
	    inputpanel.setBounds(0,0,640,750);
	    inputpanel.setLayout(null);
		add(inputpanel);

        JLabel namelabel=new JLabel("User Name");
	    namelabel.setBounds(75,50,100,25);
		namelabel.setFont(labelFont);
		namelabel.setForeground(Color.WHITE);
		inputpanel.add(namelabel);

	    
	    JTextField nameTxt=new JTextField();
	    nameTxt.setBounds(200,50,200,25);
	    nameTxt.setFont(labelFont);
		inputpanel.add(nameTxt);
	    
	    JLabel passlabel=new JLabel("Password ");
	    passlabel.setBounds(75,120,100,25);
		passlabel.setFont(labelFont);
		passlabel.setForeground(Color.WHITE);
		inputpanel.add(passlabel);
	    
	    JTextField passTxt=new JTextField();
	    passTxt.setBounds(200,120,200,25);
	    passTxt.setFont(labelFont);
		inputpanel.add(passTxt);
	    
	    JButton loginBtn=new JButton("Login");
	    loginBtn.setBounds(300,170,100,30);
	    loginBtn.setBackground(new Color(93,161,217));
	    loginBtn.setFont(labelFont);
	    loginBtn.setForeground(Color.WHITE);
	    loginBtn.setBorder(new LineBorder(new Color(93,130,250)));
	    loginBtn.setFocusable(false);
		inputpanel.add(loginBtn);

		JButton registerLink = new JButton("Don't have an account?");
		registerLink.setBounds(230, 220, 250, 30);
        registerLink.setForeground(Color.WHITE);
	    registerLink.setBackground(new Color(25,79,87));
	   	registerLink.setFont(labelFont2);
	    registerLink.setForeground(Color.WHITE);
	    registerLink.setBorder(new LineBorder(new Color(25,79,87)));
	    registerLink.setFocusable(false);
		inputpanel.add(registerLink);

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = nameTxt.getText();
	            String pass = passTxt.getText();
	            Database db = new Database();
				//String queryLogin = "SELECT * FROM `registered`";
				Database db1 = new Database();
	            String queryLogin = "SELECT * FROM `registered`";
				db1.Login(queryLogin, userName, pass);
				//dispose();
				//new Homepage();
			}
		});
		registerLink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Register();
			}
		});
		
		setVisible(true);
    }
    
}