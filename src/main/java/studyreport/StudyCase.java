package studyreport;

import java.util.ArrayList;
import java.util.Objects;

import studyreport.had.HAD;
import studyreport.ibs.IBS;
import studyreport.sf12.SF12;

public class StudyCase {

	private final int studyID;
	private IBS ibs;
	private SF12 sf12;
	private HAD had;

	//TODO add fodmaps

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

	public Object[] getReport() {
		ArrayList<Object> report = new ArrayList<>();
		report.add(getStudyID());
		report.add(getIbs() == null ? Main.NOT_ENOUGH_DATA : getIbs().score());
		report.add(getHad() == null ? Main.NOT_ENOUGH_DATA : getHad().a());
		report.add(getHad() == null ? Main.NOT_ENOUGH_DATA : getHad().d());
		report.add(getSf12() == null ? Main.NOT_ENOUGH_DATA : getSf12().sf12mToReport());
		report.add(getSf12() == null ? Main.NOT_ENOUGH_DATA : getSf12().sf12pToReport());
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
