package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum BP2 implements Answer<BP2> {
	BP2_1("-7.23216", "3.93115", 1),
	BP2_2("-7.23216", "3.93115", 2),
	BP2_3("-7.23216", "3.93115", 3),
	BP2_4("-7.23216", "3.93115", 4);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	BP2(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(BP2 enumValue) {
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
