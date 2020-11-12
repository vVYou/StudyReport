package studyreport.ibs;

public enum YES_NO {
	YES(1),
	NO(2);

	int formValue;

	YES_NO(int formValue) {
		this.formValue = formValue;
	}

	public int getFormValue() {
		return formValue;
	}

	public boolean isYes() {
		return YES == this;
	}
}
