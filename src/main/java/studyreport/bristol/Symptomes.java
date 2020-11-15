package studyreport.bristol;

public enum Symptomes implements BristolAnswer {
    NONE(0, "aucun"),
    VERY_FEW(1, "très peu"),
    FEW(2, "un peu"),
    MODERATE(3, "modéré"),
    SEVERE(4, "sévère"),
    VERY_SERVERE(5, "très sévère");

    private final int formValue;
    private final String frenchTranslation;

    Symptomes(int formValue, String frenchTranslation) {
        this.formValue = formValue;
        this.frenchTranslation = frenchTranslation;
    }

    @Override
    public int getFormValue() {
        return formValue;
    }

    @Override
    public String toString() {
        return frenchTranslation;
    }
}
