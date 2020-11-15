package studyreport.had;

import org.apache.commons.csv.CSVRecord;

public class HADCalculation {
    public static final String HEADER_A = "had_a";
    public static final String HEADER_D = "had_d";

    public static HAD getHad(CSVRecord formEntry) {
        int hada = 0;
        int hadd = 0;
        for (CSVDescriptionHAD csvEntry : CSVDescriptionHAD.values()) {
            if (csvEntry != CSVDescriptionHAD.numero_d_identification) {
                int entry = toInt(formEntry.get(csvEntry));
                int score = toScore(entry, csvEntry.isReverseWeight());
                if (csvEntry.getColumnId() % 2 == 0) {
                    hadd += score;
                } else {
                    hada += score;
                }
            }
        }
        return new HAD(hada, hadd);
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

    private static int toInt(String formEntry) {
        return formEntry == null || formEntry.isEmpty() ? 0 : Integer.parseInt(formEntry);
    }
}
