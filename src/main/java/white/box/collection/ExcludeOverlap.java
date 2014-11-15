package white.box.collection;

import java.util.HashSet;
import java.util.Set;

public class ExcludeOverlap {

	/**
	 * 入力パラメータの文字列に重複文字があるかを検査する。 
	 * 重複があればtrue、なければfalseを返す。
	 * null、空文字を渡した場合はfalseを返す。
	 * 
	 * @param str 重複をチェックする文字列
	 * @return 重複があればtrueを返す
	 */
	public boolean isOverlapExist(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		char c[] = str.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0, limit = c.length; i < limit; i++) {
			if (charSet.contains(c[i])) {
				return true;
			}
			charSet.add(c[i]);
		}
		return false;
	}
}
