import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class Database {
    private Connection con;
	private Statement st;
	private ResultSet rs;
	private int flag = 0;
	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			st = con.createStatement();
			//System.out.println("Connected to DB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	public void Login(String queryLogin, String userName, String pass) {
		try {
			rs = st.executeQuery(queryLogin);
			while(rs.next()) {
				String tableUserName = rs.getString(7);
				String tablePass = rs.getString(3);
				if(userName.equals(tableUserName) && pass.equals(tablePass)) {
					flag =1;
					break;
				}
			}
			if (flag == 0) {
				JOptionPane.showMessageDialog(null, "Invalid paswword or username!!");
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Login Successful!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void insertRegister(String insertQuesry) {
		try {
			st.executeUpdate(insertQuesry);
			JOptionPane.showMessageDialog(null, "You have successfully registered!");
		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Registration Not Completed");
		}

	}

	public void Login1(String queryLogin, String userName, String pass) {
		try {

			rs = st.executeQuery(queryLogin);
			String x;
			while (rs.next()) {
				String tableUserName = rs.getString(7);
				String tablePass = rs.getString(3);

				if (userName.equals(tableUserName) && pass.equals(tablePass)) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				JOptionPane.showMessageDialog(null, "Data Not Found");
			}

			else {
				JOptionPane.showMessageDialog(null, "Password is: aa ");
				//JOptionPane.showMessageDialog (null, x, "Title", JOptionPane.INFORMATION_MESSAGE);
			}
			//System.out.println(x);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void admissionRegister(String insertQuesry) {
		try {
			st.executeUpdate(insertQuesry);
			JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Admission Not Completed. Internal error");
		}

	}

    
}
