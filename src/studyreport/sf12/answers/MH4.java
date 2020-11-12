package studyreport.sf12.answers;

import java.math.BigDecimal;

import studyreport.sf12.AnswerSF12;

public enum MH4 implements AnswerSF12<MH4> {
	MH4_1("4.61446", "-16.15395", 1),
	MH4_2("3.41593", "-10.77911", 2),
	MH4_3("2.234247", "-8.09914", 3),
	MH4_4("1.28044", "-4.59055", 4),
	MH4_5("0.41188", "-1.95934", 5);

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
	public BigDecimal getMentalWeight() {
		return mentalWeight;
	}

	@Override
	public BigDecimal getPhysicalWeight() {
		return physicalWeight;
	}
}
