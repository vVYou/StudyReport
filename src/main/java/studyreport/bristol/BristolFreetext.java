package studyreport.bristol;

public class BristolFreetext implements BristolAnswer {

    private String freeText;

    public BristolFreetext(String freeText) {
        this.freeText = freeText;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }


    @Override
    public int getFormValue() {
        return 0;
    }

    @Override
    public String toReport() {
        return freeText;
    }
}
