package studyreport.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FileChooserDemo extends JPanel implements ActionListener {
	static private final String NEW_LINE = "\n";
	JButton openButton;
	JButton saveButton;
	JTextArea log;
	JFileChooser fileChooser;

	public FileChooserDemo() {
		super(new BorderLayout());

		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);

		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		openButton = new JButton("Open a File...");
		openButton.addActionListener(this);

		saveButton = new JButton("Save a File...");
		saveButton.addActionListener(this);

		//For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel(); //use FlowLayout
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);

		JPanel buttonPanel2 = new JPanel(); //use FlowLayout
		buttonPanel2.add(new JButton("Open file 2"));
		buttonPanel2.add(new JButton("Save file 2"));

		JPanel buttonPanel3 = new JPanel(); //use FlowLayout
		buttonPanel3.add(new JButton("Open file 3"));
		buttonPanel3.add(new JButton("Save file 3"));

		//GridBagLayout gridBagLayout = new GridBagLayout();
		//setLayout(gridBagLayout);
		//GridBagConstraints gridBagConstraint = new GridBagConstraints();
		//add(buttonPanel, gridBagConstraint);
		//add(buttonPanel2, gridBagConstraint);
		//add(logScrollPane, gridBagConstraint);
		//setLayout(this, new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel leftMenu = new JPanel();
		leftMenu.add(new JLabel("Score report"));
		leftMenu.add(buttonPanel);
		leftMenu.add(buttonPanel2);
		leftMenu.add(new JLabel("Score report"));
		leftMenu.add(buttonPanel3);
		leftMenu.setLayout(new BoxLayout(leftMenu, BoxLayout.Y_AXIS));
		add(leftMenu, BorderLayout.WEST);
		//add(buttonPanel, BorderLayout.WEST);
		//add(buttonPanel2, BorderLayout.WEST);
		add(logScrollPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Handle open button action.
		if (e.getSource() == openButton) {
			int returnVal = fileChooser.showOpenDialog(FileChooserDemo.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				//This is where a real application would open the file.
				log.append("Opening: " + file.getName() + "." + NEW_LINE);
			} else {
				log.append("Open command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());

			//Handle save button action.
		} else if (e.getSource() == saveButton) {
			int returnVal = fileChooser.showSaveDialog(FileChooserDemo.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				//This is where a real application would save the file.
				log.append("Saving: " + file.getName() + "." + NEW_LINE);
			} else {
				log.append("Save command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());
		}
	}

	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("StudyReport");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add content to the window.
		frame.add(new FileChooserDemo());

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event dispatch thread:
		//creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}