package studyreport;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import studyreport.fodmap.AnswerType;
import studyreport.fodmap.FodmapAnswer;
import studyreport.fodmap.FodmapCSVDescription;
import studyreport.fodmap.FodmapGroup;

public class FodmapReport {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String fodmapDataInputFile = "..\\data\\testnov\\FODMAP.csv";

		List<FodmapAnswer> answers = new ArrayList<>();

		FileReader fileReader = ReportUtils.getFileReader(fodmapDataInputFile);
		try (CSVParser csvParser = new CSVParser(fileReader, ReportUtils.getFormat(FodmapCSVDescription.class))) {
			for (CSVRecord record : csvParser.getRecords()) {
				FodmapAnswer fodmapAnswer = new FodmapAnswer(record.get(FodmapCSVDescription.numero_d_identification));
				for (FodmapCSVDescription description : FodmapCSVDescription.values()) {
					if (description.getType() == AnswerType.FOOD) {
						fodmapAnswer.addAnswer(description, ReportUtils.toInt(record.get(description)));
					}
				}
				answers.add(fodmapAnswer);
			}
		}

		for (FodmapGroup fodmapGroup : FodmapGroup.values()) {
			writeGroupReport(fodmapGroup, answers);
		}
	}

	private static void writeGroupReport(FodmapGroup fodmapGroup, List<FodmapAnswer> answers) throws IOException {
		String outputReportFile = "report_" + fodmapGroup + ".csv";
		FileWriter fileWriter = new FileWriter(new File(outputReportFile), false);
		CSVPrinter reportPrinter = new CSVPrinter(fileWriter, CSVFormat.EXCEL);

		List<Object> headers = new ArrayList<>();
		headers.addAll();
		reportPrinter.printRecord(headers.toArray());

		for (FodmapAnswer answer : answers) {
			reportPrinter.printRecord(values);
		}

		reportPrinter.close();
	}

}
