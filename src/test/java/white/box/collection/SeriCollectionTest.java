package white.box.collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class SeriCollectionTest {

	@Test
	public void testBuildMap() {
		SeriCollection serikore = new SeriCollection();
		Student[] students = new Student[5];
		
		students[0] = new Student(new Integer(1), "A", "male");
		students[1] = new Student(new Integer(2), "Bko", "female");
		students[2] = new Student(new Integer(3), "Cko", "female");
		students[3] = new Student(new Integer(4), "D", "male");
		students[4] = new Student(new Integer(5), "E?", "anything");
		
		Map<Integer, Student> map = serikore.buildMap(students);
		assertThat(map.get(Integer.valueOf(4)).getName(), is("D"));
//		StringBuilder sb = new StringBuilder();
//		System.out.println(sb.capacity());
	}
	
//	@Test
	public void testMerge() {
		String[] moji = new String[]{"A", "B", "C"};
		String[] tuika = new String[]{"X"};
		
		SeriCollection serikore = new SeriCollection();
		ArrayList<String> list = serikore.merge(moji, tuika);
		String[] strs = serikore.mergeKai(moji, tuika);
		
		for (String str: strs) {
			System.out.println(str);
		}
		
		for (String x: list) {
			System.out.println(x);
		}
	}
	
	

}
