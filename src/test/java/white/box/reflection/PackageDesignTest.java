package white.box.reflection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/**
 * PackageDesignのテストケース
 * 
 * @author seri
 */
public class PackageDesignTest {

	/**
	 * getPackageStringのテスト<br>
	 * <ul>
	 * <li>クラスのパッケージ名を取得できること
	 * <li>空文字を渡してもStringのパッケージ名が取得できること
	 * <li>nullを渡したとき、空文字が取得できること
	 * </ul>
	 */
	@Test
	public void testGetPackageString() {
		PackageDesign pd = new PackageDesign();
		assertThat(pd.getPackageString(pd), is("white.box.reflection"));
		assertThat(pd.getPackageString(""), is("java.lang"));
		assertThat(pd.getPackageString(null), is(""));
	}

}
