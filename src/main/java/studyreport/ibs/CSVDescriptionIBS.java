package studyreport.ibs;

public enum CSVDescriptionIBS {
	numero_d_identification(0),
	ibs_sss_1_a(1),
	ibs_sss_1_b(2),
	ibs_sss_1_c(3),
	ibs_sss_2_a(4),
	ibs_sss_2_b(5),
	ibs_sss_3(6),
	ibs_sss_4(7);

	int columnId;

	CSVDescriptionIBS(int columnId) {
		this.columnId = columnId;
	}

	public int getColumnId() {
		return columnId;
	}

}
