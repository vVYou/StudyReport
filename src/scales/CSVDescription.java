package scales;

import scales.answers.BP2;
import scales.answers.GH1;
import scales.answers.MH3;
import scales.answers.MH4;
import scales.answers.PF02;
import scales.answers.PF04;
import scales.answers.RE2;
import scales.answers.RE3;
import scales.answers.RP2;
import scales.answers.RP3;
import scales.answers.SF2;
import scales.answers.VT2;

public enum CSVDescription {
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
	Class<? extends Answer> answer;

	CSVDescription(int columnIndex, Class<? extends Answer> answer) {
		this.columnIndex = columnIndex;
		this.answer = answer;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public Class<? extends Answer> getAnswer() {
		return answer;
	}
}
