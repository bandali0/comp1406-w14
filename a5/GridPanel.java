import javax.swing.*;

public class GridPanel extends JPanel {

	public GridPanel() {
		// Choose to lay out components manually
		setLayout(null);

		setSize(553, 554);

		ShinyButtons sB = new ShinyButtons();

		ImageIcon[] icons = {
				new ImageIcon(this.getClass().getResource("RedButton.png")),
				new ImageIcon(this.getClass().getResource("OrangeButton.png")),
				new ImageIcon(this.getClass().getResource("YellowButton.png")),
				new ImageIcon(this.getClass().getResource("GreenButton.png")),
				new ImageIcon(this.getClass().getResource("BlueButton.png")),
				new ImageIcon(this.getClass()
						.getResource("LightGrayButton.png")),
				new ImageIcon(this.getClass().getResource("DarkGrayButton.png")) };

		for (int row = 0; row < ShinyButtons.ROWS; row++)
			for (int col = 0; col < ShinyButtons.ROWS; col++) {

				JButton btn = new JButton(icons[sB.getButton(row, col)]);
				btn.setSize(69, 69);
				btn.setLocation(row * btn.getWidth(), col * btn.getHeight());
				add(btn);
			}

	}
}
