package studyreport;

import java.util.Objects;

import studyreport.had.HAD;
import studyreport.ibs.IBS;
import studyreport.sf12.SF12;

public class StudyCase {

	private final String studyID;
	private IBS ibs;
	private SF12 sf12;
	private HAD had;

	//TODO add fodmaps

	public StudyCase(String studyID) {
		this.studyID = studyID;
	}

	public String getStudyID() {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudyCase studyCase = (StudyCase) o;
		return studyID.equals(studyCase.studyID);
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
