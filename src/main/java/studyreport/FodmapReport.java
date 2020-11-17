package studyreport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.ArrayUtils;

import studyreport.fodmap.AnswerType;
import studyreport.fodmap.FodmapAnswer;
import studyreport.fodmap.FodmapCSVDescription;
import studyreport.fodmap.FodmapGroup;

public class FodmapReport {

	public static void main(String[] args) throws IOException, URISyntaxException {
		String fodmapDataInputFile = "..\\data\\testnov\\FODMAP.csv";
		List<FodmapAnswer> answers = getFodmapAnswers(fodmapDataInputFile);

		for (FodmapGroup fodmapGroup : FodmapGroup.values()) {
			writeGroupReport(fodmapGroup, answers);
		}
	}

	private static List<FodmapAnswer> getFodmapAnswers(String fodmapDataInputFile) throws URISyntaxException, IOException {
		List<FodmapAnswer> answers = new ArrayList<>();
		try (CSVParser csvParser = new CSVParser(ReportUtils.getFileReader(fodmapDataInputFile), ReportUtils.getFormat(FodmapCSVDescription.class))) {
			for (CSVRecord record : csvParser.getRecords()) {
				FodmapAnswer fodmapAnswer = new FodmapAnswer(ReportUtils.toInt(record.get(FodmapCSVDescription.numero_d_identification.getColumnId())));
				for (FodmapCSVDescription description : FodmapCSVDescription.values()) {
					if (description.getType() == AnswerType.FOOD) {
						fodmapAnswer.addAnswer(description, ReportUtils.toInt(record.get(description)));
					}
				}
				answers.add(fodmapAnswer);
			}
		}
		answers.sort(Comparator.comparing(FodmapAnswer::getStudyId));
		return answers;
	}

	private static void writeGroupReport(FodmapGroup fodmapGroup, List<FodmapAnswer> answers) throws IOException {
		String outputReportFile = "report_" + fodmapGroup + ".csv";
		FileWriter fileWriter = new FileWriter(new File(outputReportFile), false);
		CSVPrinter reportPrinter = new CSVPrinter(fileWriter, CSVFormat.EXCEL);

		List<FodmapCSVDescription> fodmapGroupDescriptions = getFodmapGroupDescriptions(fodmapGroup);

		reportPrinter.printRecord(getHeaders(fodmapGroupDescriptions).toArray());

		for (FodmapAnswer answer : answers) {
			reportPrinter.printRecord(getRecord(fodmapGroupDescriptions, answer));
		}

		reportPrinter.close();
	}

	private static List<Object> getRecord(List<FodmapCSVDescription> fodmapGroupDescriptions, FodmapAnswer answer) {
		List<Object> record = new ArrayList<>();
		record.add(answer.getStudyId());
		for (FodmapCSVDescription fodmapGroupDescription : fodmapGroupDescriptions) {
			record.add(answer.getAnswers().get(fodmapGroupDescription));
		}
		return record;
	}

	private static List<Object> getHeaders(List<FodmapCSVDescription> fodmapGroupDescriptions) {
		List<Object> headers = new ArrayList<>();
		headers.add(FodmapCSVDescription.numero_d_identification);
		headers.addAll(fodmapGroupDescriptions.stream()
							   .map(FodmapCSVDescription::getFrenchTranslation)
							   .sorted()
							   .collect(Collectors.toList()));
		return headers;
	}

	private static List<FodmapCSVDescription> getFodmapGroupDescriptions(FodmapGroup fodmapGroup) {
		return Arrays.stream(FodmapCSVDescription.values())
				.filter(description -> ArrayUtils.contains(description.getGroups(), fodmapGroup))
				.sorted()
				.collect(Collectors.toList());
	}

}
