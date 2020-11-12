package studyreport.sf12;

import static studyreport.Main.NOT_ENOUGH_DATA;
import static studyreport.sf12.SF12Calculation.MENTAL_WEIGHT_CONST;
import static studyreport.sf12.SF12Calculation.PHYSICAL_WEIGHT_CONST;

import java.math.BigDecimal;

public record SF12(BigDecimal sf12m, BigDecimal sf12p) {

	public String sf12pToReport() {
		return PHYSICAL_WEIGHT_CONST.equals(sf12p) ? NOT_ENOUGH_DATA : sf12p.toString();
	}

	public String sf12mToReport() {
		return MENTAL_WEIGHT_CONST.equals(sf12m) ? NOT_ENOUGH_DATA : sf12m.toString();
	}
	
}
