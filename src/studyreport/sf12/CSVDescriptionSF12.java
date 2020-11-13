package studyreport.sf12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;

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
	numero_d_identification(0, null),
	sf12_1_1(1, GH1.class),
	sf12_1_2_a(2, PF02.class),
	sf12_1_2_b(3, PF04.class),
	sf12_1_3_a(4, RP2.class),
	sf12_1_3_b(5, RP3.class),
	sf12_1_4_a(6, RE2.class),
	sf12_1_4_b(7, RE3.class),
	sf12_1_5(8, BP2.class),
	sf12_1_6_a(9, MH3.class),
	sf12_1_6_b(10, VT2.class),
	sf12_1_6_c(11, MH4.class),
	sf12_1_7(12, SF2.class);

	int columnIndex;
	Class<? extends AnswerSF12> answer;

	CSVDescriptionSF12(int columnIndex, Class<? extends AnswerSF12> answer) {
		this.columnIndex = columnIndex;
		this.answer = answer;
	}

	public static CSVFormat getFormat() {
		return CSVFormat.DEFAULT
				.withHeader(CSVDescriptionSF12.class)
				.withFirstRecordAsHeader();
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
