package studyreport.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

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

import studyreport.ScoreReport;
import studyreport.ScoreReportInput;

public class ReportGUI extends JPanel implements ActionListener {
	static private final String NEW_LINE = "\n";

	private final JButton ibsInputButton;
	private final JButton hadInputButton;
	private final JButton sf12InputButton;
	private final JButton extraInputsButton;

	JButton saveScoreReportButton;
	JTextArea log;
	JFileChooser fileChooser;

	private File ibsInputFile;
	private File hadInputFile;
	private File sf12InputFile;
	private File extraInputsFile;
	private File scoreReportOutputFile;

	public ReportGUI() {
		super(new BorderLayout());

		//TODO use it for error report
		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);

		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		JPanel ibsPanel = new JPanel();
		ibsInputButton = new JButton("Select IBS input csv");
		ibsInputButton.addActionListener(this);
		JLabel ibsLabel = getLabelNoFile();
		ibsPanel.add(ibsInputButton);
		ibsPanel.add(ibsLabel);

		JPanel hadPanel = new JPanel();
		hadInputButton = new JButton("Select HAD input csv");
		hadInputButton.addActionListener(this);
		JLabel hadLabel = getLabelNoFile();
		hadPanel.add(hadInputButton);
		hadPanel.add(hadLabel);

		JPanel sf12Panel = new JPanel();
		sf12InputButton = new JButton("Select SF12 input csv");
		sf12InputButton.addActionListener(this);
		JLabel sf12Label = getLabelNoFile();
		sf12Panel.add(sf12InputButton);
		sf12Panel.add(sf12Label);

		JPanel extraInputPanel = new JPanel();
		extraInputsButton = new JButton("Select Extra inputs csv");
		extraInputsButton.addActionListener(this);
		JLabel extraInfoLabel = getLabelNoFile();
		extraInputPanel.add(extraInputsButton);
		extraInputPanel.add(extraInfoLabel);

		saveScoreReportButton = new JButton("Save score report");
		saveScoreReportButton.addActionListener(this);

		JPanel scoreReportPanel = new JPanel();
		scoreReportPanel.add(ibsPanel);
		scoreReportPanel.add(hadPanel);
		scoreReportPanel.add(sf12Panel);
		scoreReportPanel.add(extraInputPanel);
		scoreReportPanel.add(saveScoreReportButton); //TODO
		scoreReportPanel.setLayout(new BoxLayout(scoreReportPanel, BoxLayout.Y_AXIS));

		//JPanel buttonPanel2 = new JPanel(); //use FlowLayout
		//buttonPanel2.add(new JButton("Open file 2"));
		//buttonPanel2.add(new JButton("Save file 2"));
		//
		//JPanel buttonPanel3 = new JPanel(); //use FlowLayout
		//buttonPanel3.add(new JButton("Open file 3"));
		//buttonPanel3.add(new JButton("Save file 3"));

		//GridBagLayout gridBagLayout = new GridBagLayout();
		//setLayout(gridBagLayout);
		//GridBagConstraints gridBagConstraint = new GridBagConstraints();
		//add(buttonPanel, gridBagConstraint);
		//add(buttonPanel2, gridBagConstraint);
		//add(logScrollPane, gridBagConstraint);
		//setLayout(this, new BoxLayout(this, BoxLayout.Y_AXIS));
		//JPanel leftMenu = new JPanel();
		//leftMenu.add(new JLabel("Score report"));
		//leftMenu.add(scoreReportPanel);
		//leftMenu.add(buttonPanel2);
		//leftMenu.add(new JLabel("Score report"));
		//leftMenu.add(buttonPanel3);
		//leftMenu.setLayout(new BoxLayout(leftMenu, BoxLayout.Y_AXIS));

		add(scoreReportPanel, BorderLayout.WEST);
		//add(buttonPanel, BorderLayout.WEST);
		//add(buttonPanel2, BorderLayout.WEST);
		add(logScrollPane, BorderLayout.CENTER);
	}

	private JLabel getLabelNoFile() {
		return new JLabel("No file selected");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ibsInputButton) {
			int returnVal = fileChooser.showOpenDialog(ReportGUI.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				ibsInputFile = fileChooser.getSelectedFile();
				log.append("Opening: " + ibsInputFile.getName() + "." + NEW_LINE);
			} else {
				log.append("Open command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());

		} else if (event.getSource() == hadInputButton) {
			int returnVal = fileChooser.showOpenDialog(ReportGUI.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				hadInputFile = fileChooser.getSelectedFile();
				log.append("Opening: " + hadInputFile.getName() + "." + NEW_LINE);
			} else {
				log.append("Open command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());

		} else if (event.getSource() == sf12InputButton) {
			int returnVal = fileChooser.showOpenDialog(ReportGUI.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				sf12InputFile = fileChooser.getSelectedFile();
				log.append("Opening: " + sf12InputFile.getName() + "." + NEW_LINE);
			} else {
				log.append("Open command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());

		} else if (event.getSource() == extraInputsButton) {
			int returnVal = fileChooser.showOpenDialog(ReportGUI.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				extraInputsFile = fileChooser.getSelectedFile();
				log.append("Opening: " + extraInputsFile.getName() + "." + NEW_LINE);
			} else {
				log.append("Open command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());

		} else if (event.getSource() == saveScoreReportButton) {
			int returnVal = fileChooser.showSaveDialog(ReportGUI.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				scoreReportOutputFile = fileChooser.getSelectedFile();
				log.append("Calculating report : " + scoreReportOutputFile.getName() + "." + NEW_LINE);
				calculateReport();
			} else {
				log.append("Save command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());
		}
	}

	private void calculateReport() {
		//TODO add input validation
		ScoreReportInput reportInput = ScoreReportInput.Builder.aScoreReportInput()
				.withIbsInput(ibsInputFile)
				.withHadInput(hadInputFile)
				.withSf12Input(sf12InputFile)
				.withExtraInput(extraInputsFile)
				.withOutputFile(scoreReportOutputFile)
				.build();

		try {
			new ScoreReport().execute(reportInput);
		} catch (IOException e) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(byteArrayOutputStream));
			log.append(new String(byteArrayOutputStream.toByteArray()));
		}
	}

	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("StudyReport");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add content to the window.
		frame.add(new ReportGUI());

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