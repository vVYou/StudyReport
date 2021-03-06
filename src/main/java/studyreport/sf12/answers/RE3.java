package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum RE3 implements SF12Answer<RE3> {
	RE3_1("2.32091", "-5.69921", 1),
	RE3_2("0", "0", 2);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	RE3(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(RE3 enumValue) {
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
