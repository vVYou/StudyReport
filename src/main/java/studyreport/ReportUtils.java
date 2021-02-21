package studyreport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import studyreport.had.HADCSVDescription;
import studyreport.sf12.SF12CSVDescription;

public class ReportUtils {
    public static CSVFormat getFormat(Class<? extends Enum<?>> headerEnum) {
        return CSVFormat.DEFAULT
                .withHeader(headerEnum)
                .withFirstRecordAsHeader();
    }

    public static FileReader getFileReader(File file) throws FileNotFoundException {
        return new FileReader(file);
    }

    public static File getFile(String resourceFileName) throws URISyntaxException {
        return new File(ScoreReport.class.getResource(resourceFileName).toURI());
    }

    public static int toInt(String value) {
        return value == null || value.isEmpty() ? 0 : Integer.parseInt(value);
    }

    public static boolean isAbsent(CSVRecord formEntry, Enum<?> csvDescription) {
        return formEntry.get(csvDescription).isEmpty();
    }

    public static boolean isError(CSVRecord formEntry, Enum<?>[] values) {
        boolean isError = false;
        for (Enum<?> csvDescription : values) {
            if (SF12CSVDescription.numero_d_identification != csvDescription && HADCSVDescription.numero_d_identification != csvDescription) {
                isError |= isAbsent(formEntry, csvDescription);
            }
        }
        return isError;
    }
}
