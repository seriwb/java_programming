package white.box.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class SeriCollection {
	
	/**
	 * ハッシュテーブルのシンプル利用<br>
	 * 入力で受けたstudentsのHashMapを作成し、返却する。
	 * 
	 * @param students
	 * @return
	 */
	public HashMap<Integer, Student> buildMap(Student[] students) {
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		for (Student s : students) {
			map.put(s.getId(), s);
		}
		return map;
	}
	
	/**
	 * Stringの配列をListに変換し、更に追加で配列をListに追加し、Listを返却する。
	 * ※リストのサイズを増やす処理はO(n)
	 */
	public ArrayList<String> merge(String[] words, String[] more) {
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w: words) {
			sentence.add(w);
		}
		for (String w: more) {
			sentence.add(w);
		}
		return sentence;
	}
	
	public String[] mergeKai(String[] words, String[] more) {
		ArrayList<String> list = merge(words, more);
		return list.toArray(new String[list.size()]);
	}
}

class Student {
	private Integer id;
	private String name;
	private String sex;
	
	public Student(Integer id, String name, String sex) {
		setAll(id, name, sex);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setAll(Integer id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
}