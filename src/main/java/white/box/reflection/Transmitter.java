package white.box.reflection;

import java.lang.reflect.Method;

/**
 * 処理呼び出しを中継するクラス。
 * 
 * @author seri
 */
public class Transmitter {

	/**
	 * boxDataに対して、processNameのメソッドを実行した結果を返却する。
	 * 
	 * @param boxData
	 * @param processName
	 * @return
	 */
	public TransmitData execute(TransmitData boxData, String processName) {
		B01 b01 = null;
		try {
			Method m = this.getClass().getMethod(processName, boxData.getTargetDto().getClass());
			b01 = (B01) m.invoke(this, boxData.getTargetDto());
		} catch (Exception e) {
			e.printStackTrace();
		}

		TransmitData resultData = new TransmitData();
		resultData.setTargetDto(b01);
		resultData.setDtoNote("transmitted data.");
		return resultData;
	}

	/**
	 * A01をB01にコピーし、Noteにコピーしたことを記載する。
	 * 
	 * @param a01
	 * @return A01の中身が設定されたB01
	 */
	public B01 copyAtoB(A01 a01) {
		System.out.println("--- copy DTO from A01 to B01 ---");

		B01 b01 = new B01();
		b01.setId(a01.getId());
		b01.setName(a01.getName());
		b01.setNote("copyed by A01.");
		return b01;
	}

}

class TransmitData {
	/** どんなDTOでも設定できるようにObject型で宣言 */
	private Object targetDto = null;
	private String dtoNote = null;

	public Object getTargetDto() {
		return targetDto;
	}

	public void setTargetDto(Object targetDto) {
		this.targetDto = targetDto;
	}

	public String getDtoNote() {
		return dtoNote;
	}

	public void setDtoNote(String dtoNote) {
		this.dtoNote = dtoNote;
	}
}

class A01 {
	private Integer id = null;
	private String name = null;

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
}

class B01 {
	private Integer id = null;
	private String name = null;
	private String note = null;

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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
