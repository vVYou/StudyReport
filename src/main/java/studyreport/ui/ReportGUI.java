package studyreport.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
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

import studyreport.FodmapReport;
import studyreport.ScoreReport;
import studyreport.ScoreReportInput;

public class ReportGUI extends JPanel implements ActionListener {
	static private final String NEW_LINE = "\n";
	public static final String OPENING = "Opening: ";
	public static final String CANCEL = "Open command cancelled by user.";

	private final JButton fodmapInputButton;
	private final JLabel fodmapLabel;
	private final JButton generateFodmapReportButton;
	private static JFrame frame;

	private final JButton generateScoreReportButton;
	private JTextArea log;
	private JFileChooser fileChooser;
	private final JFileChooser directoryChooser;

	private final JButton ibsInputButton;
	private final JButton hadInputButton;
	private final JButton sf12InputButton;
	private final JButton extraInputsButton;
	private final JLabel hadLabel;
	private final JLabel sf12Label;
	private final JLabel extraInfoLabel;
	private final JLabel ibsLabel;

	private File ibsInputFile;
	private File hadInputFile;
	private File sf12InputFile;
	private File extraInputsFile;
	private File scoreReportOutputFile;
	private File fodmapInputFile;
	private File fodmapReportDirectory;

	public ReportGUI() {
		super(new BorderLayout());
		JScrollPane logScrollPane = initLogArea();

		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		ibsInputButton = getFileSelectorButton(getSelectCSVName("IBS"));
		ibsLabel = getNoFileLabel();
		hadInputButton = getFileSelectorButton(getSelectCSVName("HAD"));
		hadLabel = getNoFileLabel();
		sf12InputButton = getFileSelectorButton(getSelectCSVName("SF12"));
		sf12Label = getNoFileLabel();
		extraInputsButton = getFileSelectorButton(getSelectCSVName("Extra inputs"));
		extraInfoLabel = getNoFileLabel();
		generateScoreReportButton = getFileSelectorButton("Generate score report");
		JPanel scoreReportPanel = buildScorePanel();

		directoryChooser = new JFileChooser();
		directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		fodmapInputButton = getFileSelectorButton(getSelectCSVName("FODMAP"));
		fodmapLabel = getNoFileLabel();
		generateFodmapReportButton = getFileSelectorButton("Generate fodmap reports");
		JPanel fodmapReportPanel = buildFodmapPanel();

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(scoreReportPanel);
		buttonPanel.add(fodmapReportPanel);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		add(buttonPanel, BorderLayout.WEST);
		add(logScrollPane, BorderLayout.CENTER);
	}

	private JScrollPane initLogArea() {
		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);
		return logScrollPane;
	}

	private JPanel buildFodmapPanel() {
		JPanel fodmapReportPanel = new JPanel();
		fodmapReportPanel.add(getFileButtonPanel(fodmapInputButton, fodmapLabel));
		fodmapReportPanel.add(generateFodmapReportButton);
		fodmapReportPanel.setLayout(new BoxLayout(fodmapReportPanel, BoxLayout.Y_AXIS));
		return fodmapReportPanel;
	}

	private JPanel buildScorePanel() {
		JPanel scoreReportPanel = new JPanel();
		scoreReportPanel.add(getFileButtonPanel(ibsInputButton, ibsLabel));
		scoreReportPanel.add(getFileButtonPanel(hadInputButton, hadLabel));
		scoreReportPanel.add(getFileButtonPanel(sf12InputButton, sf12Label));
		scoreReportPanel.add(getFileButtonPanel(extraInputsButton, extraInfoLabel));
		scoreReportPanel.add(generateScoreReportButton);
		scoreReportPanel.setLayout(new BoxLayout(scoreReportPanel, BoxLayout.Y_AXIS));
		return scoreReportPanel;
	}

	private JPanel getFileButtonPanel(JButton ibsInputButton, JLabel ibsLabel) {
		JPanel ibsPanel = new JPanel();
		ibsPanel.add(ibsInputButton);
		ibsPanel.add(ibsLabel);
		return ibsPanel;
	}

	private JButton getFileSelectorButton(String buttonName) {
		final JButton hadInputButton = new JButton(buttonName);
		hadInputButton.addActionListener(this);
		return hadInputButton;
	}

	private String getSelectCSVName(String buttonName) {
		return "Select " + buttonName + " input csv";
	}

	private JLabel getNoFileLabel() {
		return new JLabel("No file selected");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ibsInputButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> {
				ibsInputFile = file;
				updateLabel(ibsLabel, file);
			});
		} else if (event.getSource() == hadInputButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> {
				hadInputFile = file;
				updateLabel(hadLabel, file);
			});
		} else if (event.getSource() == sf12InputButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> {
				sf12InputFile = file;
				updateLabel(sf12Label, file);
			});
		} else if (event.getSource() == extraInputsButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> {
				extraInputsFile = file;
				updateLabel(extraInfoLabel, file);
			});
		} else if (event.getSource() == generateScoreReportButton) {
			getSelectedFile("Generate score report : ", "Cancel score report calculation")
					.ifPresent(file -> {
						scoreReportOutputFile = file;
						generateScoreReport();
					});
		} else if (event.getSource() == fodmapInputButton) {
			getSelectedFile(OPENING, CANCEL).ifPresent(file -> {
				fodmapInputFile = file;
				updateLabel(fodmapLabel, file);
			});
		} else if (event.getSource() == generateFodmapReportButton) {
			getSelectedDirectory("Generate fodmap reports : ", "Cancel fodmap report generation")
					.ifPresent(file -> {
						fodmapReportDirectory = file;
						generateFomapReport();
					});
		}
	}

	private void generateFomapReport() {
		try {
			if (fodmapInputFile != null) {
				new FodmapReport().execute(fodmapInputFile, fodmapReportDirectory);
				log.append("--------- Fodamp Reports Generated ----------");
			} else {
				log.append("Missing Fodmap input file");
				log.append("--------- Abort Fodmap Report ----------");
			}
		} catch (Exception e) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(byteArrayOutputStream));
			log.append(new String(byteArrayOutputStream.toByteArray()));
		}
	}

	private void updateLabel(JLabel label, File file) {
		label.setText(file.getName());
		frame.pack();
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

	private Optional<File> getSelectedDirectory(String openingLog, String cancelLog) {
		if (directoryChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = directoryChooser.getSelectedFile();
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

	private void generateScoreReport() {
		try {
			if (validateInputs()) {
				new ScoreReport().execute(buildScoreReportInput());
				log.append("--------- Score Report Generated ----------");
			} else {
				log.append("--------- Abort calculation ----------");
			}
		} catch (Exception e) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(byteArrayOutputStream));
			log.append(byteArrayOutputStream.toString());
		}
	}

	private ScoreReportInput buildScoreReportInput() {
		return ScoreReportInput.Builder.aScoreReportInput()
				.withIbsInput(ibsInputFile)
				.withHadInput(hadInputFile)
				.withSf12Input(sf12InputFile)
				.withExtraInput(extraInputsFile)
				.withOutputFile(scoreReportOutputFile)
				.build();
	}

	private boolean validateInputs() {
		validateInputFilePresence(ibsInputFile, "Missing IBS input file");
		validateInputFilePresence(hadInputFile, "Missing HAD input file");
		validateInputFilePresence(sf12InputFile, "Missing SF12 input file");
		validateInputFilePresence(extraInputsFile, "Missing symptoms and bristol input file");
		validateInputFilePresence(scoreReportOutputFile, "Missing output file");

		return ibsInputFile != null && hadInputFile != null && sf12InputFile != null && extraInputsFile != null && scoreReportOutputFile != null;
	}

	private void validateInputFilePresence(File inputFile, String errorMessage) {
		if (inputFile == null) {
			log.append(errorMessage + NEW_LINE);
		}
	}

	private static void createAndShowGUI() {
		frame = new JFrame("StudyReport");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ReportGUI());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			UIManager.put("swing.boldMetal", Boolean.FALSE);
			createAndShowGUI();
		});
	}
}