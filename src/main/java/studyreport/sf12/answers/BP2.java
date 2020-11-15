package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum BP2 implements SF12Answer<BP2> {
	BP2_1("0", "0", 1),
	BP2_2("-3.80130", "0.90384", 2),
	BP2_3("-6.50522", "1.49384", 3),
	BP2_4("-8.38063", "1.76691", 4),
	BP2_5("-11.25544", "1.48619", 5);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	BP2(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(BP2 enumValue) {
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
