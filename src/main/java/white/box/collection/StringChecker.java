package white.box.collection;

import java.util.Arrays;

public class StringChecker {

	private static final boolean testFlag = false;

	/**
	 * 入力パラメータの文字列が、片方の並び替えであるかをチェックする。 
	 * 並び替えであればtrue、そうでなければfalseを返す。
	 * 同じ文字列は並び替えであるとし、trueを返す。 
	 * 入力パラメータにnullまたは空文字が含まれていた場合、falseを返す。
	 */
	public boolean isSortedString(String somestr, String otherstr) {
		if (somestr == null || somestr.length() == 0 ||
				otherstr == null || otherstr.length() == 0) {
			return false;
		}
		// 同じサイズでなければそもそも違う
		if (somestr.length() != otherstr.length()) {
			return false;
		}
		String[] sortedSomestr = somestr.split("");
		Arrays.sort(sortedSomestr);
		if (testFlag) {
			for (String s : sortedSomestr) {
				System.out.print(s);
			}
			System.out.print("\n");
		}

		String[] sortedOtherstr = otherstr.split("");
		Arrays.sort(sortedOtherstr);
		if (testFlag) {
			for (String s : sortedOtherstr) {
				System.out.print(s);
			}
			System.out.print("\n");
		}

		if (Arrays.equals(sortedSomestr, sortedOtherstr)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 文字数カウントで一致をチェック
	 * ※このコードはASCIIコードの文字でチェックすることを想定している。
	 */
	public boolean permuation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[256];	// 文字コードの仮定
		
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			// s中の文字の出現回数をカウント
			letters[c]++;
		}
		
		for (int i=0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
