package studyreport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import studyreport.bristol.Bristol;
import studyreport.bristol.BristolCSVDescription;
import studyreport.bristol.BristolReport;
import studyreport.had.HAD;
import studyreport.had.HADCSVDescription;
import studyreport.had.HADCalculation;
import studyreport.ibs.IBS;
import studyreport.ibs.IBSCSVDescription;
import studyreport.ibs.IBSCalculation;
import studyreport.sf12.SF12;
import studyreport.sf12.SF12CSVDescription;
import studyreport.sf12.SF12Calculation;

public class ScoreReport {
	public static final String NOT_ENOUGH_DATA = " - ";

	public void execute(ScoreReportInput reportInput) throws IOException {
		CSVPrinter reportPrinter = initializeReport(reportInput.getOutputFile());
		Map<String, IBS> ibs = parseIBS(reportInput.getIbsInput());
		Map<String, SF12> sf12 = parseSF12(reportInput.getSf12Input());
		Map<String, HAD> had = parseHAD(reportInput.getHadInput());
		Map<String, Bristol> bristol = parseBristol(reportInput.getExtraInput());

		List<StudyCase> studyCases = merge(ibs, sf12, had, bristol);
		writeReport(reportPrinter, studyCases);

		reportPrinter.close();
	}

	//public static void main(String[] args) throws IOException, URISyntaxException {
	//	String ibsDataInputFile = "..\\data\\testnov\\IBSSSS.csv";
	//	String sf12DataInputFile = "..\\data\\testnov\\SF12.csv";
	//	String hadDataInputFile = "..\\data\\testnov\\HAD.csv";
	//	String bristolDataInputFile = "..\\data\\testnov\\SYMPT_BRISTOL.csv";
	//
	//	String outputReportFile = "report_score.csv";
	//
	//	ScoreReportInput scoreReportInput = ScoreReportInput.Builder.aScoreReportInput()
	//			.withIbsInput(ReportUtils.getFile(ibsDataInputFile))
	//			.withSf12Input(ReportUtils.getFile(sf12DataInputFile))
	//			.withHadInput(ReportUtils.getFile(hadDataInputFile))
	//			.withExtraInput(ReportUtils.getFile(bristolDataInputFile))
	//			.withOutputFile(ReportUtils.getFile(outputReportFile))
	//			.build();
	//	new ScoreReport().execute(scoreReportInput);
	//}

	private static List<StudyCase> merge(Map<String, IBS> ibs, Map<String, SF12> sf12, Map<String, HAD> had, Map<String, Bristol> bristol) {
		List<StudyCase> studyCases = new ArrayList<>();
		for (String id : getIds(ibs, sf12, had, bristol)) {
			StudyCase studyCase = new StudyCase(Integer.parseInt(id));
			studyCase.setIbs(ibs.get(id));
			studyCase.setSf12(sf12.get(id));
			studyCase.setHad(had.get(id));
			studyCase.setBristol(bristol.get(id));
			studyCases.add(studyCase);
		}
		studyCases.sort(Comparator.comparing(StudyCase::getStudyID));
		return studyCases;
	}

	private static TreeSet<String> getIds(Map<String, ?>... ids) {
		return Arrays.stream(ids)
				.flatMap(map -> map.keySet().stream())
				.collect(Collectors.toCollection(TreeSet::new));
	}

	private static Map<String, HAD> parseHAD(File hadInputFile) throws IOException {
		HashMap<String, HAD> had = new HashMap<>();
		try (CSVParser formEntries = new CSVParser(ReportUtils.getFileReader(hadInputFile), ReportUtils.getFormat(HADCSVDescription.class))) {
			for (CSVRecord formEntry : formEntries) {
				String studyId = formEntry.get(HADCSVDescription.numero_d_identification.getColumnId());
				had.put(studyId, HADCalculation.getHad(formEntry));
			}
		}
		return had;
	}

	private static Map<String, IBS> parseIBS(File ibsInputFile) throws IOException {
		HashMap<String, IBS> ibs = new HashMap<>();
		try (CSVParser formEntries = new CSVParser(ReportUtils.getFileReader(ibsInputFile), ReportUtils.getFormat(IBSCSVDescription.class))) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(IBSCSVDescription.numero_d_identification.getColumnId());
				ibs.put(studyId, IBSCalculation.getIBS(formEntry));
			}
		}
		return ibs;
	}

	private static Map<String, SF12> parseSF12(File sf12InputFile) throws IOException {
		HashMap<String, SF12> sf12 = new HashMap<>();
		try (CSVParser formEntries = new CSVParser(ReportUtils.getFileReader(sf12InputFile), ReportUtils.getFormat(SF12CSVDescription.class))) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(SF12CSVDescription.numero_d_identification.getColumnId());
				sf12.put(studyId, SF12Calculation.getSF12(formEntry));
			}
		}
		return sf12;
	}

	private static Map<String, Bristol> parseBristol(File extraInputsFile) throws IOException {
		HashMap<String, Bristol> bristol = new HashMap<>();
		try (CSVParser formEntries = new CSVParser(ReportUtils.getFileReader(extraInputsFile), ReportUtils.getFormat(BristolCSVDescription.class))) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(BristolCSVDescription.numero_d_identification.getColumnId());
				bristol.put(studyId, BristolReport.toBristol(formEntry));
			}
		}
		return bristol;
	}

	private static CSVPrinter initializeReport(File outputReportFile) throws IOException {
		FileWriter fileWriter = new FileWriter(outputReportFile, false);
		CSVPrinter reportPrinter = new CSVPrinter(fileWriter, CSVFormat.EXCEL);

		List<Object> headers = new ArrayList<>();
		headers.addAll(Arrays.asList("study_id",
									 IBSCalculation.HEADER,
									 HADCalculation.HEADER_A,
									 HADCalculation.HEADER_D,
									 SF12Calculation.HEADER_M,
									 SF12Calculation.HEADER_P));
		headers.addAll(Arrays.asList(BristolCSVDescription.getReportHeader()));

		reportPrinter.printRecord(headers.toArray());
		return reportPrinter;
	}

	private static void writeReport(CSVPrinter reportPrinter, List<StudyCase> studyCases) throws IOException {
		for (StudyCase studyCase : studyCases) {
			reportPrinter.printRecord(studyCase.getReport());
		}
	}
}
