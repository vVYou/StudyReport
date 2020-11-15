package studyreport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import studyreport.had.CSVDescriptionHAD;
import studyreport.had.HAD;
import studyreport.had.HADCalculation;
import studyreport.ibs.CSVDescriptionIBS;
import studyreport.ibs.IBS;
import studyreport.ibs.IBSCalculation;
import studyreport.sf12.CSVDescriptionSF12;
import studyreport.sf12.SF12;
import studyreport.sf12.SF12Calculation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Main {
	public static final String NOT_ENOUGH_DATA = " - ";

	private static CSVPrinter reportPrinter;

	public static void main(String[] args) throws IOException, URISyntaxException {
		String ibsDataInputFile = "..\\data\\testnov\\IBSSSS.csv";
		String sf12DataInputFile = "..\\data\\testnov\\SF12.csv";
		String hadDataInputFile = "..\\data\\testnov\\HAD.csv";
		//String forwardDataInputFile = "data\testnov\\Data.csv";

		String outputReportFile = "C:\\studyreport\\testNov\\Report.csv";

		initializeReport(outputReportFile);
		HashMap<String, IBS> ibss = parseIBS(ibsDataInputFile);
		HashMap<String, SF12> sf12s = parseSF12(sf12DataInputFile);
		HashMap<String, HAD> hads = parseHAD(hadDataInputFile);

		List<StudyCase> studyCases = merge(ibss, sf12s, hads);
		writeReport(studyCases);

		reportPrinter.close();
	}

	private static List<StudyCase> merge(HashMap<String, IBS> ibss, HashMap<String, SF12> sf12s, HashMap<String, HAD> hads) {
		TreeSet<String> allStringIds = new TreeSet<>(ibss.keySet());
		allStringIds.addAll(sf12s.keySet());
		allStringIds.addAll(hads.keySet());

		List<StudyCase> studyCases = new ArrayList<>();
		for (String id : allStringIds) {
			StudyCase studyCase = new StudyCase(Integer.parseInt(id));
			studyCase.setIbs(ibss.get(id));
			studyCase.setSf12(sf12s.get(id));
			studyCase.setHad(hads.get(id));
			studyCases.add(studyCase);
		}
		studyCases.sort(Comparator.comparing(StudyCase::getStudyID));
		return studyCases;
	}

	private static FileReader getFileReader(String resourceFileName) throws FileNotFoundException, URISyntaxException {
		return new FileReader(new File(Main.class.getResource(resourceFileName).toURI()));
	}

	private static HashMap<String, HAD> parseHAD(String hadDataInputFile) throws IOException, URISyntaxException {
		HashMap<String, HAD> hads = new HashMap<>();
		try (CSVParser formEntries = new CSVParser(getFileReader(hadDataInputFile), CSVDescriptionHAD.getFormat())) {
			for (CSVRecord formEntry : formEntries) {
				String studyId = formEntry.get(CSVDescriptionHAD.numero_d_identification.getColumnIndex());
				HAD had = HADCalculation.getHad(formEntry);
				hads.put(studyId, had);
			}
		}
		return hads;
	}

	private static HashMap<String, IBS> parseIBS(String ibsDataInputFile) throws IOException, URISyntaxException {
		HashMap<String, IBS> ibss = new HashMap<>();
		try (CSVParser formEntries = new CSVParser(getFileReader(ibsDataInputFile), CSVDescriptionIBS.getFormat())) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(CSVDescriptionIBS.numero_d_identification.getColumnIndex());
				IBS ibs = IBSCalculation.getIBS(formEntry);
				ibss.put(studyId, ibs);
			}
		}
		return ibss;
	}

	private static HashMap<String, SF12> parseSF12(String sf12DataInputFile) throws IOException, URISyntaxException {
		HashMap<String, SF12> sf12s = new HashMap<>();
		try (CSVParser formEntries = new CSVParser(getFileReader(sf12DataInputFile), CSVDescriptionSF12.getFormat())) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(CSVDescriptionSF12.numero_d_identification.getColumnIndex());
				SF12 sf12 = SF12Calculation.getSF12(formEntry);
				sf12s.put(studyId, sf12);
			}
		}
		return sf12s;
	}

	private static void initializeReport(String outputReportFile) throws IOException {
		FileWriter fileWriter = new FileWriter(new File(outputReportFile), false);
		reportPrinter = new CSVPrinter(fileWriter, CSVFormat.EXCEL);
		Object[] headers = {"study_id",
							IBSCalculation.HEADER,
							HADCalculation.HEADER_A,
							HADCalculation.HEADER_D,
							SF12Calculation.HEADER_M,
							SF12Calculation.HEADER_P};
		//TODO add data report header
		reportPrinter.printRecord(headers);
	}

	private static void writeReport(List<StudyCase> studyCases) throws IOException {
		for (StudyCase studyCase : studyCases) {
			reportPrinter.printRecord(studyCase.getReport());
		}
	}

}
