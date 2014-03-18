import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class PurchaseDialog extends JDialog {
	
	PurchasePanel pPanel;
	
	ArrayList<StadiumPanel.RCJButton> buttons;
	int theMode;
	
	public PurchaseDialog(Frame owner, String title, boolean modal, ArrayList<StadiumPanel.RCJButton> btns, int mode, String cost) {
		super(owner, title, modal);
		buttons = btns;
		theMode = mode;
		
		setLayout(null);
		setSize(425, 530);
		setResizable(false);

		pPanel = new PurchasePanel(cost);
		pPanel.setSize(420, 450);
		pPanel.setLocation(0, 0);
		add(pPanel);
		
		
		JButton cancel = new JButton("CANCEL");
		cancel.setSize(100, 30);
		cancel.setLocation(getWidth()-cancel.getWidth()-10, pPanel.getHeight()+10);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				onCancelClicked();
			}
		});
		add(cancel);
		
		JButton accept = new JButton("ACCEPT");
		accept.setSize(100, 30);
		accept.setLocation(getWidth()-accept.getWidth()-cancel.getWidth()-20, pPanel.getHeight()+10);
		accept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onAcceptClicked();
			}
		});
		add(accept);
		
		
		setLocationRelativeTo(owner);
	}
	
	private void onAcceptClicked() {
		String[][] info = {
						{"Name: ", "Address: ", "City: ", "Province: ", "Postal Code:",
							"Credit Card Type: ", "Expiry Date: ", "Credit Card Number: "},
						{pPanel.getNameTextField().getText(), pPanel.getAddressTextField().getText(),
						pPanel.getCityTextField().getText(), pPanel.getProvinceTextField().getText(),
						pPanel.getPostalCodeTextField().getText(), pPanel.getCreditCardType(),
						pPanel.getExpiryDateTextField().getText(), pPanel.getCreditCardTextField().getText()}
							};
		
		((DialogClientInterface)getOwner()).dialogFinished(buttons, theMode, info);
		dispose();
	}
	
	private void onCancelClicked() {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your purchase?", "Cancelation Confirmation", JOptionPane.YES_NO_OPTION);
		if (result == 0) {
			((DialogClientInterface)getOwner()).dialogCancelled();
			dispose();
		}
	}
}