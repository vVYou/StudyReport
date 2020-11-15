package studyreport;

import studyreport.bristol.BristolAnswer;

public enum YES_NO implements BristolAnswer {
	YES(1, "oui"),
	NO(0, "non");

	private final int formValue;
	private final String frenchTranslation;

	YES_NO(int formValue, String frenchTranslation) {
		this.formValue = formValue;
		this.frenchTranslation = frenchTranslation;
	}

	@Override
	public int getFormValue() {
		return formValue;
	}

	public boolean isYes() {
		return YES == this;
	}

	public static YES_NO toEnum(int formValue) {
		for (YES_NO value : values()) {
			if (value.getFormValue() == formValue) {
				return value;
			}
		}
		return NO;
	}

	@Override
	public String toReport() {
		return frenchTranslation;
	}
}
