package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum MH3 implements Answer<MH3> {
	MH3_1("-7.23216", "3.93115", 1),
	MH3_2("-7.23216", "3.93115", 2),
	MH3_3("-7.23216", "3.93115", 3),
	MH3_4("-7.23216", "3.93115", 4),
	MH3_5("-7.23216", "3.93115", 5);

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
