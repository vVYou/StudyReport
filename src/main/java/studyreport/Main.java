package studyreport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import studyreport.bristol.Bristol;
import studyreport.bristol.BristolReport;
import studyreport.bristol.CSVDescriptionBristol;
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static final String NOT_ENOUGH_DATA = " - ";

    private static CSVPrinter reportPrinter;

    public static void main(String[] args) throws IOException, URISyntaxException {
        String ibsDataInputFile = "..\\data\\testnov\\IBSSSS.csv";
        String sf12DataInputFile = "..\\data\\testnov\\SF12.csv";
        String hadDataInputFile = "..\\data\\testnov\\HAD.csv";
        String bristolDataInputFile = "..\\data\\testnov\\SYMPT_BRISTOL.csv";

        String outputReportFile = "C:\\studyreport\\testNov\\Report.csv";

        initializeReport(outputReportFile);
        Map<String, IBS> ibs = parseIBS(ibsDataInputFile);
        Map<String, SF12> sf12 = parseSF12(sf12DataInputFile);
        Map<String, HAD> had = parseHAD(hadDataInputFile);
        Map<String, Bristol> bristol = parseBristol(bristolDataInputFile);

        List<StudyCase> studyCases = merge(ibs, sf12, had, bristol);
        writeReport(studyCases);

        reportPrinter.close();
    }

    //TODO convert to stream
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

    private static FileReader getFileReader(String resourceFileName) throws FileNotFoundException, URISyntaxException {
        return new FileReader(new File(Main.class.getResource(resourceFileName).toURI()));
    }

    private static Map<String, HAD> parseHAD(String hadDataInputFile) throws IOException, URISyntaxException {
        HashMap<String, HAD> had = new HashMap<>();
        try (CSVParser formEntries = new CSVParser(getFileReader(hadDataInputFile), getFormat(CSVDescriptionHAD.class))) {
            for (CSVRecord formEntry : formEntries) {
                String studyId = formEntry.get(CSVDescriptionHAD.numero_d_identification.getColumnId());
                had.put(studyId, HADCalculation.getHad(formEntry));
            }
        }
        return had;
    }

    private static Map<String, IBS> parseIBS(String ibsDataInputFile) throws IOException, URISyntaxException {
        HashMap<String, IBS> ibs = new HashMap<>();
        try (CSVParser formEntries = new CSVParser(getFileReader(ibsDataInputFile), getFormat(CSVDescriptionIBS.class))) {
            for (CSVRecord formEntry : formEntries.getRecords()) {
                String studyId = formEntry.get(CSVDescriptionIBS.numero_d_identification.getColumnId());
                ibs.put(studyId, IBSCalculation.getIBS(formEntry));
            }
        }
        return ibs;
    }

    private static Map<String, SF12> parseSF12(String sf12DataInputFile) throws IOException, URISyntaxException {
        HashMap<String, SF12> sf12 = new HashMap<>();
        try (CSVParser formEntries = new CSVParser(getFileReader(sf12DataInputFile), getFormat(CSVDescriptionSF12.class))) {
            for (CSVRecord formEntry : formEntries.getRecords()) {
                String studyId = formEntry.get(CSVDescriptionSF12.numero_d_identification.getColumnId());
                sf12.put(studyId, SF12Calculation.getSF12(formEntry));
            }
        }
        return sf12;
    }

    private static Map<String, Bristol> parseBristol(String bristolAnswer) throws IOException, URISyntaxException {
        HashMap<String, Bristol> bristol = new HashMap<>();
        try (CSVParser formEntries = new CSVParser(getFileReader(bristolAnswer), getFormat(CSVDescriptionBristol.class))) {
            for (CSVRecord formEntry : formEntries.getRecords()) {
                String studyId = formEntry.get(CSVDescriptionBristol.numero_d_identification.getColumnId());
                bristol.put(studyId, BristolReport.toBristol(formEntry));
            }
        }
        return bristol;
    }

    private static void initializeReport(String outputReportFile) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(outputReportFile), false);
        reportPrinter = new CSVPrinter(fileWriter, CSVFormat.EXCEL);

        List<Object> headers = new ArrayList<>();
        headers.addAll(Arrays.asList("study_id",
                IBSCalculation.HEADER,
                HADCalculation.HEADER_A,
                HADCalculation.HEADER_D,
                SF12Calculation.HEADER_M,
                SF12Calculation.HEADER_P));
        headers.addAll(Arrays.asList(CSVDescriptionBristol.getReportHeader()));

        reportPrinter.printRecord(headers.toArray());
    }

    private static void writeReport(List<StudyCase> studyCases) throws IOException {
        for (StudyCase studyCase : studyCases) {
            reportPrinter.printRecord(studyCase.getReport());
        }
    }

    public static CSVFormat getFormat(Class<? extends Enum<?>> headerEnum) {
        return CSVFormat.DEFAULT
                .withHeader(headerEnum)
                .withFirstRecordAsHeader();
    }
}
