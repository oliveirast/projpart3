package libraryGUI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import sqlFunctions.SQLFunctionsBorrower;


public class HoldRequest extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField borID;
	private JTextField callNumber;
	private JButton holdBtn;
	private JFrame frame;

	public HoldRequest() {
		this.setPreferredSize(new Dimension(450, 150));

		JLabel userLabel = new JLabel("Borrower ID:");
		userLabel.setPreferredSize(new Dimension(150, 20));
		this.add(userLabel);
		borID = new JTextField(20);
		this.add(borID);

		JLabel callNumLabel = new JLabel("Book Call Number:");
		callNumLabel.setPreferredSize(new Dimension(150, 20));
		this.add(callNumLabel);
		callNumber = new JTextField(20);
		this.add(callNumber);

		holdBtn = new JButton("Hold");
		this.add(holdBtn);
		holdBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				holdrequest();
			}

		});
	}

	private void holdrequest() {

		int bid;

		try {
			bid = Integer.parseInt(borID.getText());
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(frame, "Borrower ID should be an Integer." );
			return;
		}
		
		//System.out.println("In Hold Request");
		ResultSet rs = SQLFunctionsBorrower.bookExists(callNumber.getText());
		try {
			if (rs.next()){
				System.out.println("Call Number found.");
				int hid = SQLFunctionsBorrower.holdRequest(bid, callNumber.getText());
				System.out.println(hid);
				JOptionPane.showMessageDialog(frame, "New Hold Request Made. Email has been sent. "
						+ "Clerk has been notified." );
			} else {
				JOptionPane.showMessageDialog(frame, "Hold Request cannot be made. Call number does "
						+ "not exists.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
