package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum GH1 implements SF12Answer<GH1> {
	GH1_1("0", "0", 1),
	GH1_2("-1.31872", "-0.06064", 2),
	GH1_3("-3.02396", "0.03482", 3),
	GH1_4("-5.56461", "-0.16891", 4),
	GH1_5("-8.37399", "-1.71175", 5);

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
