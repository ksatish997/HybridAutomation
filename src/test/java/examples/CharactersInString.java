package examples;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CharactersInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		noOfRepeatedCharactersInString("including webpages, images,");
		
		noOfRepeatedCharactersInString("Comprehensive");

	}

	private static void noOfRepeatedCharactersInString(String str) {
		
		
		char[] allChars=str.toCharArray();
		
		HashMap<Character, Integer> hMap=new HashMap<Character, Integer>();
		
		for(int i=0;i<allChars.length;i++)
		{
			Character c=allChars[i];
			
			if(hMap.containsKey(c))
			{
				hMap.put(c, hMap.get(c)+1);
			}
			else
			{
				hMap.put(c, 1);
			}
			
		}
		
		System.out.println(hMap);
		
		Set<Entry<Character, Integer>> entries=hMap.entrySet();
		
		for(Entry<Character, Integer> entry:entries)
		{
			System.out.println(entry.getKey()+"-----"+entry.getValue());
		}
		
	}

}
