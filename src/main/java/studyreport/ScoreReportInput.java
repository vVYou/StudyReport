package studyreport;

import java.io.File;

public class ScoreReportInput {

	private final File ibsInput;
	private final File hadInput;
	private final File sf12Input;
	private final File extraInput;
	private final File outputFile;

	private ScoreReportInput(Builder builder) {
		ibsInput = builder.ibsInput;
		hadInput = builder.hadInput;
		sf12Input = builder.sf12Input;
		extraInput = builder.extraInput;
		outputFile = builder.outputFile;
	}

	public File getIbsInput() {
		return ibsInput;
	}

	public File getHadInput() {
		return hadInput;
	}

	public File getSf12Input() {
		return sf12Input;
	}

	public File getExtraInput() {
		return extraInput;
	}

	public File getOutputFile() {
		return outputFile;
	}

	public static class Builder {
		private File ibsInput;
		private File hadInput;
		private File sf12Input;
		private File extraInput;
		private File outputFile;

		private Builder() {

		}

		public static Builder aScoreReportInput() {
			return new Builder();
		}

		public Builder withIbsInput(File ibsInput) {
			this.ibsInput = ibsInput;
			return this;
		}

		public Builder withHadInput(File hadInput) {
			this.hadInput = hadInput;
			return this;
		}

		public Builder withSf12Input(File sf12Input) {
			this.sf12Input = sf12Input;
			return this;
		}

		public Builder withExtraInput(File extraInput) {
			this.extraInput = extraInput;
			return this;
		}

		public Builder withOutputFile(File outputFile) {
			this.outputFile = outputFile;
			return this;
		}

		public ScoreReportInput build() {
			return new ScoreReportInput(this);
		}
	}
}
