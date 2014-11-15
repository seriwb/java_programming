package white.box.collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ExcludeOverlapTest {

	@Test
	public void testIsOverlapExist() {
		ExcludeOverlap eo = new ExcludeOverlap();
		assertThat(eo.isOverlapExist(""), is(false));
		assertThat(eo.isOverlapExist("abcde"), is(false));
		assertThat(eo.isOverlapExist("abcda"), is(true));
	}

}
