/*
 * IMPORTANT: MOST of the misbehaviors come from the processTable() method in the ShinyButtons class.
 * I haven't been able to debug it. But other than that, other functionalities should be fine.
 */

import java.awt.ComponentOrientation;
import java.awt.event.*;

import javax.swing.*;

public class ShinyButtonsApp extends JFrame implements ActionListener {

	GridPanel myPanel;
	JTextField score;
	JCustomButton selectedButton = null;
	private Timer timer;

	public ShinyButtonsApp(String name) {
		super(name);

		// Choose to lay out components manually
		getContentPane().setLayout(null);

		setSize(578, 634); // manually computed sizes

		// Now add an AddressPanel
		myPanel = new GridPanel();
		myPanel.setLocation(10, 10);
		myPanel.setButtonsListener(this);
		getContentPane().add(myPanel);

		JButton quit = new JButton("Quit");
		quit.setSize(90, 30);
		quit.setLocation(getWidth() - quit.getWidth() - 15, myPanel.getHeight()
				+ ((getHeight() - myPanel.getHeight()) / 2) - quit.getHeight()
				+ 5);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(quit);

		JButton newGame = new JButton("New Game");
		newGame.setSize(110, 30);
		newGame.setLocation(
				getWidth() - newGame.getWidth() - 15 - quit.getWidth() - 20,
				myPanel.getHeight() + ((getHeight() - myPanel.getHeight()) / 2)
						- newGame.getHeight() + 5);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		getContentPane().add(newGame);

		JLabel aLabel = new JLabel("Score:");
		aLabel.setLocation(10,
				myPanel.getHeight() + ((getHeight() - myPanel.getHeight()) / 2)
						- newGame.getHeight() + 5);
		aLabel.setSize(60, 30);
		getContentPane().add(aLabel);

		score = new JTextField("0");
		score.setLocation(70,
				myPanel.getHeight() + ((getHeight() - myPanel.getHeight()) / 2)
						- newGame.getHeight() + 5);
		score.setSize(130, 30);
		score.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		getContentPane().add(score);

		timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel.sB.cleanTable();
				myPanel.update();
			}
		});
		timer.start(); // This line starts the timer which will happen every 0.5
						// seconds

		// Set program to stop when window closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		JFrame frame = new ShinyButtonsApp("Shiny Buttons");
		frame.setVisible(true);
	}

	private void newGame() {
		myPanel.resetGame();
		score.setText("" + myPanel.sB.getScore());
	}

	private void gameHandler(JCustomButton btn) {
		btn.setSelected(true);
		if (selectedButton == null)
			selectedButton = btn;
		else {
			if (isBesideSelected(btn)) {
				swapSelectedWith(btn);
				selectedButton = null;
			} else {
				selectedButton.setSelected(false);
				selectedButton = btn;
			}
		}
	}

	private boolean isBesideSelected(JCustomButton button) {
		int iDiff = button.getI() - selectedButton.getI();
		int jDiff = button.getJ() - selectedButton.getJ();
		return (Math.abs(iDiff) <= 1 && Math.abs(jDiff) <= 1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JCustomButton)
			gameHandler((JCustomButton) e.getSource());
	}

	private void swapSelectedWith(JCustomButton btn) {
		myPanel.swap(selectedButton, btn);
		selectedButton.setSelected(false);
		btn.setSelected(false);
	}
}
