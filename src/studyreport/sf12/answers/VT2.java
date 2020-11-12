package studyreport.sf12.answers;

import java.math.BigDecimal;

import studyreport.sf12.AnswerSF12;

public enum VT2 implements AnswerSF12<VT2> {
	VT2_1("0", "0", 1),
	VT2_2("-0.42251", "-0.92057", 2),
	VT2_3("-1.14387", "-1.65178", 3),
	VT2_4("-1.61850", "-3.29805", 4),
	VT2_5("-2.02168", "-4.88962", 5),
	VT2_6("-2.44706", "-6.02409", 6);

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
	public BigDecimal getMentalWeight() {
		return mentalWeight;
	}

	@Override
	public BigDecimal getPhysicalWeight() {
		return physicalWeight;
	}
}
