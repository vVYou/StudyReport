package studyreport.bristol;

public enum Symptomes implements BristolAnswer {
    NONE(0),
    VERY_FEW(1),
    FEW(2),
    MODERATE(3),
    SEVERE(4),
    VERY_SERVERE(5);


    private final int answer;

    Symptomes(int answer) {
        this.answer = answer;
    }
}
