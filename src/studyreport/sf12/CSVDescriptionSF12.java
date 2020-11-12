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
	SF12_FU12_DATE(1, null),
	SF12_FU12_1(2, GH1.class),
	SF12_FU12_2_A(3, PF02.class),
	SF12_FU12_2_B(4, PF04.class),
	SF12_FU12_3_A(5, RP2.class),
	SF12_FU12_3_B(6, RP3.class),
	SF12_FU12_4_A(7, RE2.class),
	SF12_FU12_4_B(8, RE3.class),
	SF12_FU12_5(9, BP2.class),
	SF12_FU12_6_A(10, MH3.class),
	SF12_FU12_6_B(11, VT2.class),
	SF12_FU12_6_C(12, MH4.class),
	SF12_FU12_7(13, SF2.class),
	SF12_FU12_MOIS_COMPLETE(14, null);

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
