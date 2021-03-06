package studyreport.ibs;

public enum YES_NO {
	YES(1),
	NO(0);

	private final int formValue;

	YES_NO(int formValue) {
		this.formValue = formValue;
	}

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

}
