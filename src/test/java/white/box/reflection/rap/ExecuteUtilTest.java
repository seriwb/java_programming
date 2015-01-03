package white.box.reflection.rap;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/**
 * ExecuteUtilのテストケース
 * 
 * @author seri
 */
public class ExecuteUtilTest {

	@Test
	public void test() {
		SomeTableNameInput input = new SomeTableNameInput();
		input.setSearchWord("sampleData");
		
		SomeTableNameOutput output =
				(SomeTableNameOutput) ExecuteUtil.search(input);

		assertNotNull(output);
		assertThat(output.getResult(), is("OK"));
	}

}
