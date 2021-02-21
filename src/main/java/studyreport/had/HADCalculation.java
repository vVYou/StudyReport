package studyreport.had;

import org.apache.commons.csv.CSVRecord;

import studyreport.ReportUtils;
import studyreport.sf12.SF12CSVDescription;

public class HADCalculation {
	public static final String HEADER_A = "had_a";
	public static final String HEADER_D = "had_d";

	public static HAD getHad(CSVRecord formEntry) {
		int hada = 0;
		int hadd = 0;
		for (HADCSVDescription csvEntry : HADCSVDescription.values()) {
			if (csvEntry != HADCSVDescription.numero_d_identification) {
				int entry = ReportUtils.toInt(formEntry.get(csvEntry));
				int score = toScore(entry, csvEntry.isReverseWeight());
				if (csvEntry.getColumnId() % 2 == 0) {
					hadd += score;
				} else {
					hada += score;
				}
			}
		}

		boolean isError = ReportUtils.isError(formEntry, HADCSVDescription.values());
		return new HAD(hada, hadd, isError);
	}

	private static int toScore(int entry, boolean isReverseWeight) {
		if (entry == 0) {
			return 0;
		} else if (isReverseWeight) {
			if (entry == 1) {
				return 3;
			} else if (entry == 2) {
				return 2;
			} else if (entry == 3) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return entry - 1;
		}
	}

}
