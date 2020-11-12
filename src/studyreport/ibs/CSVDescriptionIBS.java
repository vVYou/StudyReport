package studyreport.ibs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import studyreport.sf12.AnswerSF12;

public enum CSVDescriptionIBS {
	STUDY_ID(0, null);

	int columnIndex;
	Class<? extends AnswerSF12> answer;

	CSVDescriptionIBS(int columnIndex, Class<? extends AnswerSF12> answer) {
		this.columnIndex = columnIndex;
		this.answer = answer;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public Class<? extends AnswerSF12> getAnswer() {
		return answer;
	}

	public static List<CSVDescriptionIBS> getAllAnswerColumns() {
		return Arrays.stream(values())
				.filter(desc -> desc.getAnswer() != null)
				.collect(Collectors.toList());
	}
}
