package studyreport.bristol;

import java.util.SortedMap;

public class Bristol {
    private SortedMap<BristolCSVDescription, BristolAnswer> bristolAnswerMap;

    public Bristol(SortedMap<BristolCSVDescription, BristolAnswer> bristolAnswerMap) {
        this.bristolAnswerMap = bristolAnswerMap;
    }

    public SortedMap<BristolCSVDescription, BristolAnswer> getBristolAnswerMap() {
        return bristolAnswerMap;
    }

    public void setBristolAnswerMap(SortedMap<BristolCSVDescription, BristolAnswer> bristolAnswerMap) {
        this.bristolAnswerMap = bristolAnswerMap;
    }
}
