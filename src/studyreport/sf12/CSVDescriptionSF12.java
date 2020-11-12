package studyreport.sf12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import studyreport.sf12.answers.BP2;
import studyreport.sf12.answers.GH1;
import studyreport.sf12.answers.MH3;
import studyreport.sf12.answers.MH4;
import studyreport.sf12.answers.PF02;
import studyreport.sf12.answers.PF04;
import studyreport.sf12.answers.RE2;
import studyreport.sf12.answers.RE3;
import studyreport.sf12.answers.RP2;
import studyreport.sf12.answers.RP3;
import studyreport.sf12.answers.SF2;
import studyreport.sf12.answers.VT2;

public enum CSVDescriptionSF12 {
	STUDY_ID(0, null),
	SF12_FU12_1(1, GH1.class),
	SF12_FU12_2_A(2, PF02.class),
	SF12_FU12_2_B(3, PF04.class),
	SF12_FU12_3_A(4, RP2.class),
	SF12_FU12_3_B(5, RP3.class),
	SF12_FU12_4_A(6, RE2.class),
	SF12_FU12_4_B(7, RE3.class),
	SF12_FU12_5(8, BP2.class),
	SF12_FU12_6_A(9, MH3.class),
	SF12_FU12_6_B(10, VT2.class),
	SF12_FU12_6_C(11, MH4.class),
	SF12_FU12_7(12, SF2.class);

	int columnIndex;
	Class<? extends AnswerSF12> answer;

	CSVDescriptionSF12(int columnIndex, Class<? extends AnswerSF12> answer) {
		this.columnIndex = columnIndex;
		this.answer = answer;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public Class<? extends AnswerSF12> getAnswer() {
		return answer;
	}

	public static List<CSVDescriptionSF12> getAllAnswerColumns() {
		return Arrays.stream(values())
				.filter(desc -> desc.getAnswer() != null)
				.collect(Collectors.toList());
	}
}
