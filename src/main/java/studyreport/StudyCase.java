package studyreport;

import java.util.ArrayList;
import java.util.Objects;

import studyreport.bristol.Bristol;
import studyreport.bristol.BristolAnswer;
import studyreport.had.HAD;
import studyreport.ibs.IBS;
import studyreport.sf12.SF12;

public class StudyCase {

    private final int studyID;
    private IBS ibs;
    private SF12 sf12;
    private HAD had;
    private Bristol bristol;

    public StudyCase(int studyID) {
        this.studyID = studyID;
    }

    public int getStudyID() {
        return studyID;
    }

    public IBS getIbs() {
        return ibs;
    }

    public void setIbs(IBS ibs) {
        this.ibs = ibs;
    }

    public SF12 getSf12() {
        return sf12;
    }

    public void setSf12(SF12 sf12) {
        this.sf12 = sf12;
    }

    public HAD getHad() {
        return had;
    }

    public void setHad(HAD had) {
        this.had = had;
    }

    public Bristol getBristol() {
        return bristol;
    }

    public void setBristol(Bristol bristol) {
        this.bristol = bristol;
    }

    public Object[] getReport() {
        ArrayList<Object> report = new ArrayList<>();
        report.add(getStudyID());
        report.add(getIbs() == null ? ScoreReport.NOT_ENOUGH_DATA : getIbs().score());
        report.add(getHad() == null || getHad().isError() ? ScoreReport.NOT_ENOUGH_DATA : getHad().getA());
        report.add(getHad() == null || getHad().isError() ? ScoreReport.NOT_ENOUGH_DATA : getHad().getD());
        report.add(getSf12() == null ? ScoreReport.NOT_ENOUGH_DATA : getSf12().sf12mToReport());
        report.add(getSf12() == null ? ScoreReport.NOT_ENOUGH_DATA : getSf12().sf12pToReport());
        if (getBristol() != null) {
            for (BristolAnswer answer : getBristol().getBristolAnswerMap().values()) {
                report.add(answer == null ? ScoreReport.NOT_ENOUGH_DATA : answer.toReport());
            }
        }
        return report.toArray();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudyCase studyCase = (StudyCase) o;
        return studyID == studyCase.studyID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studyID);
    }

    @Override
    public String toString() {
        return "StudyCase{" +
                "studyID='" + studyID + '\'' +
                ", ibs=" + ibs +
                ", sf12=" + sf12 +
                ", had=" + had +
                '}';
    }
}
