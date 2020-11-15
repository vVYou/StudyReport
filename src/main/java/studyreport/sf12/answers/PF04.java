package studyreport.sf12.answers;

import studyreport.sf12.SF12Answer;

import java.math.BigDecimal;

public enum PF04 implements SF12Answer<PF04> {
	PF04_1("-6.24397", "2.68282", 1),
	PF04_2("-2.73557", "1.43103", 2),
	PF04_3("0", "0", 3);

	BigDecimal physicalWeight;
	BigDecimal mentalWeight;
	int formValue;

	PF04(String physicalWeight, String mentalWeight, int formValue) {
		this.mentalWeight = new BigDecimal(mentalWeight);
		this.physicalWeight = new BigDecimal(physicalWeight);
		this.formValue = formValue;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	@Override
	public int toFormValue(PF04 enumValue) {
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
