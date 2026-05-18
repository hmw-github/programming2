package chapter7;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	static List<Integer> selectData(int[] inputs, int[] indexes) {
		List<Integer> list = new ArrayList<>();
		
		for (int index : indexes) {
			// ignore invalid index values
			if (index < 0 || index >= inputs.length) {
				continue;
			}
			list.add(inputs[index]);
		}
		
		return list;
	}

	static List<Integer> selectData2(int[] inputs, int[] indexes) {
		List<Integer> list = new ArrayList<>();

			for (int index : indexes) {
				try {
					list.add(inputs[index]);
				} catch (Exception e) {
					// ignore index value
				}
			}
		
		return list;
	}
	
	public static void main(String[] args) {
		List<Integer> result = selectData2(
				new int[] { -99, 23, 3, 0, 1000, 134 }, 
				new int[] { 1, 200, 0, -10 });
		for (int i : result) {
			System.out.println(i);
		}
	}

}
