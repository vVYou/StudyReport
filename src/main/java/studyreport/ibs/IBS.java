package studyreport.ibs;

public class IBS {
	private final boolean ibs1a;
	private final int ibs1b;
	private final int ibs1c;
	private final boolean ibs2a;
	private final int ibs2b;
	private final int ibs3;
	private final int ibs4;

	private IBS(Builder builder) {
		ibs1a = builder.ibs1a;
		ibs1b = builder.ibs1b;
		ibs1c = builder.ibs1c;
		ibs2a = builder.ibs2a;
		ibs2b = builder.ibs2b;
		ibs3 = builder.ibs3;
		ibs4 = builder.ibs4;

	}

	public int score() {
		int score = 0;
		if (ibs1a) {
			score += ibs1b * 10;
		}
		score += ibs1c * 10;
		if (ibs2a) {
			score += ibs2b * 10;
		}
		score += ibs3 * 10;
		score += ibs4 * 10;
		return score;
	}

	@Override
	public String toString() {
		return "IBS = " + score();
	}

	public static class Builder {
		private boolean ibs1a;
		private int ibs1b;
		private int ibs1c;
		private boolean ibs2a;
		private int ibs2b;
		private int ibs3;
		private int ibs4;

		private Builder() {

		}

		public static Builder anIBS() {
			return new Builder();
		}

		public Builder withIbs1a(boolean ibs1a) {
			this.ibs1a = ibs1a;
			return this;
		}

		public Builder withIbs1b(int ibs1b) {
			this.ibs1b = ibs1b;
			return this;
		}

		public Builder withIbs1c(int ibs1c) {
			this.ibs1c = ibs1c;
			return this;
		}

		public Builder withIbs2a(boolean ibs2a) {
			this.ibs2a = ibs2a;
			return this;
		}

		public Builder withIbs2b(int ibs2b) {
			this.ibs2b = ibs2b;
			return this;
		}

		public Builder withIbs3(int ibs3) {
			this.ibs3 = ibs3;
			return this;
		}

		public Builder withIbs4(int ibs4) {
			this.ibs4 = ibs4;
			return this;
		}

		public IBS build() {
			return new IBS(this);
		}
	}
}
