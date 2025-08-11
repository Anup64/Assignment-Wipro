import java.util.ArrayList;
import java.util.List;

public class Prg1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add(1);
		list.add("one");
		list.add(3);
		list.add(4);
		list.add(1);
		
		System.out.println(list.contains("one"));
		
		for(Object o:list) {
			System.out.println(o);
		}
	}

}
