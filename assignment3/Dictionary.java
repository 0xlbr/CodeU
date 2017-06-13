import java.util.ArrayList;

public class Dictionary {

private ArrayList<String> dictionary;
	
	public Dictionary(ArrayList<String> dictionary){
		this.dictionary = dictionary;
	}
	
	public boolean isWord(String word){
		return dictionary.contains(word);
	}
	
	public boolean isPrefix(String prefix){
		for(String word:dictionary){
			if (word.startsWith(prefix)){
				return true;
			}	
		}
		return false;
	}
}
