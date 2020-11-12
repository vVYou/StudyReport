package studyreport.sf12.answers;

import java.math.BigDecimal;

import studyreport.sf12.AnswerSF12;

public enum GH1 implements AnswerSF12<GH1> {
	GH1_1("-8.37399", "-1.71175", 1),
	GH1_2("-5.56461", "-0.16891", 2),
	GH1_3("-3.02396", "0.03482", 3),
	GH1_4("-1.31872", "-0.06064", 4);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	GH1(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(GH1 enumValue) {
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
