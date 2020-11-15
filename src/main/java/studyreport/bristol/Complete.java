package studyreport.bristol;

public enum Complete implements BristolAnswer {
    INCOMPLETE(0),
    UNVERIFIED(1),
    COMPLETE(2);

    private final int answer;

    Complete(int answer) {
        this.answer = answer;
    }
}
