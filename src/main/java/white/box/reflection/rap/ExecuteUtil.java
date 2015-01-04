package white.box.reflection.rap;

import java.lang.reflect.Method;

/**
 * 特定のメソッドの実行を助けるユーティリティクラス
 * 
 * @author seri
 */
public class ExecuteUtil {

	private static final String SPLIST_KEY = "Input";
	private static final String ADD_OUTPUT_CLASS_NAME = "Output";

	public static DefaultOutput search(DefaultInput input) {

		CommonDao dao = new CommonDao();

		// 共通の文字列を取得（inputの先頭文字を取得して利用する）
		String tablename = input.getClass().getSimpleName().split(SPLIST_KEY)[0];

		try {
			@SuppressWarnings("unchecked")
			Class<? extends DefaultOutput> outputclazz = (Class<? extends DefaultOutput>) Class.forName(
					input.getClass().getName().split(SPLIST_KEY)[0].concat(ADD_OUTPUT_CLASS_NAME));
			System.out.println(outputclazz.getName());

			return dao.dbExecute(tablename.concat(".search_pk"), input, outputclazz);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}

class CommonDao {
	public DefaultOutput dbExecute(String sqlId, DefaultInput input, Class<? extends DefaultOutput> outputclazz) {

		// ダミーのメイン処理のようなもの
		System.out.println(input.getClass().getName());
		System.out.println("SQL ID:" + sqlId);
		try {
			Method m = input.getClass().getMethod("getSearchWord");
			m.invoke(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 返却用クラスに値を設定
		DefaultOutput output = null;
		try {
			output = outputclazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		try {
			Method m = outputclazz.getMethod("setResult", String.class);
			m.invoke(output, "OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

}
