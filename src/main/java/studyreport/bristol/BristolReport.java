package studyreport.bristol;

import org.apache.commons.csv.CSVRecord;

import java.util.Arrays;
import java.util.TreeMap;

public class BristolReport {

    public static Bristol toBristol(CSVRecord formEntry) {
        TreeMap<BristolCSVDescription, BristolAnswer> bristolAnswerMap = new TreeMap<>();
        for (BristolCSVDescription csvEntry : BristolCSVDescription.values()) {
            if (csvEntry != BristolCSVDescription.numero_d_identification) {
                String value = formEntry.get(csvEntry);
                bristolAnswerMap.put(csvEntry, toObject(csvEntry.getAnswerType(), value));
            }
        }

        return new Bristol(bristolAnswerMap);
    }

    public static BristolAnswer toObject(Class<? extends BristolAnswer> answerType, String value) {
        return Arrays.stream(answerType.getEnumConstants())
                .filter(bristolAnswer -> bristolAnswer.getFormValue() == toInt(value))
                .map(BristolAnswer.class::cast)
                .findFirst()
                .orElse(new BristolFreetext(value));
    }

    private static int toInt(String value) {
        return value != null && !value.isEmpty() ? Integer.parseInt(value) : 0;
    }

}

