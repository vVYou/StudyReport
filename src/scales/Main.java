package scales;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Main {

	public static void main(String[] args) throws IOException {
		String dataInputFile = "D:\\OneDrive - GCloud Belgium\\Prive\\Pauli\\Data.csv";
		String outputReportFile = "D:\\OneDrive - GCloud Belgium\\Prive\\Pauli\\Report.csv";
		CSVFormat format = CSVFormat.newFormat(',');

		FileWriter fileWriter = new FileWriter(outputReportFile);
		CSVPrinter reportPrinter = new CSVPrinter(fileWriter, format);
		reportPrinter.printRecord("study_id, physical_weight, mental_weight");

		FileReader fileReader = new FileReader(dataInputFile);
		try (CSVParser formEntries = new CSVParser(fileReader, format)) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(CSVDescription.STUDY_ID.getColumnIndex());
				String physicalWeight = calculatePysicalWeight(formEntry);
				String mentalWeight = calculateMentalWeight(formEntry);
				reportPrinter.printRecord(studyId, physicalWeight, mentalWeight);
			}
		}

		reportPrinter.close();

	}
}
