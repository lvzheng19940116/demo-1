package ad.util;

import java.text.NumberFormat;

public class IdUtil {

	public static String setIdNf(String type, int idKey) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		Integer lh = null;
		Integer computKey = null;
		String idkeyStr = String.valueOf(idKey);
		int idkSize = idkeyStr.length();
		if (idkSize <= 8 && idKey < 99999999) {
			lh = 8;
			computKey = idKey + 1;
		} else if (idkSize <= 8 && idKey == 99999999) {
			computKey = idKey + 1;
			String valueOf = String.valueOf(computKey);
			lh = valueOf.length();
		} else {
			computKey = idKey + 1;
			String valueOf = String.valueOf(computKey);
			lh = valueOf.length();
		}
		nf.setMaximumIntegerDigits(11);
		nf.setMinimumIntegerDigits(lh);
		return type + nf.format(computKey);
	}
}
