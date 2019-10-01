package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum PF04 implements Answer<PF04> {
	PF04_1("-7.23216", "3.93115", 1),
	PF04_2("-3.45555", "1.86840", 2);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	PF04(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(PF04 enumValue) {
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
