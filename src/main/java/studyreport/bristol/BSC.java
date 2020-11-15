package studyreport.bristol;

public enum BSC implements BristolAnswer {
    TYPE_1(1),
    TYPE_2(2),
    TYPE_3(3),
    TYPE_4(4),
    TYPE_5(5),
    TYPE_6(6),
    TYPE_7(7);

    private final int formValue;

    BSC(int formValue) {
        this.formValue = formValue;
    }

    @Override
    public int getFormValue() {
        return formValue;
    }

}
