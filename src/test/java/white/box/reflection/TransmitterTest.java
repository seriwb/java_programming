package white.box.reflection;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransmitterTest {

	@Test
	public void test() {
		A01 a01 = new A01();
		a01.setId(Integer.valueOf(1));
		a01.setName("Transmit Tester");

		TransmitData targetData = new TransmitData();
		targetData.setTargetDto(a01);
		targetData.setDtoNote("original data.");

		Transmitter transmitter = new Transmitter();
		TransmitData result = transmitter.execute(targetData, "copyAtoB");

		// 結果確認
		System.out.println("--- show \"" + result.getDtoNote() + "\" ---");
		B01 b01 = (B01) result.getTargetDto();
		System.out.println("id:" + b01.getId() + "\nname:" + b01.getName() + "\nnote:" + b01.getNote());
	}

}
