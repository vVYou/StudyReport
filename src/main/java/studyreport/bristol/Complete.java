package studyreport.bristol;

public enum Complete implements BristolAnswer {
    INCOMPLETE(0, "incomplète"),
    UNVERIFIED(1, "non vérifiée"),
    COMPLETE(2, "complète");

    private final int formValue;
    private final String frenchTranslation;

    Complete(int formValue, String frenchTranslation) {
        this.formValue = formValue;
        this.frenchTranslation = frenchTranslation;
    }

    @Override
    public int getFormValue() {
        return formValue;
    }

    @Override
    public String toReport() {
        return frenchTranslation;
    }
}
