package studyreport.had;

import org.apache.commons.csv.CSVFormat;

public enum CSVDescriptionHAD {
	numero_d_identification(0, false),
	had_1(1, true),
	had_2(2, false),
	had_3(3, true),
	had_4(4, false),
	had_5(5, true),
	had_6(6, true),
	had_7(7, false),
	had_8(8, true),
	had_9(9, false),
	had_10(10, true),
	had_11(11, true),
	had_12(12, false),
	had_13(13, true),
	had_14(14, false);

	int columnIndex;
	boolean isReverseWeight;

	CSVDescriptionHAD(int columnIndex, boolean isReverseWeight) {
		this.columnIndex = columnIndex;
		this.isReverseWeight = isReverseWeight;
	}

	public static CSVFormat getFormat() {
		return CSVFormat.DEFAULT
				.withHeader(CSVDescriptionHAD.class)
				.withFirstRecordAsHeader();
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public boolean isReverseWeight() {
		return isReverseWeight;
	}
}
