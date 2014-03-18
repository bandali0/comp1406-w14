import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class StadiumApp extends JFrame implements MouseListener, DialogClientInterface, ActionListener {

    InfoPanel infoPanel;
    PricePanel pricePanel;

    Stadium stadium;
    StadiumPanel stadiumPanel;

    private int mode = 0; // 0=Game 1, 1=Game 2, 2=Game 3, 3=Game 4, 4=All Games

    JButton purchase;
    
//    an ArrayList holding the currently selected (gray) buttons (seats)
    public ArrayList<StadiumPanel.RCJButton> selectedButtons = new ArrayList<StadiumPanel.RCJButton>(); 

    public StadiumApp(String name) {
        super(name);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().setLayout(layout);

        stadium = new Stadium();
        stadiumPanel = new StadiumPanel(stadium, this);

        infoPanel = new InfoPanel("SEAT INFORMATION");
        pricePanel = new PricePanel("SELECTED SEAT PRICING");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 4;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(1, 1, 1, 3);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 0;
        constraints.weighty = 1;
        layout.setConstraints(stadiumPanel, constraints);
        getContentPane().add(stadiumPanel);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(3, 3, 3, 1);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.weighty = 0;
        layout.setConstraints(infoPanel, constraints);
        getContentPane().add(infoPanel);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(1, 3, 3, 1);
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.weightx = 1;
        constraints.weighty = 0;
        layout.setConstraints(pricePanel, constraints);
        getContentPane().add(pricePanel);

        purchase = new JButton("Purchase");
        purchase.setMnemonic('P');
        purchase.setEnabled(false);
        purchase.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(1, 3, 3, 3);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weightx = 1;
        constraints.weighty = 0;
        layout.setConstraints(purchase, constraints);
        getContentPane().add(purchase);

        JButton admin = new JButton("Administrator");
        admin.setMnemonic('A');
        admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAdmin();
			}
		});
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(1, 3, 3, 3);
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.weightx = 1;
        constraints.weighty = 0;
        layout.setConstraints(admin, constraints);
        getContentPane().add(admin);

        addGameMenu();

        setSize(860, 494);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StadiumApp("Seat Purchasing System");
    }

    public int getMode() {
        return mode;
    }

    private void addGameMenu() {
        JMenuBar theMenu = new JMenuBar();
        this.setJMenuBar(theMenu);
        JMenu gameMenu = new JMenu("Game");
        theMenu.add(gameMenu);
        GameJRadioButtonMenuItem[] gamesMenus = new GameJRadioButtonMenuItem[4];
        ButtonGroup gamesGroup = new ButtonGroup();
        for (int i=0; i<4; i++) {
            GameJRadioButtonMenuItem item = new GameJRadioButtonMenuItem("Game "+(i+1), i);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GameJRadioButtonMenuItem gamebtn = (GameJRadioButtonMenuItem)e.getSource();
                    updateMode(gamebtn.getGame());
                }
            });
            gamesGroup.add(item);
            gameMenu.add(item);
            gamesMenus[i] = item;
        }
        GameJRadioButtonMenuItem gAll = new GameJRadioButtonMenuItem("All 4 Games", 4);
        gAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameJRadioButtonMenuItem gamebtn = (GameJRadioButtonMenuItem)e.getSource();
                updateMode(gamebtn.getGame());
            }
        });
        gamesGroup.add(gAll);
        gameMenu.add(gAll);
        gamesMenus[mode].setSelected(true);
    }

    private void updateMode(int newMode) {
        mode = newMode;
        updateSeats(true);
    }

    public void updateSeats(boolean updateOthers) {
        if (updateOthers) {
            for(Component btn: stadiumPanel.getComponents())
                if (btn instanceof StadiumPanel.RCJButton) {
                    ((JButton)btn).setSelected(false);
                }
            pricePanel.priceField.setText("");
            pricePanel.hstField.setText("");
            pricePanel.costField.setText("");
            purchase.setEnabled(false);
        }

        for(Component btn: stadiumPanel.getComponents())
            if (btn instanceof StadiumPanel.RCJButton) {
                StadiumPanel.RCJButton button = (StadiumPanel.RCJButton) btn;
                Seat seat = stadium.getSeat(button.getRow(), button.getCol());
                if (mode < 4) {
                    if (seat.isSold(mode)) {
                        button.setBackground(Color.white);
                        button.setEnabled(false);
                    }
                    else
                        if (updateOthers) {
                            button.setBackground(stadiumPanel.seatColors[seat.getSection()-1]);
                            button.setEnabled(true);
                        }
                }
                else {
                    if (seat.isSold(0) || seat.isSold(1) || seat.isSold(2) || seat.isSold(3)) {
                        button.setBackground(Color.white);
                        button.setEnabled(false);
                    }
                    else
                        if (updateOthers) {
                            button.setBackground(stadiumPanel.seatColors[seat.getSection()-1]);
                            button.setEnabled(true);
                        }

                }
            }
    }
    public void updatePricePanel(StadiumPanel.RCJButton btn) {
        Seat seat = stadium.getSeat(btn.getRow(), btn.getCol());
        boolean isPositive = btn.isSelected();

        double totalPrice, hst, totalCost;
        if (pricePanel.priceField.getText().equals(""))
            totalPrice = 0;
        else
            totalPrice = Double.parseDouble(pricePanel.priceField.getText().substring(1));

        if (isPositive)
            if (mode < 4)
                totalPrice += stadium.getSeat(btn.getRow(), btn.getCol()).getPrice();
            else
                totalPrice += stadium.getSeat(btn.getRow(), btn.getCol()).getPrice() * 4 * 0.9;
        else
            if (mode < 4)
                totalPrice -= stadium.getSeat(btn.getRow(), btn.getCol()).getPrice();
            else
                totalPrice -= stadium.getSeat(btn.getRow(), btn.getCol()).getPrice() * 4 * 0.9;

        hst = 0.13*totalPrice;
        totalCost = totalPrice + hst;

        if (totalPrice > 0)
            pricePanel.priceField.setText(niceCurrencyFormat(totalPrice, 2, true));
        else
            pricePanel.priceField.setText("");
        if (hst > 0)
            pricePanel.hstField.setText(niceCurrencyFormat(hst, 2, true));
        else
            pricePanel.hstField.setText("");
        if (totalCost > 0)
            pricePanel.costField.setText(niceCurrencyFormat(totalCost, 2, true));
        else
            pricePanel.costField.setText("");
    }

    public static String niceCurrencyFormat(double amount, int decimalPlaces, boolean includeDollarSign) {
        String str = includeDollarSign ? "$" : "";
        str += String.format("%."+decimalPlaces+"f", amount);
        return str;
    }

    public void mouseEntered(MouseEvent e) {
        StadiumPanel.RCJButton btn = (StadiumPanel.RCJButton) e.getSource();
        Seat seat = stadium.getSeat(btn.getRow(), btn.getCol());

        infoPanel.section.setText(""+seat.getSection());
        infoPanel.row.setText(""+seat.getRow());
        infoPanel.number.setText(""+seat.getNumber());
        infoPanel.price.setText("$"+((mode < 4)?seat.getPrice():seat.getPrice()*4)+".00");
    }
    public void mouseExited(MouseEvent e) {
        for (Component field: infoPanel.getComponents())
            if (field instanceof JTextField)
                ((JTextField)field).setText("");
    }
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}

    class InfoPanel extends JPanel {

        JTextField section, row, number, price;

        public InfoPanel(String name) {
            setBorder(BorderFactory.createTitledBorder(name));

            setLayout(new GridLayout(4,2));

            JLabel label = new JLabel("Section:");
            add(label);
            section = new JTextField();
            section.setHorizontalAlignment(JTextField.CENTER);
            add(section);

            label = new JLabel("Row:");
            add(label);
            row = new JTextField();
            row.setHorizontalAlignment(JTextField.CENTER);
            add(row);

            label = new JLabel("Number:");
            add(label);
            number = new JTextField();
            number.setHorizontalAlignment(JTextField.CENTER);
            add(number);

            label = new JLabel("Price:");
            add(label);
            price = new JTextField();
            price.setHorizontalAlignment(JTextField.CENTER);
            add(price);
        }
    }

    class PricePanel extends JPanel {

        JTextField priceField, hstField, costField;

        public PricePanel(String name) {
            setBorder(BorderFactory.createTitledBorder(name));

            setLayout(new GridLayout(3,2));

            JLabel label = new JLabel("Seat(s) Price:");
            add(label);
            priceField = new JTextField();
            priceField.setHorizontalAlignment(JTextField.RIGHT);
            add(priceField);

            label = new JLabel("HST:");
            add(label);
            hstField = new JTextField();
            hstField.setHorizontalAlignment(JTextField.RIGHT);
            add(hstField);

            label = new JLabel("Total Cost:");
            add(label);
            costField = new JTextField();
            costField.setHorizontalAlignment(JTextField.RIGHT);
            add(costField);
        }
    }

    class GameJRadioButtonMenuItem extends JRadioButtonMenuItem {
        private int game;
        public GameJRadioButtonMenuItem(String caption, int game) {
            super(caption);
            this.game = game;
        }
        public int getGame() {
            return game;
        }
    }

	public void dialogFinished(ArrayList<StadiumPanel.RCJButton> theButtons, int intMode, String[][] information) {
		
		ArrayList<String> seatInfo = new ArrayList<String>();
		
		if (intMode < 4)
			for (StadiumPanel.RCJButton theButton: theButtons) {
				Seat s = stadium.getSeat(theButton.getRow(), theButton.getCol());
				s.setSold(intMode, true);
				String purchase = String.format("\tSection: %d\tRow: %c\tNumber: %d\tPrice: %s", s.getSection(), s.getRow(), s.getNumber(), niceCurrencyFormat(s.getPrice(), 2, true));
				seatInfo.add(purchase);
				theButton.setBackground(Color.white);
		        theButton.setEnabled(false);
			}
		else
			for (StadiumPanel.RCJButton theButton: theButtons) {
				Seat s = stadium.getSeat(theButton.getRow(), theButton.getCol());
				for(int i=0; i<4; i++)
					s.setSold(i, true);
				String purchase = String.format("\tSection: %d\tRow: %c\tNumber: %d\tPrice: %s", s.getSection(), s.getRow(), s.getNumber(), niceCurrencyFormat(s.getPrice()*4, 2, true));
				seatInfo.add(purchase);
				theButton.setBackground(Color.white);
		        theButton.setEnabled(false);
			}
		
		
		
		printPurchaseInfo(information, seatInfo);
		selectedButtons.clear();
		updateSeats(true);
	}
	
	private void printPurchaseInfo(String[][] info, ArrayList<String> seatsBought) {
		System.out.println("Confirmation of Purchase:");
		
//		Print customer's entered information
		for (int i=0; i<info[0].length; i++)
			System.out.println(String.format("%s%s", info[0][i], info[1][i]));
		
//		Print information about the purchased seats
		System.out.println("Seat(s) Description for " + ((mode < 4) ? "Game Number " + (mode+1) : "All Games"));
		for (String strSeat: seatsBought)
			System.out.println(strSeat);
		
//		Print out the price
		System.out.println("Seat(s) Price: " + pricePanel.priceField.getText() +
							"\tHST: " + pricePanel.hstField.getText() +
							"\tTotal: " + pricePanel.costField.getText());
		
	}

	public void dialogCancelled() {
	}
	
	
	private void showAdmin() {
		AdminLoginDialog adminDialog = new AdminLoginDialog(this, this);
		adminDialog.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (!selectedButtons.isEmpty()) {
			PurchaseDialog d = new PurchaseDialog(this, "Purchase Information", false, selectedButtons, mode, pricePanel.costField.getText());
        	d.setVisible(true);
		}
	}

}
