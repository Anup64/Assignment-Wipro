import java.util.HashSet;
import java.util.Set;

public class Prg2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new HashSet();
		
		set.add (1);
		set.add(2);
		set.add("one");
		set.add(3);
		set.add(1);
		
		for(Object o: set) {
			System.out.println(o);
		}
		
		

	}

}
