import javax.swing.*;
import java.awt.event.*;

/*
 * My custom JButton class that enables me to keep an i,j for each button
 * so that it's easier to locate each button in the grid.
 */
public class JCustomButton extends JButton {
	private int i = 0, j = 0;

	public JCustomButton(ImageIcon icon) {
		super(icon);
	}

	public void setIJ(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
}
