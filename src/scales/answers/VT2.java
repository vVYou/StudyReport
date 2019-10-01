package scales.answers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import scales.Answer;
import scales.FormValue;
import scales.MentalWeight;
import scales.PhysicalWeight;

public enum VT2 implements Answer<VT2> {
	VT2_1("-7.23216", "3.93115", 1),
	VT2_2("-7.23216", "3.93115", 2),
	VT2_3("-7.23216", "3.93115", 3),
	VT2_4("-7.23216", "3.93115", 4),
	VT2_5("-7.23216", "3.93115", 5);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	VT2(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(VT2 enumValue) {
		return enumValue.getFormValue();
	}

	@Override
	public Optional<VT2> toEnumValue(int formValue) {
		return Arrays.stream(values())
				.filter(value -> value.getFormValue() == formValue)
				.findFirst();
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
