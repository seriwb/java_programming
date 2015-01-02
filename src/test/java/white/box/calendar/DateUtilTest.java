package white.box.calendar;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


/**
 * DateUtilのテストケース
 * 
 * @author seri
 */
public class DateUtilTest {

	/**
	 * 日付のフォーマットによる出力の違いを確認する
	 */
	@Test
	public void yyyyとYYYYの出力の違いを確認() {
		// 問題が発生する日付を取得
		Date date = DateUtil.createDate("20141228");
		
		SimpleDateFormat formatSY = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatLY = new SimpleDateFormat("YYYYMMdd");
		assertThat(formatSY.format(date), is("20141228"));
		assertThat(formatLY.format(date), is("20151228"));
		
		// ■暦週は月曜始まりなのに日曜から2015年になっている理由の確認
		Calendar cl = formatLY.getCalendar();
		
		// 暦週をサポートしているかを確認
		assertThat(cl.isWeekDateSupported(), is(true));
		// ロケールが日本の場合の週の始まりは日曜日⇒だから28日から2015年になっている
		assertThat(cl.getFirstDayOfWeek(), is(Calendar.SUNDAY));
	}
	
	/**
	 * createDateの動作確認用コード
	 */
	public void testCreateDate() {
		System.out.println(DateUtil.createDate("20141228"));
	}
	
	/**
	 * 正規表現確認用コード
	 */
	public void 日付形式を正規表現でチェックするときの確認() {
		assertThat("2014".matches("\\d4"), is(false));
		assertThat("2014".substring(0, 4).matches("\\d{4}"), is(true));
		assertThat("930".matches("\\d{4}"), is(false));
		assertThat("930".matches("\\d{1,4}"), is(true));
		assertThat("2014".matches("\\d{1,4}"), is(true));
		assertThat("0".matches("\\d{1,4}"), is(true));
		assertThat("99999".matches("\\d{1,4}"), is(false));
		assertThat("31".matches("[0-3][0-9]"), is(true));
		assertThat("201511".matches("\\d{1,4}[0-1]{0,1}\\d"), is(true));
		assertThat("20151231".matches("\\d{8}"), is(true));
	}

}
