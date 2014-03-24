import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class HoldRequest extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField borID;
	private JTextField callNumber;
	private JButton holdBtn;
	
	public HoldRequest() {
		this.setPreferredSize(new Dimension(450, 150));
		
		JLabel userLabel = new JLabel("User ID:");
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
				//holdrequest();
			}
		
		});
		
	}
	
}
