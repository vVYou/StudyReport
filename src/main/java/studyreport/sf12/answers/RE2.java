package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum RE2 implements SF12Answer<RE2> {
	RE2_1("3.04365", "-6.82672", 1),
	RE2_2("0", "0", 2);

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
