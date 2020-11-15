package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum PF02 implements SF12Answer<PF02> {
	PF02_1("-7.23216", "3.93115", 1),
	PF02_2("-3.45555", "1.86840", 2),
	PF02_3("0", "0", 3);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	PF02(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(PF02 enumValue) {
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
