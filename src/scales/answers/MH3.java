package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum MH3 implements Answer<MH3> {
	MH3_1("3.46638", "-10.19085", 1),
	MH3_2("2.90426", "-7.92717", 2),
	MH3_3("2.37241", "-6.31121", 3),
	MH3_4("1.36689", "-4.09842", 4),
	MH3_5("0.66514", "-1.94949", 5);

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
