package studyreport.sf12;

import org.apache.commons.csv.CSVRecord;
import studyreport.ReportUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public class SF12Calculation {

    public static final BigDecimal PHYSICAL_WEIGHT_CONST = new BigDecimal("56.57706");
    public static final BigDecimal MENTAL_WEIGHT_CONST = new BigDecimal("60.75781");
    public static final String HEADER_M = "sf12_m";
    public static final String HEADER_P = "sf12_p";

    public static SF12 getSF12(CSVRecord formEntry) {
        boolean isError = ReportUtils.isError(formEntry, SF12CSVDescription.values());
        return new SF12(calculateMentalWeight(formEntry), calculatePhysicalWeight(formEntry), isError);
    }

    private static BigDecimal calculateMentalWeight(CSVRecord formEntry) {
        BigDecimal mentalWeight = sumAnswerWeight(formEntry, MentalWeight::getMentalWeight);
        return mentalWeight.add(MENTAL_WEIGHT_CONST);
    }

    private static BigDecimal calculatePhysicalWeight(CSVRecord formEntry) {
        BigDecimal physicalWeight = sumAnswerWeight(formEntry, PhysicalWeight::getPhysicalWeight);
        return physicalWeight.add(PHYSICAL_WEIGHT_CONST);
    }

    private static Integer getFormAnswer(CSVRecord formEntry, SF12CSVDescription desc) {
        String formAnswer = formEntry.get(desc.getColumnId());
        return formAnswer.matches("[0-9]") ? Integer.valueOf(formAnswer) : Integer.MAX_VALUE;
    }

    private static BigDecimal sumAnswerWeight(CSVRecord formEntry, Function<SF12Answer, BigDecimal> weightToSum) {
        BigDecimal weight = BigDecimal.ZERO;
        for (SF12CSVDescription desc : SF12CSVDescription.getAllAnswerColumns()) {
            Integer formAnswer = getFormAnswer(formEntry, desc);
            BigDecimal weightAnswer = toEnumValue(desc.getAnswer(), formAnswer)
                    .map(weightToSum)
                    .orElseGet(() -> BigDecimal.ZERO);
            weight = weight.add(weightAnswer);
        }
        return weight;
    }

    private static Optional<SF12Answer> toEnumValue(Class<? extends SF12Answer> answerSF12, int formValue) {
        return Arrays.stream(answerSF12.getEnumConstants())
                .map(SF12Answer.class::cast)
                .filter(value -> value.getFormValue() == formValue)
                .findFirst();
    }
}
