package studyreport;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

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

public class Main {
	public static final String NOT_ENOUGH_DATA = " - ";

	private static CSVPrinter reportPrinter;

	public static void main(String[] args) throws IOException {
		String ibsDataInputFile = "D:\\studyreport\\testNov\\IBSSSS_M6.csv";
		String sf12DataInputFile = "D:\\studyreport\\testNov\\SF12_M6.csv";
		String hadDataInputFile = "D:\\studyreport\\testNov\\HAD_M6.csv";
		//String forwardDataInputFile = "D:\\studyreport\\Data.csv";

		String outputReportFile = "D:\\studyreport\\testNov\\Report.csv";

		initializeReport(outputReportFile);
		HashMap<String, IBS> ibss = parseIBS(ibsDataInputFile);
		HashMap<String, SF12> sf12s = parseSF12(sf12DataInputFile);
		HashMap<String, HAD> hads = parseHAD(hadDataInputFile);

		List<StudyCase> studyCases = merge(ibss, sf12s, hads);
		writeReport(studyCases);

		reportPrinter.close();
	}

	private static List<StudyCase> merge(HashMap<String, IBS> ibss, HashMap<String, SF12> sf12s, HashMap<String, HAD> hads) {
		TreeSet<String> allIds = new TreeSet<>(ibss.keySet());
		allIds.addAll(sf12s.keySet());
		allIds.addAll(hads.keySet());

		List<StudyCase> studyCases = new ArrayList<>();
		for (String id : allIds) {
			StudyCase studyCase = new StudyCase(id);
			studyCase.setIbs(ibss.get(id));
			studyCase.setSf12(sf12s.get(id));
			studyCase.setHad(hads.get(id));
			studyCases.add(studyCase);
		}
		return studyCases;
	}

	private static HashMap<String, HAD> parseHAD(String hadDataInputFile) throws IOException {
		HashMap<String, HAD> hads = new HashMap<>();
		FileReader fileReader = new FileReader(hadDataInputFile);
		try (CSVParser formEntries = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
			for (CSVRecord formEntry : formEntries) {
				String studyId = formEntry.get(CSVDescriptionHAD.STUDY_ID.getColumnIndex());
				HAD had = HADCalculation.getHad(formEntry);
				hads.put(studyId, had);
			}
		}
		return hads;
	}

	private static HashMap<String, IBS> parseIBS(String ibsDataInputFile) throws IOException {
		HashMap<String, IBS> ibss = new HashMap<>();
		FileReader fileReader = new FileReader(ibsDataInputFile);
		try (CSVParser formEntries = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(CSVDescriptionIBS.STUDY_ID.getColumnIndex());
				IBS ibs = IBSCalculation.getIBS(formEntry);
				ibss.put(studyId, ibs);
			}
		}
		return ibss;
	}

	private static HashMap<String, SF12> parseSF12(String sf12DataInputFile) throws IOException {
		HashMap<String, SF12> sf12s = new HashMap<>();
		FileReader fileReader = new FileReader(sf12DataInputFile);
		try (CSVParser formEntries = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(CSVDescriptionSF12.STUDY_ID.getColumnIndex());
				SF12 sf12 = SF12Calculation.getSF12(formEntry);
				sf12s.put(studyId, sf12);
			}
		}
		return sf12s;
	}

	private static void initializeReport(String outputReportFile) throws IOException {
		FileWriter fileWriter = new FileWriter(outputReportFile);
		reportPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);
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
			reportPrinter.printRecord(studyCase.getStudyID(),
									  studyCase.getIbs().score(),
									  studyCase.getHad().a(),
									  studyCase.getHad().d(),
									  studyCase.getSf12().sf12mToReport(),
									  studyCase.getSf12().sf12pToReport());
		}
	}

}
