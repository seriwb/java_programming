package white.box.reflection.rap;

import java.util.List;

/**
 * 実行メソッドから受け取る出力情報クラス
 * @author seri
 */
public class SomeTableNameOutput extends DefaultOutput {

	private String result = null;
	private List<String> errors = null;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
