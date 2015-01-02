package white.box.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Dateのユーティリティクラス
 * 
 * @author seri
 */
public class DateUtil {

	/**
	 * パラメータで指定された日付のDateを返す。
	 * 
	 * @param yyyyMMdd Dateとして作成する日付をyyyyMMddの形式で指定する
	 * @return yyyyMMddにフォーマットされたDate
	 */
	public static Date createDate(String yyyyMMdd) {
		
		// 入力値不正のメッセージ
		String inputErrorMessage = "日付をyyyyMMddで入力してください";
		
		if (!Objects.requireNonNull(yyyyMMdd, inputErrorMessage).matches("\\d{8}")) {
			throw new IllegalArgumentException(inputErrorMessage);
		}
		
		int year = Integer.parseInt(yyyyMMdd.substring(0, 4));
		int month = Integer.parseInt(yyyyMMdd.substring(4, 6));
		int day = Integer.parseInt(yyyyMMdd.substring(6, 8));
		// 日付の範囲チェック
		if (year < 0 || !checkRange(month, 1, 12) || !checkRange(day, 1, 31)) {
			throw new IllegalArgumentException("日付の範囲が間違っています");
		}
		
		Calendar cl = Calendar.getInstance();
		cl.set(year, month-1, day, 0, 0, 0);	// 月は0からカウントなのを忘れないこと
		return cl.getTime();
	}
	
	/**
	 * 数値が範囲内にあるかをチェックする（簡易版）
	 * 
	 * @param number チェックする数
	 * @param min 最小値
	 * @param max 最大値
	 * @return 範囲に収まっていればtrue, そうでなければfalse
	 */
	private static boolean checkRange(int number, int min, int max) {
		if (number < min || number > max) {
			return false;
		} else {
			return true;
		}
	}
}
