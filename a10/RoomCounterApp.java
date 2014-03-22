import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RoomCounterApp extends JFrame {
	public static ImageIcon wall = new ImageIcon("squareButton.png");

	// These are the model-specific variables
	private RoomMaze		maze;

	// These are window components
	private JButton[][]		buttons;
	private JTextField 		countField;

	// This constructor builds the window
	public RoomCounterApp(String title) {
		super(title);
        initializeBoard();

		setupComponents();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(578,634);
        setResizable(false);

        update();
    }


    // Initialize the board.  Do this whenever a new game is started.
    private void initializeBoard() {
        maze = new RoomMaze();
    }

    // Here we add all the components to the window accordingly
    private void setupComponents() {
    	getContentPane().setLayout(null);

    	// Setup the panel with the buttons
        buttons = new JButton[RoomMaze.ROWS][RoomMaze.ROWS];
        JPanel tiles = new JPanel();
        tiles.setLayout(null);

        // Add the buttons to the tile panel
        for (int r=0; r<RoomMaze.ROWS; r++) {
        	for (int c=0; c<RoomMaze.ROWS; c++) {
				buttons[r][c] = new JButton(wall);
				buttons[r][c].setBackground(Color.WHITE);
				buttons[r][c].setSize(69,69);
				buttons[r][c].setLocation(c*69, r*69);
	          	tiles.add(buttons[r][c]);
        	}
        }
		tiles.setLocation(10,10);
		tiles.setSize(552,552);
        getContentPane().add(tiles);

		// Add the score and buttons
		JLabel aLabel = new JLabel("Separate Pieces:");
        aLabel.setSize(150,25);
		aLabel.setLocation(10, 572);
		getContentPane().add(aLabel);

		countField = new JTextField("0");
        countField.setSize(50,25);
		countField.setLocation(120, 572);
		countField.setHorizontalAlignment(JTextField.RIGHT);
		getContentPane().add(countField);

        JButton resetButton = new JButton("Reset");
        resetButton.setSize(80,25);
		resetButton.setLocation(482, 572);
		getContentPane().add(resetButton);
		resetButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	           	maze.resetWalls();
	           	update();
	        }
	    });
	}


	// Update the board
	private void update() {
		int count = maze.identifyRooms();
		Color[] colors = new Color[count];

		for (int i=0; i<count; i++) {
			colors[i] = new Color((int)(10+Math.random()*200), (int)(10+Math.random()*200), (int)(10+Math.random()*200));
		}
		countField.setText("" + count);

		// Update the look of the buttons
		for (int r=0; r<RoomMaze.ROWS; r++) {
        	for (int c=0; c<RoomMaze.ROWS; c++) {
        		if (maze.getWall(r,c) == 0) {
					buttons[r][c].setIcon(wall);
        		}
        		else {
        			buttons[r][c].setIcon(null);
        			buttons[r][c].setBackground(colors[maze.getWall(r,c)-1]);
        		}
        	}
		}
	}


	public static void main(String[] args) {
		JFrame frame = new RoomCounterApp("Room Counter");
		frame.setVisible(true);
	}
}