package interview;

public class Interview_16_18_Pattern_Matching {
	public boolean patternMatching(String pattern, String value) {
		int vLength = value.length();
		int pLength = pattern.length();

		/*-- value.length == 0 --*/
		if (vLength == 0) {
			if (pLength != 0) {
				// 全为a || 全为b
				for (int i = 1; i < pLength; i++) {
					if (pattern.charAt(i - 1) != pattern.charAt(i)) {
						return false;
					}
				}
			}
			return true;
		}

		/*-- pattern.length == 0 || 1 --*/
		if (pLength == 0)
			return false;
		if (pLength == 1)
			return true;

		char a = pattern.charAt(0);
		int aCount = 0, bCount = 0;
		for (int i = 0; i < pLength; i++) {
			if (pattern.charAt(i) == a)
				aCount++;
			else
				bCount++;
		}

		/*--  pattern = a*  --*/
		if (bCount == 0) {
			if (vLength % aCount != 0)
				return false;
			int aLength = vLength / aCount;
			String aString = value.substring(0, aLength);
			for (int i = aString.length(); i < vLength; i += aString.length()) {
				if (!value.substring(i, i + aLength).equals(aString))
					return false;
			}
			return true;
		}

		for (int aLength = 0; aLength * aCount <= vLength; aLength++) {
			// vLength = aLength * aCount + bLength * bCount
			if ((vLength - aCount * aLength) % bCount != 0)
				continue;

			int bLength = (vLength - aCount * aLength) / bCount;
			boolean match = true;
			int ci = 0;
			String aString = "", bString = "";
			for (char c : pattern.toCharArray()) {
				if (c == a) {
					String cur_a = value.substring(ci, ci += aLength);

					// 第一次进入 || a = “”
					if (aString.length() == 0) {
						aString = cur_a;
					} else if (!aString.equals(cur_a)) {
						match = false;
						break;
					}
				} else {
					String cur_b = value.substring(ci, ci += bLength);

					if (bString.length() == 0) {
						bString = cur_b;
					} else if (!bString.equals(cur_b)) {
						match = false;
						break;
					}
				}
			}
			if (match && !aString.equals(bString))
				return true;
		}
		return false;
	}
}
