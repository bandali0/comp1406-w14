import java.awt.event.ActionListener;
import javax.swing.*;

public class GridPanel extends JPanel {

	JCustomButton[][] buttons;
	ShinyButtons sB;
	ImageIcon[] icons;
	ImageIcon[] selectedIcons;

	public GridPanel() {
		// Choose to lay out components manually
		setLayout(null);

		setSize(553, 554);

		sB = new ShinyButtons();
		buttons = new JCustomButton[ShinyButtons.ROWS][ShinyButtons.ROWS];

		icons = new ImageIcon[] {
				new ImageIcon(this.getClass().getResource("RedButton.png")),
				new ImageIcon(this.getClass().getResource("OrangeButton.png")),
				new ImageIcon(this.getClass().getResource("YellowButton.png")),
				new ImageIcon(this.getClass().getResource("GreenButton.png")),
				new ImageIcon(this.getClass().getResource("BlueButton.png")),
				new ImageIcon(this.getClass()
						.getResource("LightGrayButton.png")),
				new ImageIcon(this.getClass().getResource("DarkGrayButton.png")) };

		selectedIcons = new ImageIcon[] {
				new ImageIcon(this.getClass().getResource(
						"SelectedRedButton.png")),
				new ImageIcon(this.getClass().getResource(
						"SelectedOrangeButton.png")),
				new ImageIcon(this.getClass().getResource(
						"SelectedYellowButton.png")),
				new ImageIcon(this.getClass().getResource(
						"SelectedGreenButton.png")),
				new ImageIcon(this.getClass().getResource(
						"SelectedBlueButton.png")),
				new ImageIcon(this.getClass().getResource(
						"SelectedLightGrayButton.png")),
				new ImageIcon(this.getClass().getResource(
						"SelectedDarkGrayButton.png")) };

		for (int row = 0; row < ShinyButtons.ROWS; row++)
			for (int col = 0; col < ShinyButtons.ROWS; col++) {

				JCustomButton btn = new JCustomButton(icons[sB.getButton(row,
						col)]);
				btn.setSelectedIcon(selectedIcons[sB.getButton(row, col)]);
				btn.setSelected(sB.getSelected(row, col));
				btn.setSize(69, 69);
				btn.setLocation(row * btn.getWidth(), col * btn.getHeight());
				buttons[row][col] = btn;
				btn.setIJ(row, col);
				add(btn);
			}

	}

	public void update() {
		for (int row = 0; row < ShinyButtons.ROWS; row++)
			for (int col = 0; col < ShinyButtons.ROWS; col++) {
				buttons[row][col].setIcon(icons[sB.getButton(row, col)]);
				buttons[row][col].setSelectedIcon(selectedIcons[sB.getButton(
						row, col)]);
				buttons[row][col].setSelected(sB.getSelected(row, col));
				buttons[row][col].revalidate();
				buttons[row][col].repaint();
			}
	}

	public void resetGame() {
		sB = new ShinyButtons();
		update();
	}

	public void setButtonsListener(ShinyButtonsApp app) {
		for (JButton[] btnarr : buttons) {
			for (JButton btn : btnarr) {
				btn.addActionListener((ActionListener) app);
			}
		}
	}

	public void swap(JCustomButton b1, JCustomButton b2) {
		sB.swap(b1.getI(), b1.getJ(), b2.getI(), b2.getJ());
		update();
		b1.revalidate();
		b1.repaint();
		b2.revalidate();
		b2.repaint();
	}
}
