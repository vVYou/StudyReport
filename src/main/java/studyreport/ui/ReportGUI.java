package studyreport.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;

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
	public static final String OPENING = "Opening: ";
	public static final String CANCEL = "Open command cancelled by user.";

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
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> ibsInputFile = file);
		} else if (event.getSource() == hadInputButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> hadInputFile = file);
		} else if (event.getSource() == sf12InputButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> sf12InputFile = file);
		} else if (event.getSource() == extraInputsButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> extraInputsFile = file);
		} else if (event.getSource() == saveScoreReportButton) {
			String calculating = "Calculating report : ";
			String cancelCalculation = "Cancel report calculation";
			getSelectedFile(calculating, cancelCalculation)
					.ifPresent(file -> {
						scoreReportOutputFile = file;
						calculateReport();
					});
		}
	}

	private Optional<File> getSelectedFile(String openingLog, String cancelLog) {
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			log.append(openingLog + selectedFile.getName() + "." + NEW_LINE);
			updateCaretPosition();
			return Optional.of(selectedFile);
		} else {
			log.append(cancelLog + NEW_LINE);
			updateCaretPosition();
			return Optional.empty();
		}
	}

	private void updateCaretPosition() {
		log.setCaretPosition(log.getDocument().getLength());
	}

	private void calculateReport() {
		if (validateInputs()) {
			try {
				new ScoreReport().execute(buildScoreReportInput());
				log.append("--------- Score Report Generated ----------");
			} catch (IOException e) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				e.printStackTrace(new PrintStream(byteArrayOutputStream));
				log.append(new String(byteArrayOutputStream.toByteArray()));
			}
		} else {
			log.append("--------- Abort calculation ----------");
		}
	}

	private ScoreReportInput buildScoreReportInput() {
		ScoreReportInput reportInput = ScoreReportInput.Builder.aScoreReportInput()
				.withIbsInput(ibsInputFile)
				.withHadInput(hadInputFile)
				.withSf12Input(sf12InputFile)
				.withExtraInput(extraInputsFile)
				.withOutputFile(scoreReportOutputFile)
				.build();
		return reportInput;
	}

	private boolean validateInputs() {
		if (ibsInputFile == null) {
			log.append("Missing IBS input file" + NEW_LINE);
		}
		if (hadInputFile == null) {
			log.append("Missing HAD input file" + NEW_LINE);
		}
		if (sf12InputFile == null) {
			log.append("Missing SF12 input file" + NEW_LINE);
		}
		if (extraInputsFile == null) {
			log.append("Missing symptoms and bristol input file" + NEW_LINE);
		}
		if (scoreReportOutputFile == null) {
			log.append("Missing output file" + NEW_LINE);
		}

		return ibsInputFile != null && hadInputFile != null && sf12InputFile != null && extraInputsFile != null && scoreReportOutputFile != null;
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