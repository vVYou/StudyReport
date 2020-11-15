package studyreport.sf12;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record SF12(BigDecimal sf12m, BigDecimal sf12p) {

	public int sf12mToReport() {
		return sf12m.setScale(0, RoundingMode.HALF_UP).intValue();
	}

	public int sf12pToReport() {
		return sf12p.setScale(0, RoundingMode.HALF_UP).intValue();
	}

}
