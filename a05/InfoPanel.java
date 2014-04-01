import java.awt.ComponentOrientation;

import javax.swing.*;

public class InfoPanel extends JPanel {
	public InfoPanel(String title) {
		// Choose to lay out components manually
		setLayout(null);

		// Make a border around the outside with the given title
		setBorder(BorderFactory.createTitledBorder(title));

		setSize(550, 240);

		// Add the Name, Street, City, Province and PostalCode labels
		JLabel aLabel = new JLabel("First Name:");
		aLabel.setLocation(10, 20);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("Last Name:");
		aLabel.setLocation(10, 55);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("Street:");
		aLabel.setLocation(10, 90);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("City:");
		aLabel.setLocation(10, 125);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("Province:");
		aLabel.setLocation(10, 160);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("Postal Code:");
		aLabel.setLocation(10, 195);
		aLabel.setSize(80, 30);
		add(aLabel);

		// Add the first name textfield
		JTextField firstNameField = new JTextField();
		firstNameField.setLocation(100, 20);
		firstNameField.setSize(150, 30);
		add(firstNameField);

		// Add the last name textfield
		JTextField lastNameField = new JTextField();
		lastNameField.setLocation(100, 55);
		lastNameField.setSize(150, 30);
		add(lastNameField);

		// Add the street textfield
		JTextField streetField = new JTextField();
		streetField.setLocation(100, 90);
		streetField.setSize(150, 30);
		add(streetField);

		// Add the city textfield
		JTextField cityField = new JTextField();
		cityField.setLocation(100, 125);
		cityField.setSize(150, 30);
		add(cityField);

		// Add the province drop-down
		String[] provs = { "AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU",
				"ON", "PE", "QC", "SK", "YT" };
		JComboBox provBox1 = new JComboBox(provs);
		provBox1.setLocation(100, 160);
		provBox1.setSize(60, 30);
		add(provBox1);

		// Add the postal code textfield
		JTextField postalField = new JTextField();
		postalField.setLocation(100, 195);
		postalField.setSize(80, 30);
		add(postalField);

		// Add the Name, Street, City, Province and PostalCode labels
		aLabel = new JLabel("Home Phone:");
		aLabel.setLocation(10 + 50 + 80 + firstNameField.getWidth(), 20);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("Cell Phone:");
		aLabel.setLocation(10 + 50 + 80 + lastNameField.getWidth(), 55);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("Email Address:");
		aLabel.setLocation(10 + 50 + 80 + streetField.getWidth(), 90);
		aLabel.setSize(90, 30);
		add(aLabel);

		aLabel = new JLabel("Age:");
		aLabel.setLocation(10 + 50 + 80 + cityField.getWidth(), 125);
		aLabel.setSize(80, 30);
		add(aLabel);

		aLabel = new JLabel("Gender:");
		aLabel.setLocation(10 + 50 + 80 + cityField.getWidth(), 160);
		aLabel.setSize(80, 30);
		add(aLabel);

		// Add the home phone textfield
		JTextField homePhoneField = new JTextField();
		homePhoneField.setSize(150, 30);
		homePhoneField.setLocation(getWidth() - homePhoneField.getWidth() - 10,
				20);
		homePhoneField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(homePhoneField);

		// Add the cell phone textfield
		JTextField cellPhoneField = new JTextField();
		cellPhoneField.setSize(150, 30);
		cellPhoneField.setLocation(getWidth() - cellPhoneField.getWidth() - 10,
				55);
		cellPhoneField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(cellPhoneField);

		// Add the email textfield
		JTextField emailField = new JTextField();
		emailField.setSize(150, 30);
		emailField.setLocation(getWidth() - emailField.getWidth() - 10, 90);
		emailField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		add(emailField);

		JSpinner spinner = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
		spinner.setSize(50, 30);
		spinner.setLocation(getWidth() - emailField.getWidth() - 10, 125);
		add(spinner);

		ButtonGroup genders = new ButtonGroup();
		JRadioButton[] genderbuttons = new JRadioButton[2];
		String[] genderlabels = { "Male", "Female" };
		for (int i = 0; i < genderbuttons.length; i++) {
			genderbuttons[i] = new JRadioButton(genderlabels[i], false);
			genderbuttons[i].setLocation(getWidth() - emailField.getWidth()
					- 10 + (70 * i), 160);
			genderbuttons[i].setSize(70, 30);
			add(genderbuttons[i]);
			genders.add(genderbuttons[i]);
		}

	}
}
