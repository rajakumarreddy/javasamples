package org.raj;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstNonOccurenceCharacterOfString {

	public static void main(String[] args) {
		System.out.println(findFirstNonRepChar("Teacher"));
	}
	
	public static char findFirstNonRepChar(String string) {
		  Map<Character, AtomicInteger> characters = new LinkedHashMap<>(); // preserves order of insertion.
		  for (int i = 0; i < string.length(); i++) {
		    char c = string.charAt(i);
		    AtomicInteger n = characters.get(c);
		    if (n == null) {
		      n = new AtomicInteger(0);
		      characters.put(c, n);
		    }
		    n.incrementAndGet();
		  }
		  for (Map.Entry<Character, AtomicInteger> entry: characters.entrySet()) {
		    if (entry.getValue().get() == 1) {
		      return entry.getKey();
		    }
		  }
		  throw new RuntimeException("No unrepeated character");
		}
}
