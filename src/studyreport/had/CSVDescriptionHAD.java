package studyreport.had;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import studyreport.sf12.AnswerSF12;

public enum CSVDescriptionHAD {
	STUDY_ID(0, null);

	int columnIndex;
	Class<? extends AnswerSF12> answer;

	CSVDescriptionHAD(int columnIndex, Class<? extends AnswerSF12> answer) {
		this.columnIndex = columnIndex;
		this.answer = answer;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public Class<? extends AnswerSF12> getAnswer() {
		return answer;
	}

	public static List<CSVDescriptionHAD> getAllAnswerColumns() {
		return Arrays.stream(values())
				.filter(desc -> desc.getAnswer() != null)
				.collect(Collectors.toList());
	}
}
