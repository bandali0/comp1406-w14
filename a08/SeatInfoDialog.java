import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SeatInfoDialog extends JDialog {
	private JButton 		okButton;
	private JTextField 		userTextField;
	private JPasswordField  passwordField;

	public SeatInfoDialog(Stadium stadium){
		super((JDialog)null,"Administrator Sales Report",true);

		// Add the components
        	setLayout(new GridLayout(8,3));

   		JLabel aLabel = new JLabel("GAME");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("SEATS SOLD");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("SALES");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

		int totalSeatsSold = 0, totalSales = 0;
		
		for (int i=0; i<4; i++) {
			JLabel l = new JLabel("" + (i+1));
			l.setHorizontalAlignment(JLabel.CENTER);
			add(l);
			int seatsSold = 0, sales = 0;
			for(Seat[] seatArr: stadium.getSeats())
				for(Seat seat: seatArr)
					if(seat != null && seat.isSold(i)) {
						sales += seat.getPrice() * 1.13;
						seatsSold++;
					}
			totalSeatsSold += seatsSold;
			totalSales += sales;
			
			l = new JLabel(""+seatsSold); 
			l.setHorizontalAlignment(JLabel.CENTER);
			add(l);
			l = new JLabel(""+StadiumApp.niceCurrencyFormat(sales, 2, true));
			l.setHorizontalAlignment(JLabel.CENTER);
			add(l);
		}
		

		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

		aLabel = new JLabel("TOTAL");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel(""+totalSeatsSold);
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel(""+totalSales);
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

        	aLabel = new JLabel("");	// Leave a blank
		add(aLabel);
		aLabel = new JLabel("");	// Leave a blank
		add(aLabel);
        	add(okButton = new JButton("OK"));
        okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// Prevent the window from being resized
		setSize(300, 240);
		setResizable(false);
	}
}
