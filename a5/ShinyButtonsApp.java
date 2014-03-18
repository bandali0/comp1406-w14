import java.awt.ComponentOrientation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShinyButtonsApp extends JFrame {
	public ShinyButtonsApp(String name) {
		super(name);

		// Choose to lay out components manually
		getContentPane().setLayout(null);

		setSize(578, 634); // manually computed sizes

		// Now add an AddressPanel
		GridPanel myPanel = new GridPanel();
		myPanel.setLocation(10, 10);
		getContentPane().add(myPanel);

		JButton quit = new JButton("Quit");
		quit.setSize(90, 30);
		quit.setLocation(getWidth() - quit.getWidth() - 15, myPanel.getHeight()
				+ ((getHeight() - myPanel.getHeight()) / 2) - quit.getHeight()
				+ 5);
		getContentPane().add(quit);

		JButton newGame = new JButton("New Game");
		newGame.setSize(110, 30);
		newGame.setLocation(
				getWidth() - newGame.getWidth() - 15 - quit.getWidth() - 20,
				myPanel.getHeight() + ((getHeight() - myPanel.getHeight()) / 2)
						- newGame.getHeight() + 5);
		getContentPane().add(newGame);

		JLabel aLabel = new JLabel("Score:");
		aLabel.setLocation(10,
				myPanel.getHeight() + ((getHeight() - myPanel.getHeight()) / 2)
						- newGame.getHeight() + 5);
		aLabel.setSize(60, 30);
		getContentPane().add(aLabel);

		JTextField score = new JTextField("0");
		score.setLocation(70,
				myPanel.getHeight() + ((getHeight() - myPanel.getHeight()) / 2)
						- newGame.getHeight() + 5);
		score.setSize(130, 30);
		score.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		getContentPane().add(score);

		// Set program to stop when window closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		JFrame frame = new ShinyButtonsApp("Shiny Buttons");
		frame.setVisible(true);
	}
}
