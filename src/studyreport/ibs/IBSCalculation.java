package studyreport.ibs;

import org.apache.commons.csv.CSVRecord;

public class IBSCalculation {
	public static final String HEADER = "ibs_sss";

	public static IBS getIBS(CSVRecord formEntry) {
		return IBS.Builder.anIBS()
				.withIbs1a(getBoolean(formEntry, CSVDescriptionIBS.IBS_SSS_1A))
				.withIbs1b(getInt(formEntry, CSVDescriptionIBS.IBS_SSS_1B))
				.withIbs1c(getInt(formEntry, CSVDescriptionIBS.IBS_SSS_1C))
				.withIbs2a(getBoolean(formEntry, CSVDescriptionIBS.IBS_SSS_2A))
				.withIbs2b(getInt(formEntry, CSVDescriptionIBS.IBS_SSS_2B))
				.withIbs3(getInt(formEntry, CSVDescriptionIBS.IBS_SSS_3))
				.withIbs4(getInt(formEntry, CSVDescriptionIBS.IBS_SSS_4))
				.build();
	}

	private static Integer getInt(CSVRecord formEntry, CSVDescriptionIBS ibsSss1b) {
		String formValue = formEntry.get(ibsSss1b.getColumnIndex());
		String value = formValue == null || formValue.isEmpty() ? "0" : formValue;
		return Integer.valueOf(value);
	}

	private static boolean getBoolean(CSVRecord formEntry, CSVDescriptionIBS csvDescriptionIBS) {
		return YES_NO.toEnum(getInt(formEntry, csvDescriptionIBS)).isYes();
	}
}
