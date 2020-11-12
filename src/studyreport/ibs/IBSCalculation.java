package studyreport.ibs;

import org.apache.commons.csv.CSVRecord;

public class IBSCalculation {
	public static final String HEADER = "ibs_sss";

	public static IBS getIBS(CSVRecord formEntry) {
		return IBS.Builder.anIBS()
				.withIbs1a(YES_NO.valueOf(formEntry.get(CSVDescriptionIBS.IBS_SSS_1A)).isYes())
				.withIbs1b(Integer.valueOf(formEntry.get(CSVDescriptionIBS.IBS_SSS_1B)))
				.withIbs1c(Integer.valueOf(formEntry.get(CSVDescriptionIBS.IBS_SSS_1C)))
				.withIbs2a(YES_NO.valueOf(formEntry.get(CSVDescriptionIBS.IBS_SSS_2A)).isYes())
				.withIbs2b(Integer.valueOf(formEntry.get(CSVDescriptionIBS.IBS_SSS_2B)))
				.withIbs3(Integer.valueOf(formEntry.get(CSVDescriptionIBS.IBS_SSS_3)))
				.withIbs4(Integer.valueOf(formEntry.get(CSVDescriptionIBS.IBS_SSS_4)))
				.build();
	}
}
