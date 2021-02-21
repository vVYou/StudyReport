package studyreport.ibs;

import org.apache.commons.csv.CSVRecord;
import studyreport.ReportUtils;

public class IBSCalculation {
    public static final String HEADER = "ibs_sss";

    public static IBS getIBS(CSVRecord formEntry) {
        return IBS.Builder.anIBS()
                .withIbs1a(getBoolean(formEntry, IBSCSVDescription.ibs_sss_1_a))
                .withIbs1b(getInt(formEntry, IBSCSVDescription.ibs_sss_1_b))
                .withIbs1c(getInt(formEntry, IBSCSVDescription.ibs_sss_1_c))
                .withIbs2a(getBoolean(formEntry, IBSCSVDescription.ibs_sss_2_a))
                .withIbs2b(getInt(formEntry, IBSCSVDescription.ibs_sss_2_b))
                .withIbs3(getInt(formEntry, IBSCSVDescription.ibs_sss_3))
                .withIbs4(getInt(formEntry, IBSCSVDescription.ibs_sss_4))
                .withError(getError(formEntry))
                .build();
    }

    private static boolean getError(CSVRecord formEntry) {
        return ReportUtils.isAbsent(formEntry, IBSCSVDescription.ibs_sss_1_a)
                || ReportUtils.isAbsent(formEntry, IBSCSVDescription.ibs_sss_2_a)
                || ReportUtils.isAbsent(formEntry, IBSCSVDescription.ibs_sss_3)
                || ReportUtils.isAbsent(formEntry, IBSCSVDescription.ibs_sss_4)
                || (getBoolean(formEntry, IBSCSVDescription.ibs_sss_1_a) && ReportUtils.isAbsent(formEntry, IBSCSVDescription.ibs_sss_1_b))
                || (getBoolean(formEntry, IBSCSVDescription.ibs_sss_2_a) && ReportUtils.isAbsent(formEntry, IBSCSVDescription.ibs_sss_2_b));
    }

    private static Integer getInt(CSVRecord formEntry, IBSCSVDescription IBSCSVDescription) {
        String formValue = formEntry.get(IBSCSVDescription);
        String value = formValue == null || formValue.isEmpty() ? "0" : formValue;
        return Integer.valueOf(value);
    }

    private static boolean getBoolean(CSVRecord formEntry, IBSCSVDescription IBSCSVDescription) {
        return YES_NO.toEnum(getInt(formEntry, IBSCSVDescription)).isYes();
    }
}
