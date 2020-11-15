package studyreport.bristol;

import studyreport.YES_NO;

import java.util.Arrays;

public enum CSVDescriptionBristol implements Comparable<CSVDescriptionBristol> {
    numero_d_identification(0, null),
    v03_nausee(1, Symptomes.class),
    v03_brulant(2, Symptomes.class),
    v03_vomi(3, Symptomes.class),
    v03_douleur_estomac(4, Symptomes.class),
    v03_regu(5, Symptomes.class),
    v03_lourdeurs(6, Symptomes.class),
    v03_gaz(7, Symptomes.class),
    v03_ballon(8, Symptomes.class),
    v03_douleur_ventre(9, Symptomes.class),
    v03_bruits(10, Symptomes.class),
    v03_gaz2(11, Symptomes.class),
    v03_constip(12, Symptomes.class),
    v03_sellesmolles(13, Symptomes.class),
    v03_diarrhee(14, Symptomes.class),
    v03_fatigue(15, Symptomes.class),
    v03_transpi(16, Complete.class),
    v03_vertiges(17, BristolFreetext.class),
    v03_palpi(18, YES_NO.class),
    bsc(19, BSC.class);

    private final int columnId;
    private final Class<? extends BristolAnswer> answerType;

    CSVDescriptionBristol(int columnId, Class<? extends BristolAnswer> answerType) {
        this.columnId = columnId;
        this.answerType = answerType;
    }

    public static CSVDescriptionBristol[] getReportHeader() {
        return Arrays.copyOfRange(values(), 1, values().length);
    }

    public int getColumnId() {
        return columnId;
    }

    public Class<? extends BristolAnswer> getAnswerType() {
        return answerType;
    }


}
