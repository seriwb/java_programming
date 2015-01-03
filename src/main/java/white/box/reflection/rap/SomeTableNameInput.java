package white.box.reflection.rap;

/**
 * 実行メソッドへ渡す入力情報クラス
 * @author seri
 */
public class SomeTableNameInput extends DefaultInput {

	private String searchWord = null;
	private Integer limit = null;
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
