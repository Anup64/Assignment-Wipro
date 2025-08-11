package coll1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		
		list.add("s");
		list.add("d");
		list.add("a");
		list.add("e");
		list.add(2,"j");
		
		Collections.sort(list);
		
		for(Object o: list) {
			System.out.println(o);
		}
		
		list.remove("d");
		System.out.println(list);
		
		list.add(5);
		System.out.println(list);
		
		list.remove(4);
		System.out.println(list);
		
		list.clear();
		System.out.println(list);
		

	}

}
