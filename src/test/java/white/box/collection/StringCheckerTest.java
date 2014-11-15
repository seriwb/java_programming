package white.box.collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class StringCheckerTest {

//	@Test
	public void tryIsSortedString() {
		String hoge = "asdbc";
		String[] hoges = hoge.split("");
		for (String s : hoges) {
			System.out.println(s);
		}
	}

	@Test
	public void testIsSortedString() {
		StringChecker checker = new StringChecker();
		assertThat(checker.isSortedString("hoge", "hogehoge"), is(false));
		assertThat(checker.isSortedString("foobar12", "fizzbazz"), is(false));
		assertThat(checker.isSortedString("hoge", "geho"), is(true));
		assertThat(checker.isSortedString("hoge", "hoge"), is(true));
		assertThat(checker.isSortedString("hoge", null), is(false));
		assertThat(checker.isSortedString("", "hoge"), is(false));
		assertThat(checker.isSortedString("", ""), is(false));
		assertThat(checker.isSortedString("あいうえお", "おえういあ"), is(true));
		assertThat(checker.isSortedString("アイアン", "メイデン"), is(false));
	}
}
