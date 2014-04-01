import javax.swing.*;

public class InfoApp extends JFrame {
	public InfoApp(String name) {
		super(name);

		// Choose to lay out components manually
		getContentPane().setLayout(null);

		setSize(560, 330); // manually computed sizes

		// Now add an AddressPanel
		InfoPanel myPanel = new InfoPanel("PERSONAL INFORMATION");
		myPanel.setLocation(0, 0);
		getContentPane().add(myPanel);

		JButton quit = new JButton("Quit");
		quit.setSize(80, 30);
		quit.setLocation(getWidth() - quit.getWidth() - 12, myPanel.getHeight()
				+ ((getHeight() - myPanel.getHeight()) / 2) - quit.getHeight());
		getContentPane().add(quit);

		JButton submit = new JButton("Submit");
		submit.setSize(80, 30);
		submit.setLocation(
				getWidth() - submit.getWidth() - 12 - quit.getWidth() - 20,
				myPanel.getHeight() + ((getHeight() - myPanel.getHeight()) / 2)
						- submit.getHeight());
		getContentPane().add(submit);

		JButton clear = new JButton("Clear");
		clear.setSize(80, 30);
		clear.setLocation(getWidth() - clear.getWidth() - 12 - quit.getWidth()
				- 20 - submit.getWidth() - 20, myPanel.getHeight()
				+ ((getHeight() - myPanel.getHeight()) / 2) - clear.getHeight());
		getContentPane().add(clear);

		// Set program to stop when window closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		JFrame frame = new InfoApp("Info App");
		frame.setVisible(true);
	}
}
