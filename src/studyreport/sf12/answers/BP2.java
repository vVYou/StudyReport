package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum BP2 implements Answer<BP2> {
	BP2_1("-11.25544", "1.48619", 1),
	BP2_2("-8.38063", "1.76691", 2),
	BP2_3("-6.50522", "1.49384", 3),
	BP2_4("-3.80130", "0.90384", 4);

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
