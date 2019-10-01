package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum RE2 implements Answer<RE2> {
	RE2_1("-7.23216", "3.93115", 1);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	RE2(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(RE2 enumValue) {
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
