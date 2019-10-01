package scales.answers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import scales.Answer;
import scales.FormValue;
import scales.MentalWeight;
import scales.PhysicalWeight;

public enum RP3 implements Answer<RP3> {
	RP3_1("-7.23216", "3.93115", 1);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	RP3(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(RP3 enumValue) {
		return enumValue.getFormValue();
	}

	@Override
	public Optional<RP3> toEnumValue(int formValue) {
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
