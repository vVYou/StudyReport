package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum RP3 implements SF12Answer<RP3> {
	RP3_1("-5.51747", "1.66968", 1),
	RP3_2("0", "0", 2);

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
	public BigDecimal getMentalWeight() {
		return mentalWeight;
	}

	@Override
	public BigDecimal getPhysicalWeight() {
		return physicalWeight;
	}
}
