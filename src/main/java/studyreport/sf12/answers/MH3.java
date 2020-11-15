package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum MH3 implements SF12Answer<MH3> {
	MH3_1("0", "0", 1),
	MH3_2("0.66514", "-1.94949", 2),
	MH3_3("1.36689", "-4.09842", 3),
	MH3_4("2.37241", "-6.31121", 4),
	MH3_5("2.90426", "-7.92717", 5),
	MH3_6("3.46638", "-10.19085", 6);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	MH3(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(MH3 enumValue) {
		return enumValue.getFormValue();
	}

	@Override
	public BigDecimal getMentalWeight() {
		return mentalWeight;
	}

	@Override
	public BigDecimal getPhysicalWeight() {
		return physicalWeight;
	}
}
