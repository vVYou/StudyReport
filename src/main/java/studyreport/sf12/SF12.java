package studyreport.sf12;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SF12 {
    private final BigDecimal sf12m;
    private final BigDecimal sf12p;
    private final boolean error;

    public SF12(BigDecimal sf12m, BigDecimal sf12p, boolean error) {
        this.sf12m = sf12m;
        this.sf12p = sf12p;
        this.error = error;
    }

    public BigDecimal getSf12m() {
        return sf12m;
    }

    public BigDecimal getSf12p() {
        return sf12p;
    }


    public String sf12mToReport() {
        if (error) {
            return "DONNEES MANQUANTES SF12";
        } else {
            return "" + sf12m.setScale(0, RoundingMode.HALF_UP).intValue();
        }
    }

    public String sf12pToReport() {
        if (error) {
            return "DONNEES MANQUANTES SF12";
        } else {
            return "" + sf12p.setScale(0, RoundingMode.HALF_UP).intValue();
        }
    }

}
