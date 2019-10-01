package scales.answers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import scales.Answer;
import scales.FormValue;
import scales.MentalWeight;
import scales.PhysicalWeight;

public enum MH4 implements Answer<MH4> {
	MH4_1("-7.23216", "3.93115", 1),
	MH4_2("-7.23216", "3.93115", 2),
	MH4_3("-7.23216", "3.93115", 3),
	MH4_4("-7.23216", "3.93115", 4),
	MH4_5("-7.23216", "3.93115", 5);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	MH4(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(MH4 enumValue) {
		return enumValue.getFormValue();
	}

	@Override
	public Optional<MH4> toEnumValue(int formValue) {
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
