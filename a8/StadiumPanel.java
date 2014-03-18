import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StadiumPanel extends BoardPanel {

    Color[] seatColors = new Color[] {Color.red, Color.green, Color.blue, Color.yellow};
    Stadium stadium;
    StadiumApp app;

    public StadiumPanel(Stadium stadium, StadiumApp listener) {
        final Stadium finalStadium = stadium;
        this.stadium = stadium;
        app = listener;

        setLayout(new GridLayout(Stadium.ROWS, Stadium.COLUMNS));

        for (int row=0; row<Stadium.ROWS; row++)
            for (int col=0; col<Stadium.COLUMNS; col++) {
                JComponent s;
                Seat seat = stadium.getSeat(row, col);
                if (seat == null)
                    s = new JLabel();
                else {
                    s = new RCJButton(row, col);
                    s.setBackground(seatColors[seat.getSection()-1]);
                    s.addMouseListener(listener);
                    ((JButton)s).addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            RCJButton btn = (RCJButton)e.getSource();
                            boolean selectionState = btn.isSelected();
                            finalStadium.getSeat(btn.getRow(), btn.getCol()).setSelected(!selectionState);
                            btn.setSelected(!selectionState);
                            app.updateSeats(false);
                            update();
                            app.updatePricePanel(btn);
                            if (!selectionState)
                            	app.selectedButtons.add(btn);
                            else
                            	if (app.selectedButtons.contains(btn))
                            		app.selectedButtons.remove(btn);
                            
                            boolean atLeastOneSelected = !app.selectedButtons.isEmpty();
                            app.purchase.setEnabled(atLeastOneSelected);
                        }
                    });
                }
                add(s);
            }

        setBackground(Color.white);
    }

    public void update() {
        for (Component btn: getComponents())
            if (btn instanceof RCJButton)
                if(((JButton)btn).isSelected()) {
                    if (app.getMode() < 4) {
                        if (!stadium.getSeat(((RCJButton)btn).getRow(), ((RCJButton)btn).getCol()).isSold(app.getMode()))
                            btn.setBackground(Color.gray);
                    }
                    else {
                        Seat s = stadium.getSeat(((RCJButton)btn).getRow(), ((RCJButton)btn).getCol());
                        if (!(s.isSold(0) || s.isSold(1) || s.isSold(2) || s.isSold(3)))
                            btn.setBackground(Color.gray);
                    }
                }
                else {
                    if (app.getMode() < 4) {
                        if (!stadium.getSeat(((RCJButton)btn).getRow(), ((RCJButton)btn).getCol()).isSold(app.getMode())) {
                            btn.setBackground(seatColors[stadium.getSeat(((RCJButton)btn).getRow(), ((RCJButton)btn).getCol()).getSection()-1]);
                            btn.setEnabled(true);
                        }
                    }
                    else {
                        Seat seat = stadium.getSeat(((RCJButton)btn).getRow(), ((RCJButton)btn).getCol());
                        if (!(seat.isSold(0) || seat.isSold(1) || seat.isSold(2) || seat.isSold(3))) {
                            btn.setBackground(seatColors[stadium.getSeat(((RCJButton)btn).getRow(), ((RCJButton)btn).getCol()).getSection()-1]);
                            btn.setEnabled(true);
                        }
                    }

                }

    }

    public class RCJButton extends JButton {

        private int row, col;

        public RCJButton(int r, int c) {
            super();
            row = r;
            col = c;
        }

        public int getRow() {
            return row;
        }
        public int getCol() {
            return col;
        }
    }
}
