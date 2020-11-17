package studyreport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;

import org.apache.commons.csv.CSVFormat;

public class ReportUtils {
	public static CSVFormat getFormat(Class<? extends Enum<?>> headerEnum) {
		return CSVFormat.DEFAULT
				.withHeader(headerEnum)
				.withFirstRecordAsHeader();
	}

	public static FileReader getFileReader(String resourceFileName) throws FileNotFoundException, URISyntaxException {
		return new FileReader(new File(ScoreReport.class.getResource(resourceFileName).toURI()));
	}

	public static int toInt(String value) {
		return value == null || value.isEmpty() ? 0 : Integer.parseInt(value);
	}
}
