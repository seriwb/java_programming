package white.box.reflection;

import java.util.Objects;

/**
 * Javaのパッケージ情報を使ったリフレクション処理
 * 
 * @author seri
 */
public class PackageDesign {

	/**
	 * パラメータのクラスのパッケージを出力する。
	 * 
	 * @param target パッケージ情報を取得するオブジェクト
	 * @return パッケージ名の文字列
	 */
	public String getPackageString(Object target) {
		
		if (Objects.isNull(target)) {	// require 1.8
			return "";
		}
		
		return target.getClass().getPackage().getName();
	}
}
