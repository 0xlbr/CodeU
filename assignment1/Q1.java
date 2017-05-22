import java.util.HashMap;
import java.util.Iterator;


public class Q1 {
	
	public static boolean permutations(String a, String b){
		
		if (a == null || b == null) throw new IllegalArgumentException();
		if (a.length() != b.length()) return false;
		
		a = a.toLowerCase();
		b = b.toLowerCase();
		
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		
		for (int i = 0; i < a.length(); i++) {
			chars.put(a.charAt(i), chars.getOrDefault(a.charAt(i), 0)+1);
			chars.put(b.charAt(i), chars.getOrDefault(b.charAt(i), 0)-1);
		}

		for (Character c:chars.keySet()){
			if (chars.get(c)!= 0) return false;
		}
	
	return true;
  
	}
}
