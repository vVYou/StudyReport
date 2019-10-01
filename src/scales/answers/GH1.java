package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum GH1 implements Answer<GH1> {
	GH1_1("-7.23216", "3.93115", 1),
	GH1_2("-7.23216", "3.93115", 2),
	GH1_3("-7.23216", "3.93115", 3),
	GH1_4("-7.23216", "3.93115", 4);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	GH1(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(GH1 enumValue) {
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
