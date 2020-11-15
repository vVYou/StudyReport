package studyreport.bristol;

import java.util.SortedMap;

public class Bristol {
    private SortedMap<CSVDescriptionBristol, BristolAnswer> bristolAnswerMap;

    public Bristol(SortedMap<CSVDescriptionBristol, BristolAnswer> bristolAnswerMap) {
        this.bristolAnswerMap = bristolAnswerMap;
    }

    public SortedMap<CSVDescriptionBristol, BristolAnswer> getBristolAnswerMap() {
        return bristolAnswerMap;
    }

    public void setBristolAnswerMap(SortedMap<CSVDescriptionBristol, BristolAnswer> bristolAnswerMap) {
        this.bristolAnswerMap = bristolAnswerMap;
    }
}
