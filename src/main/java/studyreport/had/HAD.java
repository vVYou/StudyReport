package studyreport.had;

public class HAD {
	private final int a;
	private final int d;
	private final boolean error;

	public HAD(int a, int d, boolean error) {
		this.a = a;
		this.d = d;
		this.error = error;
	}

	public int getA() {
		return a;
	}

	public int getD() {
		return d;
	}

	public boolean isError() {
		return error;
	}
}
