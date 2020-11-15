package studyreport.bristol;

public enum Complete implements BristolAnswer {
    INCOMPLETE(0),
    UNVERIFIED(1),
    COMPLETE(2);

    private final int formValue;

    Complete(int formValue) {
        this.formValue = formValue;
    }

    @Override
    public int getFormValue() {
        return formValue;
    }
}
