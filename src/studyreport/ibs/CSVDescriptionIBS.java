package studyreport.ibs;

public enum CSVDescriptionIBS {
	STUDY_ID(0),
	IBS_SSS_1A(1),
	IBS_SSS_1B(2),
	IBS_SSS_1C(3),
	IBS_SSS_2A(4),
	IBS_SSS_2B(5),
	IBS_SSS_3(6),
	IBS_SSS_4(7);

	int columnIndex;

	CSVDescriptionIBS(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

}
