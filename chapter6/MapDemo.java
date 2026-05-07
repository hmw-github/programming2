package chapter6;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		//   key: party     value: percentage
		Map<String,         Integer> opinionPoll = new TreeMap<>();

		opinionPoll.put("AFD", 27);
		opinionPoll.put("CDU", 25);
		opinionPoll.put("SPD", 13);
		opinionPoll.put("Grüne", 16);
		opinionPoll.put("FDP", null);
		
		// loop over keys
		for (String party : opinionPoll.keySet()) {
			System.out.printf("%s: %d%%\n", party, opinionPoll.get(party));
		}
		
		/**
		 * Python:
		 * 
		 * opinionPoll = { "AFD":27, "CDU": 25 }
		 * for party in opinionPoll.keys():
		 * 	print("{0:s}: {1:d}%".format(party, opinionPoll[party])
		 */
		
		// is FDP present?
		if (opinionPoll.get("FDP") == null) {
			System.out.println("not found!");
		} else {
			System.out.println("FDP: " + opinionPoll.get("FDP"));			
		}
		
		// more elegant
		if (opinionPoll.containsKey("FDP")) {
			System.out.println("FDP: " + opinionPoll.get("FDP"));						
		}
	}

}
