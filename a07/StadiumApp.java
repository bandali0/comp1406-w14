import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StadiumApp extends JFrame implements MouseListener {

    InfoPanel infoPanel;
    PricePanel pricePanel;

    Stadium stadium;

    public StadiumApp(String name) {
        super(name);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().setLayout(layout);

        stadium = new Stadium();
        StadiumPanel stadiumPanel = new StadiumPanel(stadium, this);

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

        JButton purchase = new JButton("Purchase");
        purchase.setMnemonic('P');
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


        setSize(860, 494);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StadiumApp("Seat Purchasing System");
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
            totalPrice += stadium.getSeat(btn.getRow(), btn.getCol()).getPrice();
        else
            totalPrice -= stadium.getSeat(btn.getRow(), btn.getCol()).getPrice();

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

    private String niceCurrencyFormat(double amount, int decimalPlaces, boolean includeDollarSign) {
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
        infoPanel.price.setText("$"+seat.getPrice()+".00");
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

}
