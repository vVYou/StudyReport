package scales;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class Main {

	private static final BigDecimal PHYSICAL_WEIGHT_CONST = new BigDecimal("56.57706");
	private static final BigDecimal MENTAL_WEIGHT_CONST = new BigDecimal("60.75781");
	private static final String NOT_ENOUGH_DATA = "NOT_ENOUGH_DATA";

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		String dataInputFile = "D:\\OneDrive - GCloud Belgium\\Prive\\Pauli\\Data.csv";
		String outputReportFile = "D:\\OneDrive - GCloud Belgium\\Prive\\Pauli\\Report.csv";
		CSVFormat format = CSVFormat.newFormat(',');

		FileWriter fileWriter = new FileWriter(outputReportFile);
		CSVPrinter reportPrinter = new CSVPrinter(fileWriter, format);
		reportPrinter.printRecord("study_id, physical_weight, mental_weight");
		//reportPrinter.println();

		FileReader fileReader = new FileReader(dataInputFile);
		try (CSVParser formEntries = new CSVParser(fileReader, format)) {
			for (CSVRecord formEntry : formEntries.getRecords()) {
				String studyId = formEntry.get(CSVDescription.STUDY_ID.getColumnIndex());
				BigDecimal physicalWeight = calculatePhysicalWeight(formEntry);
				BigDecimal mentalWeight = calculateMentalWeight(formEntry);

				String physicalWeightS = PHYSICAL_WEIGHT_CONST.equals(physicalWeight) ? NOT_ENOUGH_DATA : physicalWeight.toString();
				String mentalWeightS = MENTAL_WEIGHT_CONST.equals(mentalWeight) ? NOT_ENOUGH_DATA : mentalWeight.toString();
				reportPrinter.printRecords(studyId, physicalWeightS, mentalWeightS);
				//reportPrinter.println();
				//reportPrinter.printRecord(studyId);
				//reportPrinter.printRecord(physicalWeightS);
				//reportPrinter.printRecord(mentalWeightS);
				//reportPrinter.println();
				System.out.println("" + studyId + ", " + physicalWeightS + ", " + mentalWeightS);
			}
		}

		reportPrinter.close();
	}

	private static Integer getFormAnswer(CSVRecord formEntry, CSVDescription desc) {
		String formAnswer = formEntry.get(desc.getColumnIndex());
		return formAnswer.matches("[0-9]") ? Integer.valueOf(formAnswer) : Integer.MAX_VALUE;
	}

	private static BigDecimal calculateMentalWeight(CSVRecord formEntry) {
		BigDecimal mentalWeight = sumAnswerWeight(formEntry, MentalWeight::getMentalWeight);
		return mentalWeight.add(MENTAL_WEIGHT_CONST);
	}

	private static BigDecimal calculatePhysicalWeight(CSVRecord formEntry) {
		BigDecimal physicalWeight = sumAnswerWeight(formEntry, PhysicalWeight::getPhysicalWeight);
		return physicalWeight.add(PHYSICAL_WEIGHT_CONST);
	}

	private static BigDecimal sumAnswerWeight(CSVRecord formEntry, Function<Answer, BigDecimal> weightToSum) {
		BigDecimal mentalWeight = BigDecimal.ZERO;
		for (CSVDescription desc : CSVDescription.getAllAnswerColumns()) {
			Integer formAnswer = getFormAnswer(formEntry, desc);
			BigDecimal answerMentalWeight = toEnumValue(desc.getAnswer(), formAnswer)
					.map(weightToSum)
					.orElseGet(() -> BigDecimal.ZERO);
			mentalWeight = mentalWeight.add(answerMentalWeight);
		}
		return mentalWeight;
	}

	private static Optional<Answer> toEnumValue(Class<? extends Answer> clazz, int formValue) {
		return Arrays.stream(clazz.getEnumConstants())
				.map(Answer.class::cast)
				.filter(value -> value.getFormValue() == formValue)
				.findFirst();
	}
}
