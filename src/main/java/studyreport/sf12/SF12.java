package studyreport.sf12;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SF12 {
	private final BigDecimal sf12m;
	private final BigDecimal sf12p;

	public SF12(BigDecimal sf12m, BigDecimal sf12p) {
		this.sf12m = sf12m;
		this.sf12p = sf12p;
	}

	public BigDecimal getSf12m() {
		return sf12m;
	}

	public BigDecimal getSf12p() {
		return sf12p;
	}

	public int sf12mToReport() {
		return sf12m.setScale(0, RoundingMode.HALF_UP).intValue();
	}

	public int sf12pToReport() {
		return sf12p.setScale(0, RoundingMode.HALF_UP).intValue();
	}

}
