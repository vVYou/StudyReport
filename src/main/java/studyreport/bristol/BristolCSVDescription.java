package studyreport.bristol;

import java.util.Arrays;

public enum BristolCSVDescription implements Comparable<BristolCSVDescription> {
    numero_d_identification(0, null),
    v03_nausee(1, Symptom.class),
    v03_brulant(2, Symptom.class),
    v03_vomi(3, Symptom.class),
    v03_douleur_estomac(4, Symptom.class),
    v03_regu(5, Symptom.class),
    v03_lourdeurs(6, Symptom.class),
    v03_gaz(7, Symptom.class),
    v03_ballon(8, Symptom.class),
    v03_douleur_ventre(9, Symptom.class),
    v03_bruits(10, Symptom.class),
    v03_gaz2(11, Symptom.class),
    v03_constip(12, Symptom.class),
    v03_sellesmolles(13, Symptom.class),
    v03_diarrhee(14, Symptom.class),
    v03_fatigue(15, Symptom.class),
    v03_transpi(16, Symptom.class),
    v03_vertiges(17, Symptom.class),
    v03_palpi(18, Symptom.class),
    bsc(19, BSC.class);

    private final int columnId;
    private final Class<? extends BristolAnswer> answerType;

    BristolCSVDescription(int columnId, Class<? extends BristolAnswer> answerType) {
        this.columnId = columnId;
        this.answerType = answerType;
    }

    public static BristolCSVDescription[] getReportHeader() {
        return Arrays.copyOfRange(values(), 1, values().length);
    }

    public int getColumnId() {
        return columnId;
    }

    public Class<? extends BristolAnswer> getAnswerType() {
        return answerType;
    }
}
