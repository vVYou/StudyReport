package scales.answers;

import java.math.BigDecimal;

import scales.Answer;

public enum SF2 implements Answer<SF2> {
	SF2_1("-0.33682", "-6.29724", 1),
	SF2_2("-0.94342", "-8.26066", 2),
	SF2_3("-0.18043", "-5.63286", 3),
	SF2_4("0.11038", "-3.13896", 4);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	SF2(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(SF2 enumValue) {
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
